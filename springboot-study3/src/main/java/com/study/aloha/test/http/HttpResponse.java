package com.study.aloha.test.http;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HttpResponse {
	Map<String, String> args;
	Map<String, String> data;
	Map<String, String> files;
	Map<String, String> form;
	Map<String, String> headers;
	String json;
	String origin;
	String url;
}

