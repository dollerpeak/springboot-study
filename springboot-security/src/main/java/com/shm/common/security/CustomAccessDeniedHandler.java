package com.shm.common.security;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	// 403 - 인가, 권한없음
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		log.info("===> CustomAccessDeniedHandler");
		
		String uri = request.getRequestURI();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		boolean path = uri.startsWith("/user") || uri.startsWith("/seller") || uri.startsWith("/admin");
		
//		if(path == true && (auth == null || auth.isAuthenticated() == false)) {
//			response.sendRedirect("/timeout");
//		} else {
//			//
//		}
		
		int httpStatus = HttpStatus.FORBIDDEN.value(); // 403
		String url = "/fail/error";
		String code = URLEncoder.encode("403", StandardCharsets.UTF_8);
		String title = URLEncoder.encode("[인가에러]", StandardCharsets.UTF_8);
		String message = URLEncoder.encode("권한이 없습니다.", StandardCharsets.UTF_8);
		String log = URLEncoder.encode("403, 인가에러", StandardCharsets.UTF_8);

		response.sendRedirect(url + "?code=" + code + "&title=" + title + "&message=" + message + "&log=" + log);	
	}

}
