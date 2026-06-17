package com.erp.app.commoncode;

import com.erp.app.global.code.ResponseCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonCodeErrorCode implements ResponseCode {
	ERROR_001("001", "그룹코드는 필수 데이터 입니다."),
	ERROR_002("002", "코드는 필수 데이터 입니다."),
	ERROR_003("003", "코드명은 필수 데이터 입니다.");

	private final String code;
	private final String message;
}
