package com.study.metacoding.blog.service;

import org.springframework.stereotype.Service;

import com.study.metacoding.blog.dto.UserDto;
import com.study.metacoding.blog.entity.UserEntity;
import com.study.metacoding.blog.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	public int insert(UserDto nUserDto) {
		int row;

		UserEntity userEntity = nUserDto.toUserEntity();
		row = userRepository.insert(userEntity);

		return row;
	}

}
