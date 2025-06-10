package com.study.common.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {
//public class SecurityConfig implements UserDetailsService {

	// //, URL 등 에러 발생 시
//	@Bean
//	public HttpFirewall allowUrlEncodedDoubleSlashHttpFirewall() {
//		StrictHttpFirewall strictHttpFirewall = new StrictHttpFirewall();
//		strictHttpFirewall.setAllowUrlEncodedDoubleSlash(true);
//
//		return strictHttpFirewall;
//	}

	// security 암복호화 처리
	@Bean
	public PasswordEncoder passwordEncoder() {
		log.info("==== spring security 암복호화 적용");

		// 가장 권장되는 방식. 강력한 해시 + salt 사용. 반복 비용 조절 가능.
		return new BCryptPasswordEncoder();
		// 그대로 적용
		// return NoOpPasswordEncoder.getInstance();
	}

	// 임시로 메모리에 사용자 정보를 저장해서 테스트 가능
	@Bean
	public UserDetailsService users() {
		UserDetails user = User.builder().username("user").password(passwordEncoder().encode("1234")).roles("USER")
				.build();

		UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("abcd")).roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user, admin);
	}

}
