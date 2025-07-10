package com.shm.logout;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LogoutController {

	@GetMapping("/force-logout")
	public String forceLogout(HttpServletRequest request) {
	    request.getSession().invalidate();  // 세션 무효화 → 자동 로그아웃
	    return "redirect:/login?forced";
	}
	
}
