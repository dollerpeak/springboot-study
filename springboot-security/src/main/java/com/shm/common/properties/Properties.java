package com.shm.common.properties;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.yml")
public class Properties {
	private final Environment environment;

	public Properties(Environment environment) {
		this.environment = environment;
	}

	public String getProperties(String path) {
		return environment.getProperty(path);
	}

}
