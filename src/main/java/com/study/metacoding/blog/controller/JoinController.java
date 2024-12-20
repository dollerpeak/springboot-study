package com.study.metacoding.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/metacoding/join")
@Slf4j
public class JoinController {

	@GetMapping("/join")
	public String login() {		
		return "/metacoding/join/join";
	}
	
}

