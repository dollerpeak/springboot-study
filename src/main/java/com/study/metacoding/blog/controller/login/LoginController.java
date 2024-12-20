package com.study.metacoding.blog.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/metacoding/login")
@Slf4j
public class LoginController {

	@GetMapping("/login")
	public String login() {		
		return "/metacoding/login/login";
	}
	
	
}
