package com.study.common.exception;

import java.sql.ResultSet;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.study.common.ResultData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ControllerException {

//	@ExceptionHandler(Exception.class)
//	public String Exception(Model model, Exception msg) {
//		log.error("controller advice 에러");
//
//		// model.addAttribute("message","문제발생");
//		model.addAttribute("message", msg.getMessage());
//
//		return "/aloha/error";
//	}

	@ExceptionHandler(CustomException.class)
	public String CustomException(CustomException customException, Model model) {
		log.error("controller advice 에러");

		// model.addAttribute("message","문제발생");
		//model.addAttribute("message", msg.getMessage());
		
		model.addAttribute("resultData", customException.getResultData());

		return "/aloha/error";
	}
}
