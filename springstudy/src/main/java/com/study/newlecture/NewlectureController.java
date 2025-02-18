package com.study.newlecture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/newlecture")
public class NewlectureController {

	String path = "/newlecture";
	
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
	
	@GetMapping("/position")
	public String testPosition() {
		return path + "/position";
	}
	
	@GetMapping("/layout")
	public String testLayout() {
		return path + "/layout";
	}
	
}
