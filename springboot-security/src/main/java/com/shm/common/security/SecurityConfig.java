package com.shm.common.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
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
	
//	@Autowired
//	private CustomLoginSuccessHandler customLoginSuccessHandler;
//	@Autowired
//	private CustomLoginFailHandler customLoginFailHandler;
//	@Autowired
//	private CustomAccessDeniedHandler customAccessDeniedHandler;

	// 암호화 방식
	@Bean
	public PasswordEncoder passwordEncoder() {
		log.info("===> passwordEncoder");
		return new BCryptPasswordEncoder();
		// 평문사용		
		//return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		//return NoOpPasswordEncoder.getInstance(); // 권장하지 않음
	}
	
	// AuthenticationManager
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		log.info("===> authenticationManager");
		return configuration.getAuthenticationManager();
	}

//	// url DoubleSlash error
//	@Bean
//	public HttpFirewall allowUrlEncodedDoubleSlashHttpFirewall() {
//		log.info("===> allowUrlEncodedDoubleSlashHttpFirewall");
//		StrictHttpFirewall strictHttpFirewall = new StrictHttpFirewall();
//		strictHttpFirewall.setAllowUrlEncodedDoubleSlash(true);
//
//		return strictHttpFirewall;
//	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		log.info("===> securityFilterChain");
		
		// CSRF 사용 유무
		// http.csrf(csrf -> csrf.disable());
		// token을 js에서 읽을 수 있게 cookie에 저장
		// - 기본설정값으로 작성하지 않음
		// http.csrf(csrf -> csrf
		// 		.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		// );
		// csrf 예외처리
		// - GET 방식보다 안전
		// - 로그아웃 시 세션타임아웃 상태에서 403에러 발생으로 적용
		http.csrf(csrf -> csrf
				.ignoringRequestMatchers("/api/custom/logout")
		);

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
		
//		// form 방식
//		// - login
//		http.formLogin(form -> form
//				.loginPage("/login") // GET요청, 커스텀해서 만들 수 있음
//				.loginProcessingUrl("/login") // POST요청, 핸들러가 없어야 내부에서 자동 처리
//				.usernameParameter("email") // form name, id tag
//				.passwordParameter("password") // form password, id tag
//				//.successHandler(customLoginSuccessHandler) // 로그인 성공, 별도 핸들러 구현시 적용
//				.defaultSuccessUrl("/") // 성공 시 리다이렉트, / 이게 안들어가면 에러발생
//				//.failureHandler(customLoginFailHandler) // 로그인 실패, 별도 핸들러 구현시 적용
//				.failureUrl("/login") // 실패 시 리다이렉트, / 이게 안들어가면 에러발생
//		);
		
//		// - logout
//		http.logout(logout -> logout
//				.logoutUrl("/logout") // POST요청
//				.logoutSuccessUrl("/") // 로그아웃 후 이동할 URL
//				.invalidateHttpSession(true) // 서버 세션 제거
//				.clearAuthentication(true) // SecurityContext 제거
//				.deleteCookies("JSESSIONID") // 클라이언트 쿠키도 삭제
//		);
		
//		//session이 완료되었을때 작동
//		// - 타임아웃, 인증 여부 순으로 체크
//		// - 인증여부와 관계없이 타임아웃만되면 처리됨 (cookie는 인증여부와 관계없이 생성됨)
//		http.sessionManagement(session -> session
//				.invalidSessionUrl("/timeout") // 세션완료시 리다이렉트
//		);
		
//		// 페이지별 예외적용, 리다이렉트
//		http.exceptionHandling(exception -> exception
//				.authenticationEntryPoint(new CustomAuthenticationEntryPoint())
//				//.authenticationEntryPoint((request, response, authException) -> {
//                //    // CustomAuthenticationEntryPoint 조건 구현
//                //})
//		);
		
//		// 인증(권한??) 예외적용, 리다이렉트
//		http.exceptionHandling(exception -> exception
//				.accessDeniedHandler(customAccessDeniedHandler)
//				.accessDeniedPage("/fail")
//		);
		
		
		// 인증에 사용될 service 적용
		http.userDetailsService(customUserDetailsService);		

		return http.build();
	}
	


}
