//package com.study.common.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//@ControllerAdvice
//public class CustomExceptionHandler {
//
//	//public ResponseEntity<CustomException> handle(HttpServletRequest nRequest, Exception nException) {
//	public ResponseEntity<CustomException> handle(HttpServletRequest nRequest, CustomException nCustomException) {
//		//CustomException customException = new CustomException();
////		exception.setErrorCode();
////		exception.setErrorMessage();
////		exception.setCustomCode();
////		exception.setCustomMessage("");
//		nCustomException.setMethod(nRequest.getMethod());
//		nCustomException.setUrl(nRequest.getRequestURL().toString());
//		nCustomException.setUri(nRequest.getRequestURI());
////		String[] trace;
//		
//		
//		return new ResponseEntity<>(exception, HttpStatus.OK);
//	}
//}
