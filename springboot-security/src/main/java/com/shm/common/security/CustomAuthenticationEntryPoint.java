package com.shm.common.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		log.info("=====> CustomAuthenticationEntryPoint");
		HttpSession session = request.getSession(false);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String uri = request.getRequestURI();
		
		// 인증 path
		boolean authPath = uri.startsWith("/user") || uri.startsWith("/seller") || uri.startsWith("/admin");
		// logout path
		//boolean logoutPath = uri.startsWith("/logout");
		boolean logoutPath = uri.startsWith("/custom/logout");
		
		if (authPath == true) {
			if (session == null || auth == null || auth.isAuthenticated() == false) {
				response.sendRedirect("/login");
			} else {
        		// 관계없음 : 페이지, 기능 유지
        	}
		}

		if (logoutPath == true) {
			if (session == null || auth == null || auth.isAuthenticated() == false) {
				response.sendRedirect("/");
			} else {
				response.sendRedirect("/timeout");
			}
		} else {
			// 관계없음 : 페이지, 기능 유지
		}		
	}

}
