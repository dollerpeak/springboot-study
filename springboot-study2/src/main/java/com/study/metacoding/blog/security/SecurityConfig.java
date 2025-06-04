package com.study.metacoding.blog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
	
	// //, URL
	@Bean
	public HttpFirewall allowUrlEncodedDoubleSlashHttpFirewall() {
		StrictHttpFirewall strictHttpFirewall = new StrictHttpFirewall();
		strictHttpFirewall.setAllowUrlEncodedDoubleSlash(true);
		
		return strictHttpFirewall;
	}
	
	// security 설정
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		log.info("==== spring security config 적용");

		// 비활성화
		http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable());

		// 인증 주소 및 리소스 설정
		http.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/metacoding/auth/**", "/WEB-INF/**", "/js/**", "/image/**", "/css/**").permitAll()
				.anyRequest().authenticated());

		// login 설정
		http.formLogin(login -> login.loginPage("/metacoding/auth/login/loginForm")
				.loginProcessingUrl("/metacoding/auth/loginProc")
				.usernameParameter("name").passwordParameter("password")
				.defaultSuccessUrl("/metacoding/home")
				.failureUrl("/metacoding/auth/login/loginForm"));
		
//		// logout 설정
//		http.logout(logout -> logout.logoutUrl("/metacoding/logout") // 로그아웃 처리 URL (= form action url)
//				// .logoutSuccessUrl("/login") // logoutSuccessHandler가 있다면 효과 없으므로 주석처리.
//				.addLogoutHandler((request, response, authentication) -> {
//					// 사실 굳이 내가 세션 무효화하지 않아도 됨, LogoutFilter가 내부적으로 해줌.
//					HttpSession session = request.getSession();
//					if (session != null) {
//						session.invalidate();
//					}
//				})
//				// 로그아웃 핸들러 추가
//				.logoutSuccessHandler((request, response, authentication) -> {
//					response.sendRedirect("/metacoding/auth/login/loginForm");
//				})
//				// 로그아웃 후 삭제할 쿠키 지정
//				.deleteCookies("remember-me")); // .deleteCookies("JSESSIONID", "access_token")
		
		return http.build();
	}
	
	// security 암복호화 처리
	@Bean
	public PasswordEncoder passwordEncoder() {
		log.info("==== spring security 암복호화 적용");
		return new BCryptPasswordEncoder();
	}
	

}

