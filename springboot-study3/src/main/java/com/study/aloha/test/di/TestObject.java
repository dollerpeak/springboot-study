package com.study.aloha.test.di;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TestObject {
	int a;
	String b = "1";
	
	public TestObject() {
		a = 10;
		b = "2";		
	}

}
