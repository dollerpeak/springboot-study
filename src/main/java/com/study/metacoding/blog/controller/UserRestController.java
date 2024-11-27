package com.study.metacoding.blog.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/select/{id}")
	public UserDto select(@PathVariable("id") int nId) {
		UserDto userDto = null;

		try {
			userDto = userService.select(nId);
		} catch (Exception e) {
			log.error("e = " + e.toString());
		}

		return userDto;
	}

	@GetMapping("/selectAll")
	public List<UserDto> selectAll() {
		List<UserDto> userDtoList = null;

		try {
			userDtoList = userService.selectAll();
		} catch (Exception e) {
			log.error("e = " + e.toString());
		}

		return userDtoList;
	}
	
	@PutMapping("/update/{id}")
	public int update(@PathVariable("id") int nId, @RequestBody UserDto nChangeUserDto) {
		// password, email 만 변경
		log.info(nChangeUserDto.toString());

		int row = -1;

		try {
			row = userService.update(nId, nChangeUserDto);
			log.info("row = " + row);
		} catch (Exception e) {
			log.error("e = " + e.toString());
		}

		return row;
	}

	@GetMapping("/delete/{id}")
	public int delete(@PathVariable("id") int nId) {
		int row = -1;

		try {
			row = userService.delete(nId);
		} catch (Exception e) {
			log.error("e = " + e.toString());
		}

		return row;
	}

}
