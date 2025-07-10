package com.shm.join;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/join")
@Slf4j
public class JoinController {

	@GetMapping("")
	public String main() {
		return "/join/join";
	}
	
	
	
}
