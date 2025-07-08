package com.shm.common.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

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

		// 페이지 접근허용
		http.authorizeHttpRequests(auth -> auth //
				.requestMatchers("/user", "/user/**").authenticated() // 로그인 사용자
				.requestMatchers("/seller", "/seller/**").authenticated() // 로그인 판매자
				.requestMatchers("/admin", "/admin/**").authenticated() // 로그인 관리자
				.anyRequest().permitAll() // 모든 사용자
		); // 모든 사용자

		// static 아래의 모든 리소스
		// .anyRequest().permitAll() 모두 사용할 수 있어 제외
		// .requestMatchers("/js/**", "/css/**", "/file/**", "/image/**",
		// "/media/**").permitAll()

		// spring security에서 사용하는 UserDetails를 사용할 경우 ROLE활용 예
		// security에는 USER, ADMIN존재
		// 실제는 ROLE_ADMIN, ROLE_USER
		// .requestMatchers("/my", "/my/**").hasRole("ADMIN")
		
//		// login
//		http.formLogin(login -> login
//				.loginPage("/login")
//				.defaultSuccessUrl("")
//				); // 
		
		

		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		// 암호화 방식
		return new BCryptPasswordEncoder();
	}

}
