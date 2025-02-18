package com.study.around.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.around.data.dto.ProductDto;
import com.study.around.service.RestTemplateService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/around/resttemplate")
@Tag(name = "RestTemplateController", description = "desc RestTemplateController")
public class RestTemplateController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	RestTemplateService service;
	
	@GetMapping("/gethello")
	@Operation(summary = "get url만 호출", description = "설명 블라블라..")
	public String getHello() {
		logger.info("getHello 호출");
		return service.getHello();
	}
		
	@GetMapping("/getparam")
	@Operation(summary = "get param test", description = "설명 블라블라..")
	public String getParam() {
		return service.getParam();
	}

	@GetMapping("/getvariable")
	@Operation(summary = "get variable test", description = "설명 블라블라..")
	public String getVariable() {
		return service.getVariable();
	}

	@GetMapping("/postparam")
	@Operation(summary = "post param test", description = "설명 블라블라..")
	public ResponseEntity<ProductDto> postParam() {
		return service.postParam();
	}

	@GetMapping("/postvariable")
	@Operation(summary = "post variable test", description = "설명 블라블라..")
	public ResponseEntity<ProductDto> postVariable() {
		return service.postVariable();
	}

	@GetMapping("/postheader")
	@Operation(summary = "post header test", description = "설명 블라블라..")
	public ResponseEntity<ProductDto> postHeader() {
		return service.postHeader();
	}
	
	
	
}
