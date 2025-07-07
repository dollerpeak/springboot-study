package com.shm.common.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
public class SecurityConfig {
	
//	// url DoubleSlash error
//	@Bean
//	public HttpFirewall allowUrlEncodedDoubleSlashHttpFirewall() {
//		StrictHttpFirewall strictHttpFirewall = new StrictHttpFirewall();
//		strictHttpFirewall.setAllowUrlEncodedDoubleSlash(true);
//
//		return strictHttpFirewall;
//	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf().disable()
//				.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
//				.httpBasic(); // HTTP 활성화
		
		// 인증, 인가
		http.authorizeHttpRequests(auth -> auth				
				.requestMatchers("/my", "/my/**").authenticated() // 로그인 사용자
				.requestMatchers("/seller", "/seller/**").authenticated() // 로그인 판매자
				.requestMatchers("/admin", "/admin/**").authenticated() // 로그인 관리자 
				.anyRequest().permitAll()); // 모든 사용자

		// static 아래의 모든 리소스
		// .anyRequest().permitAll() 모두 사용할 수 있어 제외
		//.requestMatchers("/js/**", "/css/**", "/file/**", "/image/**", "/media/**").permitAll()
		
		// 인가 예제
		// security에는 USER, ADMIN존재
		// 실제는 ROLE_ADMIN, ROLE_USER
		//.requestMatchers("/my", "/my/**").hasRole("ADMIN")

		return http.build();
	}

}
