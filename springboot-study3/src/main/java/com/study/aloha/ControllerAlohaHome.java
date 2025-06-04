package com.study.aloha;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/aloha")
public class ControllerAlohaHome {
	
	@GetMapping("/home")
	public String home() {
		log.info("<<<<<<<<<<<<<< Aloha Home >>>>>>>>>>>>>>");
		return "/aloha/home";
	}
}
