package com.shm.common.security;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		log.info("===> CustomAuthenticationEntryPoint");
		
		String uri = request.getRequestURI();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		boolean path = uri.startsWith("/user") || uri.startsWith("/seller") || uri.startsWith("/admin");
		
		if(path == true && (auth == null || auth.isAuthenticated() == false)) {			
			response.sendRedirect("/timeout");
		}
		
	}

}
