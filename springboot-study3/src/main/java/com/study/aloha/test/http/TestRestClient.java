package com.study.aloha.test.http;

import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestRestClient {
	RestClient restClient;
	ObjectMapper objectMapper;
	
	public TestRestClient() {
		// test site
		// - https://resttesttest.com/
		// - https://randomuser.me/api/
		restClient = RestClient.create();
		objectMapper = new ObjectMapper();
	}

	public void request() {
		// RestClient restClient = RestClient.create();

		// GET 요청
		String getResponse = restClient.get()
				.uri("https://httpbin.org/get")
				.retrieve()
				.body(String.class);																						// 가져옵니다.
		log.info("getResponse = " + getResponse);
		
		// POST 요청
		String postResponse = restClient.post()
		    	.uri("https://httpbin.org/post")
		        .contentType(MediaType.APPLICATION_JSON)
		        .body("{ key : value }")
		        .retrieve()
		        .body(String.class);
		log.info("postResponse = " + postResponse);
	}
}
