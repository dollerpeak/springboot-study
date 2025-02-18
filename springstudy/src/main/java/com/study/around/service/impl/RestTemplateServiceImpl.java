package com.study.around.service.impl;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.study.around.data.dto.ProductDto;
import com.study.around.service.RestTemplateService;

@Service
public class RestTemplateServiceImpl implements RestTemplateService{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
//	getForObject
//	getForEntity
//	postForObject
//	postForEntity
//	delete
//	put
//	patchForObject
//	exchange
	
	@Override
	public String getHello() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:8082")
				.path("/testreceiver/gethello")
				.encode()
				.build()
				.toUri();
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
		
		logger.info("responseEntity.getStatusCode() = {}", responseEntity.getStatusCode());
		logger.info("responseEntity.getHeaders() = {}", responseEntity.getHeaders());
		logger.info("responseEntity.getBody() = {}", responseEntity.getBody());
		
		return responseEntity.getBody();
	}
	
	@Override
	public String getParam() {
		// RestTemplate를 이용해서 get, param 호출 테스트
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:8082")
				.path("/testreceiver/getparam")
				.queryParam("param", "param test") // param 값 적용
				.encode()
				.build()
				.toUri();
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
		//String response = restTemplate.getForObject(uri, String.class);
		
		logger.info("responseEntity.getStatusCode() = {}", responseEntity.getStatusCode());
		logger.info("responseEntity.getHeaders() = {}", responseEntity.getHeaders());
		logger.info("responseEntity.getBody() = {}", responseEntity.getBody());		
		
		return responseEntity.getBody();
	}

	@Override
	public String getVariable() {
		// RestTemplate를 이용해서 get, variable 호출 테스트
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:8082")
				.path("/testreceiver/getvariable/{variable}")
				.encode()
				.build()
				.expand("variable test") // variable값 적용
				.toUri();
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);
		
		logger.info("responseEntity.getStatusCode() = {}", responseEntity.getStatusCode());
		logger.info("responseEntity.getHeaders() = {}", responseEntity.getHeaders());
		logger.info("responseEntity.getBody() = {}", responseEntity.getBody());
		
		return responseEntity.getBody();
	}

	@Override
	public ResponseEntity<ProductDto> postParam() {
		// RestTemplate를 이용해서 post, param 호출 테스트
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:8082")
				.path("/testreceiver/postparam")
				.queryParam("param", "param test") // param값적용
				.encode()
				.build()
				.toUri();
		
		ProductDto productDto = new ProductDto("id", "postParam", 1000, 12);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ProductDto> responseEntity = restTemplate.postForEntity(uri, productDto, ProductDto.class); //dto값 적용
		
		logger.info("responseEntity.getStatusCode() = {}", responseEntity.getStatusCode());
		logger.info("responseEntity.getHeaders() = {}", responseEntity.getHeaders());
		logger.info("responseEntity.getBody() = {}", responseEntity.getBody());
		
		return responseEntity;
	}

	@Override
	public ResponseEntity<ProductDto> postVariable() {
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:8082")
				.path("/testreceiver/postvariable/{variable}")
				.encode()
				.build()
				.expand("variable test") // variable값 적용
				.toUri();

		ProductDto productDto = new ProductDto("id", "postVariable", 1000, 12);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ProductDto> responseEntity = restTemplate.postForEntity(uri, productDto, ProductDto.class); //dto값 적용

		logger.info("responseEntity.getStatusCode() = {}", responseEntity.getStatusCode());
		logger.info("responseEntity.getHeaders() = {}", responseEntity.getHeaders());
		logger.info("responseEntity.getBody() = {}", responseEntity.getBody());
		
		return responseEntity;
	}

	@Override
	public ResponseEntity<ProductDto> postHeader() {
		// header값은 인증 값에 많이 사용됨
		URI uri = UriComponentsBuilder
				.fromUriString("http://localhost:8082")
				.path("/testreceiver/postheader")
				.encode()
				.build()
				.toUri();
		
		ProductDto productDto = new ProductDto("id", "postVariable", 1000, 12);
		
		// restTemplate.exchange를 통해 여러 method와 값을 적용할 수 있음
		RequestEntity<ProductDto> requestEntity = RequestEntity.post(uri).header("header-test", "header-value").body(productDto);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ProductDto> responseEntity = restTemplate.exchange(requestEntity, ProductDto.class);
		
		logger.info("responseEntity.getStatusCode() = {}", responseEntity.getStatusCode());
		logger.info("responseEntity.getHeaders() = {}", responseEntity.getHeaders());
		logger.info("responseEntity.getBody() = {}", responseEntity.getBody());
		
		return responseEntity;
	}

}
