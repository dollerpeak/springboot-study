package com.erpapp.app.hr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/hr")
public class EmployeeController {

	@GetMapping("")
	public String test() {
		log.info("test");
		return "test";
	}

}
