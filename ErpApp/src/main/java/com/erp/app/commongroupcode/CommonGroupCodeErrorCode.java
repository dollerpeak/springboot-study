package com.erp.app.commongroupcode;

import com.erp.app.global.code.ResponseCode;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonGroupCodeErrorCode implements ResponseCode {
	ERROR_001("001", "코드는 필수 데이터 입니다."),
	ERROR_002("002", "코드명은 필수 데이터 입니다.");
    
    private final String code;
    private final String message;
}
