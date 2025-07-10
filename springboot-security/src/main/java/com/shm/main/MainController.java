package com.shm.main;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
//@RequestMapping("/")
@Slf4j
public class MainController {

	//@GetMapping({ "", "/" })
	@GetMapping("")
	public String main(HttpSession session) {
		log.info("=====> main");
		
		Object securityContext = session.getAttribute("SPRING_SECURITY_CONTEXT");
		if (securityContext != null) {
			log.info("=====> SecurityContext 존재: 로그인 되어 있음");
		} else {
			log.info("=====> SecurityContext 없음: 로그인 안되어 있음");
		}
		
		log.info("=====> 세션 유지 시간 = " + session.getMaxInactiveInterval());
		
		
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
	
//	// 로그인이 되었는지 확인하는 방법
//	@GetMapping("/debug-session")
//	public void debugSession(HttpSession session) {
//	    Object securityContext = session.getAttribute("SPRING_SECURITY_CONTEXT");
//	    if (securityContext != null) {
//	        System.out.println("✅ SecurityContext 존재: 로그인 되어 있음");
//	    } else {
//	        System.out.println("❌ SecurityContext 없음: 로그인 안 됨 또는 Security 미적용");
//	    }
//	    
//	    SecurityContext context = (SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
//	    Authentication auth = context.getAuthentication();
//	    System.out.println(auth.getName()); // 사용자 ID
//	    System.out.println(auth.getAuthorities()); // 권한 목록
//	}

}
