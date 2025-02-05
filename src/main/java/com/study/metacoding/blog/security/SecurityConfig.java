package com.study.metacoding.blog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
	
	@Bean
	public HttpFirewall allowUrlEncodedDoubleSlashHttpFirewall() {
		StrictHttpFirewall strictHttpFirewall = new StrictHttpFirewall();
		strictHttpFirewall.setAllowUrlEncodedDoubleSlash(true);
		
		return strictHttpFirewall;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		log.info("==== SecurityConfig");
		
		http.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers("/metacoding/auth/**", "/WEB-INF/**", "/js/**", "/image/**", "/css/**").permitAll()
						.anyRequest().authenticated())
				.formLogin(login -> login.loginPage("/metacoding/auth/login/loginForm")
						.loginProcessingUrl("/metacoding/auth/loginProc")
						.usernameParameter("name").passwordParameter("password")
						.defaultSuccessUrl("/metacoding/home")
						.failureUrl("/metacoding/auth/login/loginForm"));
//				.logout(withde);
		
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

}

