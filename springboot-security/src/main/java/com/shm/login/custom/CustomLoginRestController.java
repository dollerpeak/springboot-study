package com.shm.login.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shm.common.resultdata.ResultData;
import com.shm.user.UserDto;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/custom/login")
@Slf4j
public class CustomLoginRestController {
	private final CustomLoginService customLoginService;
	
	@Autowired
	public CustomLoginRestController(CustomLoginService customLoginService) {
		this.customLoginService = customLoginService;
	}

	@PostMapping("")
	public ResultData customLogin(@RequestBody UserDto userDto, HttpServletRequest request) {
		log.info("===> CustomLoginRestController");

		ResultData resultData = customLoginService.select(userDto, request);

		return resultData;
	}

}
