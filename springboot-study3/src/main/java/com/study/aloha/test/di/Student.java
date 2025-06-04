package com.study.aloha.test.di;

import org.springframework.stereotype.Component;

//import lombok.Data;

//@Data
@Component
public class Student extends Person {
	int studentId;
	String grade;

	public Student() {
		super();
		this.studentId = 1001;
		this.grade = "1";
	}

	@Override
	public String toString() {
		return "Student{name='" + getName() + "', age=" + getAge() + ", studentId=" + studentId + ", grade='" + grade
				+ "'}";
	}
}
