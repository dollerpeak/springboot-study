package com.shm.common.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class ControllerGlobalException {

	@ExceptionHandler(CustomExceptionData.class)
	public String customException(CustomExceptionData customExceptionData, Model model) {
		log.info("===> CustomException");
		
		model.addAttribute("title", customExceptionData.getResultData().getTitle());
		model.addAttribute("message", customExceptionData.getResultData().getMessage());
		model.addAttribute("log", customExceptionData.getResultData().getLog());
		
		return "/error/error";
	}

	@ExceptionHandler(Exception.class)
	public String genericException(Exception exception, Model model) {
		log.info("===> genericException = " + exception.toString());
		
		model.addAttribute("title", "에러");
		model.addAttribute("message", "에러가 발생했습니다.");
		model.addAttribute("log", exception.toString());
		
		return "/error/error";
	}

}
