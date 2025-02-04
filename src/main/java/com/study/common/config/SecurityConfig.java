package com.study.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public HttpFirewall allowUrlEncodedDoubleSlashHttpFirewall() {
		StrictHttpFirewall strictHttpFirewall = new StrictHttpFirewall();
		strictHttpFirewall.setAllowUrlEncodedDoubleSlash(true);
		
		return strictHttpFirewall;
	}
	
//	@Bean
//	public WebSecurityCustomizer webSecurityCustomizer() {
//		return (web) -> web.httpFirewall(allowUrlEncodedDoubleSlashHttpFirewall()).ignoring()
//				.requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//	}
	
//	@Bean
//	public WebSecurityCustomizer webSecurityCustomizer() {
//		return webSecurity -> webSecurity.httpFirewall(allowUrlEncodedDoubleSlashHttpFirewall()).ignoring()
//				.requestMatchers("/error");
//	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.cors(cors -> cors.disable())
				.authorizeHttpRequests(authorize -> authorize
		//http.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/metacoding/auth/**", "/WEB-INF/**", "/js/**", "/image/**", "/css/**").permitAll()
				.anyRequest().authenticated())
				.formLogin(login -> login.loginPage("/metacoding/auth/login/loginForm")
						.loginProcessingUrl("/metacoding/auth/login/login")
						.defaultSuccessUrl("/metacoding/home")
						.failureUrl("/metacoding/auth/login/loginForm"));

		return http.build();
	}
	
	@Bean
	public BCryptPasswordEncoder encodePassword() {
		return new BCryptPasswordEncoder();
	}
	

}
