package com.shm.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class SecurityConfig {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	// 암호화 방식
	@Bean
	public PasswordEncoder passwordEncoder() {
		//log.info(">>> passwordEncoder 적용");
		return new BCryptPasswordEncoder();
		// 평문사용		
		//return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		//return NoOpPasswordEncoder.getInstance(); // 권장하지 않음
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		//log.info(">>> securityFilterChain 적용");
		
		// CSRF 사용 유무
		//http.csrf(csrf -> csrf.disable());

		// 페이지 접근허용
		// static 아래의 공용 리소스 허용 필요
		// - .requestMatchers("/js/**", "/css/**", "/file/**", "/image/**", "/media/**").permitAll()
		// - 인증이 필요한 페이지만 제외하고 전부 허용하는 방법으로 적용
		// spring security에서 사용하는 UserDetails를 사용할 경우 ROLE활용 가능
		// - .requestMatchers("/my", "/my/**").hasRole("ADMIN") // ADMIN, USER
		http.authorizeHttpRequests(auth -> auth //
				.requestMatchers("/user", "/user/**").authenticated() // 로그인 사용자
				.requestMatchers("/seller", "/seller/**").authenticated() // 로그인 판매자
				.requestMatchers("/admin", "/admin/**").authenticated() // 로그인 관리자
				.anyRequest().permitAll() // 모든 사용자
		);		
		
		// login, form방식으로만 작동
		http.formLogin(form -> form
				.loginPage("/login") // GET요청, 커스텀해서 만들 수 있음
				//.loginProcessingUrl("/login") // POST요청, 핸들러가 없어야 내부에서 자동 처리
				.usernameParameter("email") // form name, id tag
				.passwordParameter("password") // form password, id tag
				.defaultSuccessUrl("/") // 성공 시 리다이렉트, / 이게 안들어가면 에러발생
				.failureUrl("/login") // 실패 시 리다이렉트, / 이게 안들어가면 에러발생
				//.permitAll() // 
		);
		
		// logout, form방식으로만 작동
		http.logout(logout -> logout
				.logoutUrl("/logout") // POST요청
				.logoutSuccessUrl("/") // 로그아웃 후 이동할 URL
				.invalidateHttpSession(true) // 서버 세션 제거
				.clearAuthentication(true) // SecurityContext 제거
				.deleteCookies("JSESSIONID") // 클라이언트 쿠키도 삭제
				//.permitAll() //
		);
		
		// 인증에 사용될 service 적용
		http.userDetailsService(customUserDetailsService);		

		return http.build();
	}

//	// url DoubleSlash error
//	@Bean
//	public HttpFirewall allowUrlEncodedDoubleSlashHttpFirewall() {
//		StrictHttpFirewall strictHttpFirewall = new StrictHttpFirewall();
//		strictHttpFirewall.setAllowUrlEncodedDoubleSlash(true);
//
//		return strictHttpFirewall;
//	}

}
