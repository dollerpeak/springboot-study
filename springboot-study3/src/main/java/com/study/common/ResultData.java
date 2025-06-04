package com.study.common;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResultData {
	public static final String TYPE_OBJECT = "object"; // 하나의 결과
	public static final String TYPE_LIST = "list"; // 여러개의 결과

	private int code;
	private String message;
	private Map<?, ?> data;
}
