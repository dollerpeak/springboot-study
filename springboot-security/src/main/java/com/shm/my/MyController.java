package com.shm.my;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/my")
@Slf4j
public class MyController {

	@GetMapping({ "", "/" })
	public String my() {
		return "/my";
	}

}
