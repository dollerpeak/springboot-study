package com.study.codingrecipe;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@PropertySource("classpath:prefix.properties")
@ConfigurationProperties(prefix = "prefixtest") // prefixyaml, prefixpro, prefixtest
public class PropertiesPrefix {
	private int number;
	private String str;
	private List<String> list;
}