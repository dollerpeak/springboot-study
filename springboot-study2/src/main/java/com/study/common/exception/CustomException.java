package com.study.common.exception;

import lombok.Data;

@Data
@SuppressWarnings("serial")
public class CustomException extends RuntimeException {
	private String errorCode;
	private String errorMessage;
	private String customCode;
	private String customMessage;
	private String method;
	private String url;
	private String uri;
	private String[] trace;
}
