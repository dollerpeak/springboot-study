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
import com.shm.admin.AdminController;
import com.shm.common.exception.CustomExceptionData;
import com.shm.common.resultdata.ResultData;
import com.shm.user.UserDto;
import com.shm.user.UserEntity;
import com.shm.user.UserRepository;
import com.shm.user.UserRole;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class JoinService {

    private final AdminController adminController;
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;	
	
	@Autowired
	public JoinService(UserRepository userRepository, PasswordEncoder passwordEncoder, AdminController adminController) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.adminController = adminController;
	}

	public ResultData insert(UserDto userDto) {
		ResultData resultData = new ResultData(HttpStatus.OK.value(), "[회원가입]", null, null, null);
		Map<Object, Object> resultMap = new HashMap<>();
		
		UserEntity userEntity;
		List<UserEntity> userEntityList = new ArrayList<>();

		try {
			// user, seller, admin 구분은 우선 적용
			userDto.setRole(UserRole.ROLE_USER.getName());
			// 패스워드 암호화
			userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
			// 평문을 사용한다면 다르게 저장해야 함
			// - NoOpPasswordEncoder.getInstance(); 사용했다면 그냥 passwordEncoder를 그대로 사용
			// - PasswordEncoderFactories.createDelegatingPasswordEncoder(); 사용했다면 접두사로 암호화 알고리즘을 표기함
			// -- {bcrypt}, {sha256}
			// -- 만약 평문으로 하고 싶다면 아래처럼 적용해야 함
			//userDto.setPassword("{noop}" + userDto.getPassword());
			
			userDto.setFrstRegUserId(userDto.getEmail());
			userDto.setLastChgUserId(userDto.getEmail());
			userEntity = userDto.toEntity();
			userEntityList = userRepository.selectByEmail(userDto.getEmail());
			
			if (userEntityList.size() == 0) {
				log.info("userEntity = " + userEntity.toString());
				userRepository.insert(userEntity);
				
				resultData.setMessage("회원가입을 축하드립니다.");
				
				resultMap.put(ResultData.TYPE_OBJECT, userEntity);
				//resultMap.put(ResultData.TYPE_URL, "/custom/login");
				resultMap.put(ResultData.TYPE_URL, "/login");
				resultData.setData(resultMap);
			} else {
				resultData.setCode(HttpStatus.BAD_REQUEST.value());
				resultData.setMessage("다른 이메일을 사용해 주세요.");
				
				resultMap.put(ResultData.TYPE_URL, "/join");
				resultData.setData(resultMap);
			}
		} catch (Exception e) {
			log.error("e = " + e.toString());
			resultData.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			resultData.setMessage("회원가입에 실패했습니다.");
			resultData.setLog(e.toString());
			
			throw new CustomExceptionData(resultData);
		}
		log.info("resultData = " + resultData.toString());

		return resultData;
	}

}
