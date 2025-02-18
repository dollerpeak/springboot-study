package com.study.config.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/around/logger")
@Tag(name = "LogBackController", description = "기능설명")
public class LogBackController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/test")
	@Operation(summary = "test", description = "log test")
	public void test() {
		logger.trace("logger, info");
		logger.debug("logger, debug");
		logger.info("logger, info");
		logger.warn("logger, warn");
		logger.error("logger, error");
	}
}
