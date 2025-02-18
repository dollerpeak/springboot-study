package com.study.metacoding.blog.join.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.common.ResultData;
import com.study.common.RoleType;
import com.study.metacoding.blog.join.repository.JoinRepository;
import com.study.metacoding.blog.user.dto.UserDto;
import com.study.metacoding.blog.user.entity.UserEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class JoinService {
	private final JoinRepository joinRepository;
	private final PasswordEncoder passwordEncoder;

	public ResultData insertUser(UserDto nUserDto) throws Exception {
		ResultData resultData = new ResultData(ResultData.CODE_SUCCESS, null, null);
		Map<String, Object> resultMap = new HashMap<>();
		
		int count = 0;
		int row = 0;
		UserEntity userEntity = nUserDto.toUserEntity(); 

		count = joinRepository.selectNameCount(userEntity);
		log.info("count = " + count);
		
		if (count > 0) {
			// 기존유저
			resultData.setMessage("계정이 있습니다.");
		} else {
			// 신규유저
			nUserDto.setRole(RoleType.USER.name());
			// security 처리하는 암호화 모듈 적용
			nUserDto.setPassword(passwordEncoder.encode(nUserDto.getPassword()));
			userEntity = nUserDto.toUserEntity();
			List<UserEntity> userEntityList = new ArrayList<>();
			
			// 적용
			row = joinRepository.insertUser(userEntity);
			log.info("row = " + row);
			
			// name으로 select
			userEntityList = joinRepository.selectUser(userEntity);
			log.info("userEntityList.size() = " + userEntityList.size());
			
			// 1명이면 ok
			if (userEntityList.size() == 1) {
				resultMap.put(ResultData.TYPE_OBJECT, userEntityList.get(0).toUserDto());
				resultData.setData(resultMap);
				resultData.setMessage("회원가입 성공");
				
				log.info("userEntityList.get(0).toUserDto() = " + userEntityList.get(0).toUserDto());
			} else {
				// 여러명이면 문제
				resultData.setMessage(nUserDto.getName() + " 이 " + userEntityList.size() + " 명 존재합니다.");
			}
		}
		log.info(resultData.getMessage());

		return resultData;
	}

}
