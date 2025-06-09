package com.study.common.exception;

import com.study.common.ResultData;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@SuppressWarnings("serial")
public class CustomException extends RuntimeException {
	ResultData resultData;
	
//	public CustomException(ResultData data) {
//		//super("어디에사용할까?");
//		resultData = data;
//	}
//	
//	public ResultData getResultData() {
//		return resultData;
//	}
	
}
