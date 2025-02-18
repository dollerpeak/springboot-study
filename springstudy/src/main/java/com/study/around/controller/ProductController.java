package com.study.around.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.around.data.dto.ProductDto;
import com.study.around.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/around/product")
@Tag(name = "ProductController", description = "기능설명")
public class ProductController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductService productService;
	ProductDto productDto;

	@GetMapping("/get/{productid}")
	@Operation(summary = "getProduct", description = "desc getProduct")
//	public ProductDto getProduct(@PathVariable String productid) {
	public ResponseEntity<ProductDto> getProduct(@PathVariable String productid) {
		productDto = productService.getProduct(productid);

//		return productDto;
		return ResponseEntity.status(HttpStatus.OK).body(productDto);
	}

	@PostMapping("/post")
	@Operation(summary = "createProduct", description = "desc createProduct")
	public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productdto) {
		productDto = productService.saveProduct(productdto);

		logger.info("product = {}", productDto.toString());

		return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
	}

}
