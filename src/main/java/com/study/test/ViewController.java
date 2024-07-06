package com.study.test;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/view")
public class ViewController {

	@GetMapping("/page")
	public String getPage() {
		return "home";
	}
	
	@GetMapping("/data")
	@ResponseBody
	public String getData() {
		return "data";
	}
	
	@GetMapping("/data2")
	@ResponseBody
	public ResponseEntity<String> getResponseEntityData() {
		return ResponseEntity.ok("ResponseEntity data");
	}
	
	@GetMapping("/model")
	public String getModel(Model model) {
		model.addAttribute("msg", "model");
		return "home";
	}
	
	@GetMapping("/modelandview")
	public ModelAndView getModelandView(ModelAndView modelandview) {
		modelandview.addObject("msg", "model and view");
		modelandview.setViewName("home");
		return modelandview;
	}


}
