package com.shm.common.security;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		log.info("===> CustomAccessDeniedHandler");
		
//		String uri = request.getRequestURI();
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		boolean path = uri.startsWith("/user") || uri.startsWith("/seller") || uri.startsWith("/admin");
//		
//		if(path == true && (auth == null || auth.isAuthenticated() == false)) {
//			response.sendRedirect("/timeout");
//		} else {
//			//
//		}
		
		// 리다이렉트를 여기서 설정
		response.sendRedirect("/fail");

	}

}
