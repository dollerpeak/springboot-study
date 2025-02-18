package com.study.codingrecipe.board.properties;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

//@Component
//@PropertySource("classpath:/properties/test.properties")
//public class PropertyApp {
//	@Autowired
//	private Environment environment;
//
//	@Value("${test.property.one}")
//	private String test1;
//	private String test2;
//	@Value("${test.property.list}")
//	private List<String> test3;
//
//	public String getTest1() {
//		return test1;
//	}
//
//	public String getTest2() {
//		test2 = environment.getProperty("test.property.two");
//		return test2;
//	}
//	
//	public List<String> getTest3() {
//		return test3;
//	}
//
//}
