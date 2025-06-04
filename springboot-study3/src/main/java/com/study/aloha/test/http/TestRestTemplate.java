package com.study.aloha.test.http;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestRestTemplate {
	RestTemplate restTemplate;
	ObjectMapper objectMapper;

	public TestRestTemplate() {
		// test site
		// - https://resttesttest.com/
		// - https://randomuser.me/api/
		restTemplate = new RestTemplate();
		objectMapper = new ObjectMapper();
	}

	public void request() {
		// RestTemplate restTemplate = new RestTemplate();

		// GET 요청
		String getUrl = "https://httpbin.org/get";
//		String getUrl = "https://randomuser.me/api/";
		String getResponse = restTemplate.getForObject(getUrl, String.class);
		log.info("getResponse = " + getResponse);
		ResponseEntity<String> getResponseEntity = restTemplate.getForEntity(getUrl, String.class);
		log.info("getResponse, getStatusCode() = " + getResponseEntity.getStatusCode());
		log.info("getResponse, getHeaders() = " + getResponseEntity.getHeaders());
		log.info("getResponse, getBody() = " + getResponseEntity.getBody());
//		//objectMapper
//		try {
//			HttpResponse getHttpResponse = objectMapper.readValue(getResponseEntity.getBody(), HttpResponse.class);
//			log.info("getHttpResponse = " + getHttpResponse.toString());
//		} catch (JsonProcessingException e) {
//			log.error(e.toString());
//		}

		// POST 요청
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String requestData = "{ key : value }"; // json
		HttpEntity<String> request = new HttpEntity<>(requestData, headers);
		String postUrl = "https://httpbin.org/post";
		String postResponse = restTemplate.postForObject(postUrl, request, String.class);
		log.info("postResponse = " + postResponse);
		ResponseEntity<String> postResponseEntity = restTemplate.postForEntity(postUrl, request, String.class);
		log.info("postResponse, getStatusCode() = " + postResponseEntity.getStatusCode());
		log.info("postResponse, getHeaders() = " + postResponseEntity.getHeaders());
		log.info("postResponse, getBody() = " + postResponseEntity.getBody());
//		//objectMapper
//		try {
//			HttpResponse postHttpResponse = objectMapper.readValue(postResponseEntity.getBody(), HttpResponse.class);
//			log.info("postHttpResponse = " + postHttpResponse.toString());
//		} catch (JsonProcessingException e) {
//			log.error(e.toString());
//		}

	}
}
