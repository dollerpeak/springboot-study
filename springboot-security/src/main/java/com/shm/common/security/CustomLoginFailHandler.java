package com.shm.common.security;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomLoginFailHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		log.info("===> CustomLoginFailHandler");

		// 추가적인 기능들
		// - 5, 10회 이상 연속해서 실패할 경우 별도 인증을 요청하는 기능

		// .failureUrl("/login")
		// - 리다이렉트를 여기서 설정 가능
		 response.sendRedirect("/login");
	}

}
