package com.shm.common.exception;

import com.shm.common.resultdata.ResultData;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@Slf4j
public class CustomExceptionData extends RuntimeException {
	private ResultData resultData;
}
