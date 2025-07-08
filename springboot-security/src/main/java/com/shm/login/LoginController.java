package com.shm.login;

import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

	@GetMapping("")
	public String main() {
		log.info("=====> main");
		return "/login/login";
	}
	
	@PostMapping("/login")
	public String login() {
		log.info("=====> login");
		return "/login/login";
	}

}
