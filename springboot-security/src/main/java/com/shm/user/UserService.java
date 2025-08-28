package com.shm.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shm.common.exception.CustomExceptionData;
import com.shm.common.resultdata.ResultData;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public ResultData selectWithInfoByEmail(UserDto userDto) {
		ResultData resultData = new ResultData(HttpStatus.OK.value(), "[내정보]", null, null, null);
		Map<Object, Object> resultMap = new HashMap<>();

		List<UserEntity> userEntitylist;

		try {
			userEntitylist = userRepository.selectWithInfoByEmail(userDto.getEmail());
			if (userEntitylist.size() == 1) {
				resultMap.put(ResultData.TYPE_OBJECT, userEntitylist.get(0));
				resultData.setData(resultMap);
			} else {
				resultData.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
				resultData.setMessage("내 정보 조회를 실패했습니다.");
				resultData.setLog("중복 정보가 확인됩니다.");

				throw new CustomExceptionData(resultData);
			}
		} catch (Exception e) {
			log.error("e = " + e.toString());
			resultData.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			resultData.setMessage("내 정보 조회를 실패했습니다.");
			resultData.setLog(e.toString());

			throw new CustomExceptionData(resultData);
		}
		log.info("resultData = " + resultData.toString());

		return resultData;
	}

}
