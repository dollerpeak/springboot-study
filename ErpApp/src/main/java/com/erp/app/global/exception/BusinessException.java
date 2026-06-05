package com.erp.app.global.exception;

import com.erp.app.global.code.ResponseCode;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
public class BusinessException extends RuntimeException {
	private ResponseCode resultCode;

	public BusinessException(ResponseCode resultCode) {
		super(resultCode.getMessage());
		this.resultCode = resultCode;
	}
}
