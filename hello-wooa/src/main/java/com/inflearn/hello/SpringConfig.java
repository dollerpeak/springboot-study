package com.inflearn.hello;

import javax.persistence.EntityManager;
//import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.inflearn.hello.repository.JdbcMemberRepository;
import com.inflearn.hello.repository.JdbcTemplateMemberRepository;
import com.inflearn.hello.repository.JpaMemberRepository;
import com.inflearn.hello.repository.MemberRepository;
import com.inflearn.hello.service.MemberService;

@Configuration
public class SpringConfig {

	private DataSource dataSource;
	private EntityManager entityManager;
	private MemberRepository memberRepository;
	
//	@Autowired
//	public SpringConfig(DataSource dataSource, EntityManager entityManager) {
//		this.dataSource = dataSource;
//		this.entityManager = entityManager;
//	}
	
	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

//	@Bean
//	public MemberService memberService() {
//		return new MemberService(memberRepository());
//	}
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository);
	}

	@Bean
	public MemberRepository memberRepository() {
		// return new MemoryMemberRepository();
		// return new JdbcMemberRepository(dataSource);
		// return new JdbcTemplateMemberRepository(dataSource);
		return new JpaMemberRepository(entityManager);
	}
}
