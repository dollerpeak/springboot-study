package com.shm.main;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.shm.common.security.CustomUserDetails;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
//@RequestMapping("/")
@Slf4j
public class MainController {

	@GetMapping({ "", "/" })
	public String main(HttpSession session, Authentication authentication) {
		log.info("=====> main");
		
		// test
		Object securityContext = session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
		if (securityContext != null) {
			log.info("=====> SecurityContext 존재: 로그인 되어 있음");
		} else {
			log.info("=====> SecurityContext 없음: 로그인 안되어 있음");
		}		
		log.info("=====> 세션 유지 시간 = " + session.getMaxInactiveInterval());
		
		if (authentication != null) {
			CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
			// dto
			log.info("=====> principal, email = " + customUserDetails.getUserDto().getEmail());
			log.info("=====> principal, name = " + customUserDetails.getUserDto().getName());
			log.info("=====> principal, password = " + customUserDetails.getUserDto().getPassword());
			log.info("=====> principal, role = " + customUserDetails.getUserDto().getRole());
//			// 필수정보
//			log.info("=====> principal, email = " + customUserDetails.getEmail());
//			log.info("=====> principal, name = " + customUserDetails.getName());
//			log.info("=====> principal, password = " + customUserDetails.getPassword());
//			log.info("=====> principal, role = " + customUserDetails.getRole());
		} else {
			log.info("=====> principal = " + authentication);
		}				
		
		
//		// 날짜
//		LocalDate today = LocalDate.of(2025, 2, 10);
//		log.info("=====> today : " + today.toString());
//		log.info("=====> year : " + today.getYear());
//		log.info("=====> dayyear : " + today.getDayOfMonth());
//		// 시간
//		LocalDateTime time = LocalDateTime.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//		// String format = "yyyy-MM-dd HH:mm:ss";
//		log.info("=====> now : " + time.toString());
//		log.info("=====> day : " + time.toLocalDate());
//		log.info("=====> time : " + time.toLocalTime());
//		log.info("=====> time : " + time.format(formatter));
//		
//		Timestamp timestamp = Timestamp.valueOf(time);
//		log.info("=====> timestamp : " + timestamp.toString());
		
		return "/main/main";
	}

}
