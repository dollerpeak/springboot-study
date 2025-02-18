package com.study.common.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends Exception {

	private HttpStatus httpStatus;
	private String exceptionMessage;
	private String message;

	public int getHttpStatusCode() {
		return httpStatus.value();
	}

	public String getHttpStatusSeries() {
		return httpStatus.series().toString();
	}

	public String getHttpStatusReasonPhrase() {
		return httpStatus.getReasonPhrase();
	}
}
