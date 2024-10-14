package com.study.codingrecipe;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1")
public class V1Controller {
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "hello jump to spring";
	}
	
	@GetMapping("/test")
	@ResponseBody
	public String test() {
		//System.out.println("index");
		return "index";
	}

}
