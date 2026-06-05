package com.erp.app.global.response;

import com.erp.app.global.code.ResponseCode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiResponse<T> {
    private boolean success;
    private String code;
    private String message;
    private T data;
    
    public ApiResponse(boolean success, ResponseCode resultCode, T data) {
        this.success = success;
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }
}
