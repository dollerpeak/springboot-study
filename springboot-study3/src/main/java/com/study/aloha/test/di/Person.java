package com.study.aloha.test.di;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Person {
	String name;
	int age;

	public Person() {
		this.name = "김조은";
		this.age = 20;
	}
}
