package com.study.around.service;

import org.springframework.http.ResponseEntity;

import com.study.around.data.dto.ProductDto;

public interface RestTemplateService {
	public String getHello();
	public String getParam();
	public String getVariable();
	public ResponseEntity<ProductDto> postParam();
	public ResponseEntity<ProductDto> postVariable();
	public ResponseEntity<ProductDto> postHeader();
}
