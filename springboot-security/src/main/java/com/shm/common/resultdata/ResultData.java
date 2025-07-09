package com.shm.common.resultdata;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultData {
	public static final String TYPE_OBJECT = "object"; // 하나의 결과
	public static final String TYPE_LIST = "list"; // List<>에 여러개의 결과
	public static final String TYPE_URL = "url"; // String에 링크주소

	private int code;
	private String title;
	private String message;
	private String log;
	private Map<?, ?> data;
	
//	public void addMessage(String msg) {
//		message += "/n" + msg;
//	}
	
}


