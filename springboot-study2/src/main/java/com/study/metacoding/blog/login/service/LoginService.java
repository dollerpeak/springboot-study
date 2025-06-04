package com.study.metacoding.blog.login.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.common.ResultData;
import com.study.metacoding.blog.login.repository.LoginRepository;
import com.study.metacoding.blog.user.dto.UserDto;
import com.study.metacoding.blog.user.entity.UserEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class LoginService {
	private final LoginRepository loginRepository;

	public ResultData selectUser(UserDto nUserDto) throws Exception {
		ResultData resultData = new ResultData(ResultData.CODE_SUCCESS, null, null);
		Map<String, Object> resultMap = new HashMap<>();
		
		int count = 0;
		UserEntity userEntity = null;

		count = loginRepository.selectNameCount(nUserDto.toUserEntity());
		log.info("count = " + count);
		
		if (count > 0) {
			userEntity = loginRepository.selectUser(nUserDto.toUserEntity());
			
			if (userEntity != null) {
				resultMap.put(ResultData.TYPE_OBJECT, userEntity.toUserDto());
				resultData.setData(resultMap);
				resultData.setMessage("로그인 성공");
				
				log.info("userEntity.toUserDto() = " + userEntity.toUserDto());
			} else {
				// password 틀림
				resultData.setMessage("Password가 틀립니다.");
			}
		} else {
			// name 없음
			resultData.setMessage("계정이 없습니다.");
		}
		log.info(resultData.getMessage());

		return resultData;
	}
	
	// spring security
	public ResultData selectUserName(UserDto nUserDto) throws Exception {
		ResultData resultData = new ResultData(ResultData.CODE_SUCCESS, null, null);
		Map<String, Object> resultMap = new HashMap<>();
		
		int count = 0;
		UserEntity userEntity = null;

		count = loginRepository.selectNameCount(nUserDto.toUserEntity());
		log.info("spring security, count = " + count);
		
		if (count > 0) {
			userEntity = loginRepository.selectUserName(nUserDto.toUserEntity());
			
			if (userEntity != null) {
				resultMap.put(ResultData.TYPE_OBJECT, userEntity.toUserDto());
				resultData.setData(resultMap);
				resultData.setMessage("spring security, 로그인확인, name 판단 성공");
				
				log.info("userEntity.toUserDto() = " + userEntity.toUserDto());
			} else {
				// password 틀림
				resultData.setMessage("spring security, 무슨 이유지?");
			}
		} else {
			// name 없음
			resultData.setMessage("spring security, 계정이 없습니다.");
		}
		log.info(resultData.getMessage());

		return resultData;
	}

}
