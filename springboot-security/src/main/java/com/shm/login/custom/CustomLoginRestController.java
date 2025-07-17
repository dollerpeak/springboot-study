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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shm.common.resultdata.ResultData;
import com.shm.user.UserDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/custom/login")
@Slf4j
public class CustomLoginRestController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("")
	public ResultData customLogin(@RequestBody UserDto userDto, HttpServletRequest request) {
		log.info("===> CustomLoginRestController");

		ResultData resultData = new ResultData(HttpStatus.OK.value(), "[로그인]", "로그인 되었습니다.", null, null);
		Map<String, String> resultMap = new HashMap<>();

		UsernamePasswordAuthenticationToken autoToken;
		Authentication authentication;

		// 여기서 try, catch를 사용하면 @ControllerAdvice 처리가 안되므로 사용하지 않는다.
		
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
		
		log.info("resultData = " + resultData.toString());

		return resultData;
	}

}
