package com.shm.common.config;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class FaviconFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		// 요청 무시하고 로그도 남기지 않음
		if(httpServletRequest.getRequestURI().equals("/favicon.ico") == true) {
			((HttpServletResponse) response).setStatus(HttpServletResponse.SC_NO_CONTENT);
            return; 
		}
		
		chain.doFilter(request, response);
	}

	

}
