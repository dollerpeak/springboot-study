package com.study.metacoding.blog.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.metacoding.blog.dto.UserDto;
import com.study.metacoding.blog.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/metacoding/user")
@RequiredArgsConstructor
@Slf4j
public class UserRestController {
	private final UserService userService;
	
	@PostMapping("/insert")
	public String insert(@RequestBody UserDto nUserDto) {
		int row;
		
		log.info(nUserDto.toString());
		row = userService.insert(nUserDto);
		log.info("row = " + row);
	
		return nUserDto.toString();
	}

}
