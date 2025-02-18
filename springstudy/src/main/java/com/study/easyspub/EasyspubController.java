package com.study.easyspub;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/easyspub")
public class EasyspubController {
	
	String path = "/easyspub";
	
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
	
	@GetMapping("/viewport")
	public String testViewport() {
		return path + "/viewport";
	}
	
	@GetMapping("/flex")
	public String testFlex() {
		return path + "/flex";
	}
	
	@GetMapping("/grid")
	public String testGrid() {
		return path + "/grid";
	}
	
	@GetMapping("/js_ex")
	public String testJsEx() {
		return path + "/js_ex";
	}
	
	@GetMapping("/js_1")
	public String testJs1() {
		return path + "/js_1";
	}
	
	@GetMapping("/js_2")
	public String testJs2() {
		return path + "/js_2";
	}

}
