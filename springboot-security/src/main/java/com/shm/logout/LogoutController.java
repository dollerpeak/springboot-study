//package com.shm.logout;
//
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import lombok.extern.slf4j.Slf4j;
//
//@Controller
//@RequestMapping("/logout")
//@Slf4j
//public class LogoutController {
//	
//	// test
//	@GetMapping({ "", "/" })
//	public String main() {
//		log.info("=====> main");
//		return "/main/main";
//	}
//
//	// security에서 처리하지 않고 수동처리
//	@PostMapping({ "", "/" })
//	public String customLogout(HttpServletRequest request, HttpServletResponse response) {
//		log.info("=====> customLogout");
//		
//		// 세션제거, .invalidateHttpSession(true)
//		HttpSession session = request.getSession(false);
//		if (session != null) {
//			session.invalidate();
//		}
//
//		// SecurityContext 제거, .clearAuthentication(true)
//		SecurityContextHolder.clearContext();
//
//		// 클라이언트 쿠키 삭제
//		Cookie cookie = new Cookie("JSESSIONID", null);
//		cookie.setPath("/");
//		cookie.setMaxAge(0); // 즉시 만료
//		response.addCookie(cookie);
//
//		return "redirect:/";
//	}
//
//}
