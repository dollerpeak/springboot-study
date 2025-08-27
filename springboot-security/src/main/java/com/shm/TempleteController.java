package com.shm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/templete")
@Slf4j
public class TempleteController {

	@GetMapping({ "", "/" })
	public String main() {
		log.info("===> main");
		
		return "/templete";
	}

}
