package com.shm.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

	@GetMapping("")
	public String main() {
		return "/login/login";
	}
	
//	@PostMapping("/loginin")
//	public String customLogin() {
//		log.info("=====> login");
//		return "/login/login";
//	}

}
