package com.study.metacoding.blog.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/metacoding")
@Slf4j
public class BlogController {

	@GetMapping("/home")
	public String home() {		
		return "/metacoding/home";
	}
	
	@GetMapping("/test")
	public String test(HttpServletRequest nHttpServletRequest) {
		log.info("#######################");
		String path = nHttpServletRequest.getServletPath();
		log.info("원본 path = " + path);
		path = path + ".do";
		log.info("설정 path = " + path);
		
		int index = FilenameUtils.indexOfExtension(path);
		log.info("index = " + index);
		if(index != -1) {
			path = path.substring(1, index);
		}		
		log.info("최종 path = " + path);
		return "/metacoding/home";
	}
	
}


