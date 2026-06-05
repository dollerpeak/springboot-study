package com.erp.app.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.erp.app.global.code.CommonResponseCode;
import com.erp.app.global.code.ResponseCode;
import com.erp.app.global.response.ApiResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<Void>> handleAllException(Exception e) {
		log.error("e = ", e);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponse<>(
						false,
						CommonResponseCode.ERROR_SERVER.getCode(), 
						CommonResponseCode.ERROR_SERVER.getMessage(), 
						null));
	}
	
	@ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<Void>> handleBusinessException(BusinessException e) {
        ResponseCode resultCode = e.getResultCode();
        
        log.warn("Business Exception: [Code: {}] {}", resultCode.getCode(), resultCode.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body(new ApiResponse<>(
						false, 
						resultCode.getCode(), 
						resultCode.getMessage(), 
						null));
    }
}
