package com.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@GetMapping("/")
	public String home() {		
		log.info("HomeController, ======= study 전체");
		return "/home";
	}
	
//	@GetMapping("/html")
//	public String homeHtml() {
//		log.info("/html");
//		return "/home";
//	}
	
//	@GetMapping("/jsp")
//	public String homeJsp() {
//		log.info("/jsp");
//		return "/home";
//	}
}
