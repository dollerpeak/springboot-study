package com.study.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
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

}
