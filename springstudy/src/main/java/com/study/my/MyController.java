package com.study.my;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my")
public class MyController {
	
	String path = "/my";

	@GetMapping("/main")
	public String index(Model model) {
		//return path + "/main";
		
		model.addAttribute("id", "test value");
		return path + "/main";
		
	}
}
