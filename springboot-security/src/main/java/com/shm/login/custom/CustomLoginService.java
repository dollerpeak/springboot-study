package com.shm.login.custom;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shm.common.exception.CustomExceptionData;
import com.shm.common.resultdata.ResultData;
import com.shm.user.UserDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class CustomLoginService {
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public ResultData select(UserDto userDto, HttpServletRequest request) {
		ResultData resultData = new ResultData(HttpStatus.OK.value(), "[로그인]", null, null, null);
		Map<String, String> resultMap = new HashMap<>();

		UsernamePasswordAuthenticationToken autoToken;
		Authentication authentication;
		
		try {
			// 인증
			autoToken = new UsernamePasswordAuthenticationToken(userDto.getEmail(), userDto.getPassword());
			authentication = authenticationManager.authenticate(autoToken);

			// SecurityContext 생성
			SecurityContextHolder.getContext().setAuthentication(authentication);

			// 세션에 SecurityContext 저장
			HttpSession session = request.getSession(true);
			session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
					SecurityContextHolder.getContext());

			resultMap.put(ResultData.TYPE_URL, "/");
			resultData.setData(resultMap);
		} catch (Exception e) {
			log.error("e = " + e.toString());
			resultData.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			resultData.setMessage("로그인에 실패했습니다.");
			resultData.setLog(e.toString());
			
			throw new CustomExceptionData(resultData);
		}	
		log.info("resultData = " + resultData.toString());
		
		return resultData;
	}
	
	
}




