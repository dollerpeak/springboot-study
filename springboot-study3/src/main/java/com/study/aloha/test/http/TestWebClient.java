package com.study.aloha.test.http;

//import org.springframework.http.MediaType;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestWebClient {
//	WebClient webClient;
//	ObjectMapper objectMapper;
//
//	public TestWebClient() {
//		// test site
//		// - https://resttesttest.com/
//		// - https://randomuser.me/api/
//		webClient = WebClient.create();
//		objectMapper = new ObjectMapper();
//	}
//
//	public void request() {
//		// WebClient webClient = WebClient.create();
//
//		// GET 요청
//		String getResponse = webClient.get()
//				.uri("https://httpbin.org/get")
//				.retrieve()
//				.bodyToMono(String.class)
//				.block();																									// 가져옵니다.
//		log.info("getResponse = " + getResponse);
//		
//		// POST 요청
//		String postResponse = webClient.post() // POST 요청
//				.uri("https://httpbin.org/post") // uri 지정
//				.contentType(MediaType.APPLICATION_JSON) // contentType 요청 헤더 설정
//				.body(BodyInserters.fromValue("{ key : value }")) // 요청 본문(body)을 설정
//				.retrieve() // 요청
//				.bodyToMono(String.class) // 스트림 형태로 받은 응답을 모노로 변환
//				.block();
//		log.info("postResponse = " + postResponse);
//	}
}
