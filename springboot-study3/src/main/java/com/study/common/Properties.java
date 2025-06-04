package com.study.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.yml")
public class Properties {
	@Autowired
	Environment environment;
	
	public String getProperties(String path) {
		return environment.getProperty(path);
	}
	
	
}
