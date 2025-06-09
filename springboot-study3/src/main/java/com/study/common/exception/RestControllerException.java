//package com.study.common.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import com.study.aloha.blog.BoardRestController;
//import com.study.common.ResultData;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@RestControllerAdvice
//public class RestControllerException {
//	
//	@ExceptionHandler(Exception.class)
//	public ResponseEntity<ResultData> Exception() {		
//		log.error("rest controller advice 에러");
//		ResultData resultData = new ResultData(500, "rest controller advice", null);
//				
//		return new ResponseEntity<>(resultData, HttpStatus.INTERNAL_SERVER_ERROR);
//	}
//}
