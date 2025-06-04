package com.study.receiver.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.around.data.dto.ProductDto;



@RestController
@RequestMapping("/testreceiver")
public class TestReceiverController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/gethello")
	public String getHello() {
		// http://localhost:8082/testreceiver/hello
		String reval = "hello";
		logger.info("{}", reval);
		return reval;
	}
	
	@GetMapping("/getparam")
	public String getParam(@RequestParam String param) {
		// http://localhost:8082/testreceiver/param?param=value
		logger.info("@RequestParam = {}", param);		
		return param;
	}
	
	@GetMapping("/getvariable/{variable}")
	public String getVariable(@PathVariable String variable) {
		// http://localhost:8082/testreceiver/variable/value
		logger.info("@PathVariable = {}", variable);		
		return variable;
	}
	
	@PostMapping("/postparam")
	public ResponseEntity<ProductDto> postParam(@RequestBody ProductDto dto, @RequestParam String param) {
		logger.info("dto = {}", dto.toString());
		logger.info("@RequestParam = {}", param);		
		return ResponseEntity.status(HttpStatus.OK).body(dto);   
	}
	
	@PostMapping("/postvariable/{variable}")
	public ResponseEntity<ProductDto> postVariable(@RequestBody ProductDto dto, @PathVariable String variable) {
		logger.info("dto = {}", dto.toString());
		logger.info("@PathVariable = {}", variable);		
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	@PostMapping("/postheader")
	public ResponseEntity<ProductDto> postHeader(@RequestHeader(value="header-test") String header, @RequestBody ProductDto dto) {
		logger.info("header = {}", header);
		logger.info("dto = {}", dto.toString());		
		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	
}
