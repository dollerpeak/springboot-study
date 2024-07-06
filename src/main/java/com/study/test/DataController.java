package com.study.test;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/data")
public class DataController {

	@GetMapping("/test")
	public String getTestPage() {
		return "home";
	}
	
	// data로 인식 됨
	@GetMapping("/model")
	public String getModel(Model model) {
		model.addAttribute("msg", "model");
		return "home";
	}
	
	// 실제 페이지가 표시됨
	@GetMapping("/modelandview")
	public ModelAndView getModelandView(ModelAndView modelandview) {
		modelandview.addObject("msg", "model and view");
		modelandview.setViewName("home");
		return modelandview;
	}
	
	
}
