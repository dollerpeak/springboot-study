package com.study.codingrecipe.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/codingrecipe")
public class HomeController {
	@GetMapping("/")
	public String save() {
		return "/codingrecipe/home";
	}
}
