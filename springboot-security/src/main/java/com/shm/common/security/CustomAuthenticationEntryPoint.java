package com.shm.common.security;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	// 401 - 인증, 로그인 안됨
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		log.info("===> commence");
		
		String uri = request.getRequestURI();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		boolean path = uri.startsWith("/user") || uri.startsWith("/seller") || uri.startsWith("/admin");
		
//		if(path == true && (auth == null || auth.isAuthenticated() == false)) {
//			response.sendRedirect("/timeout");
//		} else {
//			//
//		}
		
		int httpStatus = HttpStatus.UNAUTHORIZED.value(); // 401
		String url = "/fail/error";
		String code = URLEncoder.encode("401", StandardCharsets.UTF_8);
		String title = URLEncoder.encode("[인증에러]", StandardCharsets.UTF_8);
		String message = URLEncoder.encode("로그인을 먼저 해주세요.", StandardCharsets.UTF_8);
		String log = URLEncoder.encode("401, 인증에러", StandardCharsets.UTF_8);

		response.sendRedirect(url + "?code=" + code + "&title=" + title + "&message=" + message + "&log=" + log);
	}

}
