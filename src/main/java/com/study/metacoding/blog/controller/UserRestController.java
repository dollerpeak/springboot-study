package com.study.metacoding.blog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public int insert(@RequestBody UserDto nUserDto) {
		log.info(nUserDto.toString());

		int row = -1;

		try {
			row = userService.insert(nUserDto);
			log.info("row = " + row);
		} catch (Exception e) {
			log.error("e = " + e.toString());
		}

		return row;
	}

	@GetMapping("/selectUser/{id}")
	public UserDto selectUser(@PathVariable("id") int nId) {
		UserDto userDto = null;

		try {
			userDto = userService.selectUser(nId);
		} catch (Exception e) {
			log.error("e = " + e.toString());
		}

		return userDto;
	}

	@GetMapping("/selectAll")
	public List<UserDto> selectUser() {
		List<UserDto> userDtoList = null;

		try {
			userDtoList = userService.selectAll();
		} catch (Exception e) {
			log.error("e = " + e.toString());
		}

		return userDtoList;
	}

}
