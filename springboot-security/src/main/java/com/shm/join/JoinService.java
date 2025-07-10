package com.shm.join;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shm.common.resultdata.ResultData;
import com.shm.common.role.UserRole;
import com.shm.user.UserDto;
import com.shm.user.UserEntity;
import com.shm.user.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class JoinService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	public ResultData insert(UserDto userDto) {
		ResultData resultData = new ResultData(HttpStatus.OK.value(), "[회원가입]", null, null, null);
		Map<String, UserEntity> resultMap = new HashMap<>();
		
		UserEntity userEntity;
		List<UserEntity> userEntityList = new ArrayList<>();
		int seq;

		try {
			// user, seller, admin 구분은 우선 적용
			userDto.setRole(UserRole.ROLE_USER.getName());
			// 패스워드 암호화
			userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
			
			userEntity = userDto.toEntity();
			userEntityList = userRepository.selectByName(userDto.getName());
			
			if (userEntityList.size() == 0) {
				seq = userRepository.insert(userEntity);
				
				resultData.setMessage("회원가입을 축하드립니다.");
				resultMap.put(ResultData.TYPE_OBJECT, userEntity);
				resultData.setData(resultMap);
			} else {
				resultData.setCode(HttpStatus.BAD_REQUEST.value());
				resultData.setMessage("다른 아이디를 사용해 주세요.");
			}
		} catch (Exception e) {
			log.error("e = " + e.toString());
			resultData.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			resultData.setMessage("회원가입에 실패했습니다.");
			resultData.setLog(e.toString());
		}
		log.info("resultData = " + resultData.toString());

		return resultData;
	}

}
