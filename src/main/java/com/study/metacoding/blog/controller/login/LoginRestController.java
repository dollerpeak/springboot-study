package com.study.metacoding.blog.controller.login;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.metacoding.blog.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/metacoding/login/rest")
@Slf4j
public class LoginRestController {

	@PostMapping("/login")
	public UserDto login(@RequestBody UserDto nUserDto) {
		log.info("nUserDto = " + nUserDto);
		return nUserDto;
	}
	
}
