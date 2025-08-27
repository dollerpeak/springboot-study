package com.shm.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.shm.common.resultdata.ResultData;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalException {

	@ExceptionHandler(CustomExceptionData.class)
	public Object customException(CustomExceptionData customExceptionData, HttpServletRequest request) {
		log.info("===> CustomException");

		if (isRestRequest(request) == true) {
			log.info("RestController");
			
			// view로 해석됨
			//return customExceptionData.getResultData();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customExceptionData.getResultData());			
		} else {
			log.info("Controller");
			
			request.setAttribute("code", customExceptionData.getResultData().getCode());
			request.setAttribute("title", customExceptionData.getResultData().getTitle());
			request.setAttribute("message", customExceptionData.getResultData().getMessage());
			request.setAttribute("log", customExceptionData.getResultData().getLog());

			return "/fail/fail";
		}
	}

	@ExceptionHandler(Exception.class)
	public Object genericException(Exception exception, HttpServletRequest request) {
		log.info("===> genericException");

		if (isRestRequest(request) == true) {
			log.info("RestController");

			// view로 해석됨
			// return new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "에러", "에러가
			// 발생했습니다.", exception.toString(), null);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResultData(
					HttpStatus.INTERNAL_SERVER_ERROR.value(), "[generic 에러]", "에러가 발생했습니다.", exception.toString(), null));
		} else {
			log.info("Controller");
			
			request.setAttribute("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
			request.setAttribute("title", "[generic 에러]");
			request.setAttribute("message", "에러가 발생했습니다.");
			request.setAttribute("log", exception.toString());

			return "/fail/fail";
		}
	}

	private boolean isRestRequest(HttpServletRequest request) {
		//String accept = request.getHeader("Accept");
		//return accept != null && accept.contains("application/json");
		
		//log.info("uri = " + request.getRequestURI());
		
		return request.getRequestURI().startsWith("/api/");
	}

}
