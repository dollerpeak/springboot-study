package com.shm.common.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.shm.common.resultdata.ResultData;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class RestControllerGlobalException {

	@ExceptionHandler(CustomExceptionData.class)
	public ResultData customException(CustomExceptionData customExceptionData) {
		log.info("===> CustomException");
		return customExceptionData.getResultData();
	}

	@ExceptionHandler(Exception.class)
	public ResultData genericException(Exception exception) {
		log.info("===> genericException");
		ResultData resultData = new ResultData(0, null, null, null, null);
		return resultData;
	}

}
