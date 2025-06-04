package com.study.common.exception;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@RestControllerAdvice
public class CustomExceptionHandler {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@ExceptionHandler(value = Exception.class)
	// public ResponseEntity<Map<String, Object>> ExceptionHandler(CustomException e) {
	public Map<String, Object> ExceptionHandler(CustomException e) {
		HttpHeaders httpheaders = new HttpHeaders();
		Map<String, Object> map = new HashMap<>();
		map.put("code", e.getHttpStatusCode());
		map.put("reason", e.getHttpStatusReasonPhrase());
		map.put("exceptionmessage", e.getExceptionMessage());
		map.put("message", e.getMessage());
		
		
		logger.error("custon exception = {}", map.toString());

		//return new ResponseEntity<>(map, httpheaders, e.getHttpStatus());
		return map;
		
	}

}
