package com.study.around.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.common.exception.CustomException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/around/exception")
@Tag(name = "ExceptionController", description = "custom exception 기능")
public class ExceptionController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/get")
	@Operation(summary = "get", description = "desc get")
	public void get() throws CustomException {
		throw new CustomException(HttpStatus.BAD_GATEWAY, "exception", "custom message");
	}
	
//	public void get() throws Exception {
//		throw new Exception();
//	}

//	@ExceptionHandler(value=Exception.class)
//	public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e){
//		HttpHeaders httpheaders = new HttpHeaders();
//		HttpStatus httpstatus = HttpStatus.BAD_REQUEST;
//		
//		logger.info("1111111111");
//		
//		logger.info("local = {}", e.getLocalizedMessage());
//		logger.info("string = {}", e.toString());
//		
//		Map<String, String> map = new HashMap<>();
//		map.put("type", httpstatus.getReasonPhrase());
//		map.put("code", "400");
//		map.put("message", "에러발생");
//		
//		//return ResponseEntity.status(HttpStatus.OK).body(map);
//		return new ResponseEntity<>(map, httpstatus);
//	}

}
