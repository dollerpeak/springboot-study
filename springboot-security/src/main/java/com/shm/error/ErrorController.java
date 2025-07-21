package com.shm.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/error")
@Slf4j
public class ErrorController {

	@GetMapping("")
	public String main() {
		log.info("===> ErrorController");
		return "/error/error";
	}
	
}
