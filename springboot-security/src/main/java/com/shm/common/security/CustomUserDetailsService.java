package com.shm.common.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shm.user.UserEntity;
import com.shm.user.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {		
		log.info(">>> loadUserByUsername 호출");
		List<UserEntity> userEntityList = new ArrayList<>();
		UserEntity userEntity = null;
		
		try {
			userEntityList = userRepository.selectByName(name);
			if (userEntityList.size() == 1) {
				userEntity = userEntityList.get(0);
			}
		} catch (Exception e) {
			log.error("e = " + e.toString());
		}

//		// UserDetails을 사용하는 경우
//		return User.builder()
//	            .username(userEntity.getName())
//	            .password(userEntity.getPassword())
//	            .roles("USER") // 필수지만 role 기반 권한 쓰지 않을 경우 USER 하나만 줌
//	            .build();
		return new CustomUserDetails(userEntity.getName(), userEntity.getPassword());
	}

}
