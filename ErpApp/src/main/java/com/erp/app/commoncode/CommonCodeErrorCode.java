package com.erp.app.commoncode;

import com.erp.app.global.code.ResponseCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonCodeErrorCode implements ResponseCode {
	ERROR_001("001", "유효하지 않은 코드 값입니다."), 
	ERROR_002("002", "만료된 코드입니다.");

	private final String code;
	private final String message;
}
