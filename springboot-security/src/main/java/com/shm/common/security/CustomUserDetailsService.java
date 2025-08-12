package com.shm.common.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shm.user.UserEntity;
import com.shm.user.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {	
	private final UserRepository userRepository;
	
	@Autowired
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		log.info("===> loadUserByUsername, email = " + email);
		List<UserEntity> userEntityList = new ArrayList<>();
		UserEntity userEntity = null;

		try {
			userEntityList = userRepository.selectByEmail(email);
			if (userEntityList.size() == 1) {
				userEntity = userEntityList.get(0);
			}
		} catch (Exception e) {
			log.error("e = " + e.toString());
		}
		log.info("userEntity = " + userEntity);

//		// UserDetails을 사용하는 경우
//		return User.builder()
//	            .username(userEntity.getName())
//	            .password(userEntity.getPassword())
//	            .roles("USER") // 필수지만 role 기반 권한 쓰지 않을 경우 USER 하나만 줌
//	            .build();
//		// CustomUserDetails
//		return new CustomUserDetails(userEntity.getEmail(), userEntity.getName(), userEntity.getPassword(),
//				userEntity.getRole());
		// CustomUserDetails - UserDto
		return new CustomUserDetails(userEntity.toDto());
	}

}
