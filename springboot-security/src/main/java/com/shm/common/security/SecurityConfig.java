package com.shm.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.zaxxer.hikari.util.ClockSource.Factory;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class SecurityConfig {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	// 암호화 방식
	@Bean
	public PasswordEncoder passwordEncoder() {
		log.info(">>> passwordEncoder 적용");
		return new BCryptPasswordEncoder();
		// 평문사용
		//return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		log.info(">>> securityFilterChain 적용");
		
		// CSRF 사용 유무
		//http.csrf(csrf -> csrf.disable());

		// 페이지 접근허용
		http.authorizeHttpRequests(auth -> auth //
				.requestMatchers("/user", "/user/**").authenticated() // 로그인 사용자
				.requestMatchers("/seller", "/seller/**").authenticated() // 로그인 판매자
				.requestMatchers("/admin", "/admin/**").authenticated() // 로그인 관리자
				.anyRequest().permitAll() // 모든 사용자
		); // 모든 사용자

		// static 아래의 공용 리소스 허용
		// .requestMatchers("/js/**", "/css/**", "/file/**", "/image/**", "/media/**").permitAll()
		// 위에는 인증이 필요한 페이지만 제외하고 전부 허용하는 방법으로 적용

		// spring security에서 사용하는 UserDetails를 사용할 경우 ROLE활용 예
		// security에는 USER, ADMIN존재
		// 실제는 ROLE_ADMIN, ROLE_USER
		// .requestMatchers("/my", "/my/**").hasRole("ADMIN")
		
		// login
		http.formLogin(form -> form
				.loginPage("/login") // 페이지 접근허용이 되지 않을경우 리다이렉트, GET요청
				//.loginProcessingUrl(null) // POST요청
				.usernameParameter("name") // form name, id tag
				.passwordParameter("password") // form password, id tag
				.defaultSuccessUrl("/") // 성공 시 리다이렉트, / 이게 안들어가면 에러발생
				.failureUrl("/login") // 실패 시 리다이렉트, / 이게 안들어가면 에러발생
				.permitAll() // 이거 사용하면 csrf 예외 설정이 됨
		);
		
//		http.logout(logout -> logout
//				.logoutUrl("/logout") // 로그아웃 요청 URL
//				//.logoutSuccessUrl("/login?logout") // 로그아웃 후 이동할 URL
//				.invalidateHttpSession(true) // 세션 무효화
//				.deleteCookies("JSESSIONID") // JSESSIONID 쿠키 삭제
//				.permitAll() // 이거 사용하면 csrf 예외 설정이 됨
//		);
		
		// 인증에 사용될 service 적용
		http.userDetailsService(customUserDetailsService);
		

		return http.build();
	}
	
//	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> sessionCustomizer() {
//	    return factory -> factory.setSessionTimeout(Duration.ofMinutes(60));  // 60분 유지
//	}

//	// url DoubleSlash error
//	@Bean
//	public HttpFirewall allowUrlEncodedDoubleSlashHttpFirewall() {
//		StrictHttpFirewall strictHttpFirewall = new StrictHttpFirewall();
//		strictHttpFirewall.setAllowUrlEncodedDoubleSlash(true);
//
//		return strictHttpFirewall;
//	}

}
