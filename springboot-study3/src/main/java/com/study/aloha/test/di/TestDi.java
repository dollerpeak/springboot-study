package com.study.aloha.test.di;

import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestDi {
	ApplicationContext applicationContext;

	public TestDi(ApplicationContext nApplicationContext) {
		applicationContext = nApplicationContext;
	}

	public void beanPrint() {
		String[] allBeanNames = applicationContext.getBeanDefinitionNames();
		// 조회된 빈 이름 출력
		for (String beanName : allBeanNames) {
			log.info(">>>>> bean name : " + beanName);
		}
	}
}
