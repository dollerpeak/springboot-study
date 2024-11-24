package com.study.metacoding.blog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.study.metacoding.blog.dto.UserDto;
import com.study.metacoding.blog.entity.UserEntity;
import com.study.metacoding.blog.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
	private final UserRepository userRepository;

	public int insert(UserDto nUserDto) throws Exception {
		int row;

		UserEntity userEntity = nUserDto.toUserEntity();
		row = userRepository.insert(userEntity);

		return row;
	}

	public UserDto selectUser(long id) throws Exception {
		UserEntity userEntity = userRepository.selectUser(id);
		// log.info("userEntity = " + userEntity);
		// log.info("userEntity.toString() = " + userEntity.toString());

		return userEntity.toUserDto();
	}

	public List<UserDto> selectAll() throws Exception {
		List<UserDto> userDtoList = new ArrayList<>();
		List<UserEntity> userEntityList = userRepository.selectAll();

		log.info("userEntityList.size() = " + userEntityList.size());
		for (UserEntity entity : userEntityList) {
			userDtoList.add(entity.toUserDto());
		}

		return userDtoList;
	}

}
