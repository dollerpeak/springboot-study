package com.study.metacoding.blog.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.study.common.ResultData;
import com.study.metacoding.blog.login.service.LoginService;
import com.study.metacoding.blog.user.dto.UserDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class SecurityService implements UserDetailsService {
	private final LoginService loginService;

	// loginForm에서 넘어온 username
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ResultData resultData = new ResultData(ResultData.CODE_SUCCESS, null, null);
		UserDto userDto = new UserDto();
		
		log.info("==== SecurityService");

		try {
			userDto.setName(username);

			resultData = loginService.selectUserName(userDto);
			log.info("resultData.toString() = " + resultData.toString());

			userDto = (UserDto) resultData.getData().get(ResultData.TYPE_OBJECT);
			log.info("userDto.getId() = " + userDto.getId());
		} catch (Exception e) {
			userDto = null;
			log.error(e.toString());
		}

		// 패스워드까지 복호화 해서 비교
		// - 만약 암복화 비교 처리시 동일 hash, 즉 동일한 모듈로 처리 하지 않았다면.. 실패처리가 됨
		// - 예) WARN, Encoded password does not look like BCrypt
		return User.builder().username(userDto.getName()).password(userDto.getPassword()).roles(userDto.getRole())
				.build();
	}

}
