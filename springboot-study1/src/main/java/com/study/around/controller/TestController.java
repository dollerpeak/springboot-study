package com.study.around.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestController {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private String test;
	
	void test() {
		log.info("test");
		logger.info("test");
	}

}
