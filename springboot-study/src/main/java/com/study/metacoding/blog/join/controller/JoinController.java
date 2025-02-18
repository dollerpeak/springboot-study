package com.study.metacoding.blog.join.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.metacoding.blog.join.service.JoinService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/metacoding/auth/join")
@RequiredArgsConstructor
@Slf4j
public class JoinController {
	private final JoinService joinService;
	
//	@Autowired
//	HttpSession nHttpSession;
//	@Autowired
//	HttpServletRequest nHttpServletRequest;
//	@Autowired
//	HttpServletResponse nHttpServletResponse;

	@GetMapping("/joinForm")
	public String login() {
		log.info("JoinController, joinForm");
		return "/metacoding/join/joinForm";
	}
}

