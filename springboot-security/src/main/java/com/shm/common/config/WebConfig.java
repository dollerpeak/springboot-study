package com.shm.common.config;

import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		log.info("===> addResourceHandlers");
		
		registry.addResourceHandler("/upload/**").addResourceLocations(
				"file:///" + Paths.get("../upload").toAbsolutePath().normalize().toString() + "/");
	}
}
