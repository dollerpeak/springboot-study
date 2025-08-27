package com.shm.common.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		log.info("===> onAuthenticationSuccess");

		// 추가적인 기능들
		// - 대표적으로 ID저장, 쿠키생성 작업 수행

		if (authentication != null) {
			CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
			log.info("principal, email = " + customUserDetails.getUserDto().getEmail());
			log.info("principal, name = " + customUserDetails.getUserDto().getName());
			log.info("principal, password = " + customUserDetails.getUserDto().getPassword());
			log.info("principal, role = " + customUserDetails.getUserDto().getRole());
			
			// .defaultSuccessUrl("/") 
			// - 리다이렉트를 여기서 설정 가능
			response.sendRedirect("/");			
		} else {
			log.info("인증정보 없음");
		}

		super.onAuthenticationSuccess(request, response, authentication);
	}

}
