package com.shm.fail;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/fail")
@Slf4j
public class FailController {

	@GetMapping("")
	public String main() {
		log.info("===> FailController");
		return "/fail/fail";
	}
	
	@GetMapping("/error")
	public String error(@RequestParam int code, @RequestParam String title, @RequestParam String message,
			@RequestParam String log, Model model) {
		this.log.info("===> error");
		
		model.addAttribute("code", code);
		model.addAttribute("title", title);
		model.addAttribute("message", message);
		model.addAttribute("log", log);		
		
		return "/fail/fail";
	}
	
}
