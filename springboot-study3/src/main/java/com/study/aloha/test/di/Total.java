package com.study.aloha.test.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
//@RequiredArgsConstructor
public class Total {
	@Autowired
	Person person;

	@Autowired
	Student student;

	public void print() {
		log.info("person : " + person.toString());
		log.info("student : " + student.toString());
	}
}
