package com.shm.login.custom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/custom/login")
@Slf4j
public class CustomLoginController {

	@GetMapping("")
	public String main() {
		log.info("===> CustomLoginController");
		return "/login/custom/login";
	}

}
