package com.study.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
//@RequestMapping("/")
@Slf4j
//@RequiredArgsConstructor
public class ControllerMain {

	@GetMapping("/")
	String main() {
		log.info("<<<<<<<<<<<<<< Main >>>>>>>>>>>>>>");
		return "/main";
	}

}
