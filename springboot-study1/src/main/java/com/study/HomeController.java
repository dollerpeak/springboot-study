package com.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("/")
	public String index() {
		// return "index";
		return "/home";
	}
	
	@GetMapping("/home")
	public String home() {
		return "/home";
	} 
}
