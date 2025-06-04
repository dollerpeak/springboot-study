package com.study.w3school;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/w3school")
public class W3schoolController {
	
	String path = "/w3school";

	@GetMapping("/main")
	public String index() {
		return path + "/main";
	}
	
	@GetMapping("/html")
	public String testHtml() {
		return path + "/html";
	}
	
	@GetMapping("/css")
	public String testCss() {
		return path + "/css";
	}
	
	@GetMapping("/js")
	public String testJs() {
		return path + "/js";
	}
	
	@GetMapping("/jquery")
	public String testJquery() {
		return path + "/jquery";
	}
	
	@GetMapping("/ajax")
	public String testAjax() {
		return path + "/ajax";
	}

	@GetMapping("/jsp")
	public String testJsp() {
		return path + "/jsp";
	}
	
	@GetMapping("/responsive")
	public String testResponsive() {
		return path + "/responsive";
	}
	
	@GetMapping("/layout")
	public String testlayout() {
		return path + "/layout";
	}
	
}
