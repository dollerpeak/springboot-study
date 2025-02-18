package com.study.metacoding.blog.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.common.util.DateFormat;
import com.study.metacoding.blog.user.dto.UserDto;
import com.study.metacoding.blog.user.entity.UserEntity;
import com.study.metacoding.blog.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class UserService {
	private final UserRepository userRepository;

	public int insert(UserDto nUserDto) throws Exception {
		int row;
		
		UserEntity userEntity = nUserDto.toUserEntity();
		row = userRepository.insert(userEntity);

		return row;
	}

	public UserDto select(int nId) throws Exception {
		UserEntity userEntity = userRepository.select(nId);
		userEntity = null;
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

	public int update(int nId, UserDto nChangeUserDto) throws Exception {
		int row = -1;
		
		UserEntity userEntity = userRepository.select(nId);
		userEntity.setPassword(nChangeUserDto.getPassword());
		userEntity.setEmail(nChangeUserDto.getEmail());
		userEntity.setLastChgDate(DateFormat.getFormatString(System.currentTimeMillis(), null));
		
		row = userRepository.update(userEntity);

		return row;
	}

	public int delete(int nId) throws Exception {
		int row = userRepository.delete(nId);

		return row;
	}

}
