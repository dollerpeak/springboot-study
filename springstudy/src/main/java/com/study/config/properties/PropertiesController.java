package com.study.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/around/properties")
public class PropertiesController {
//	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${spring.profiles.active}")
	String activeProfile;
	@Value("${server.port}")
	String serverPort;
	@Value("${test.config}")
	String testCofig;
	
	public PropertiesController(@Value("${server.port}") String serverport) {
		log.debug("log.debug, 생성자, serverport = " + serverport);
		log.info("log.info, 생성자, serverport = " + serverport);
		log.warn("log.warn, 생성자, serverport = " + serverport);
		log.error("log.error, 생성자, serverport = " + serverport);
//		logger.debug("log.debug, 생성자, serverport = " + serverport);
//		logger.info("log.info, 생성자, serverport = " + serverport);
//		logger.warn("log.warn, 생성자, serverport = " + serverport);
//		logger.error("log.error, 생성자, serverport = " + serverport);
	}

	@GetMapping("/getProperties")
	public String getProperties() {
//		logger.info("activeProfile = " + activeProfile);
//		logger.info("serverPort = " + serverPort);
//		logger.info("testCofig = " + testCofig);
		
		return serverPort;
	}
	
}
