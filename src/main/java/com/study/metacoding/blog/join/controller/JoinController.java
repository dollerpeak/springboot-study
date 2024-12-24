package com.study.metacoding.blog.join.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.common.ResultData;
import com.study.metacoding.blog.dto.UserDto;
import com.study.metacoding.blog.join.service.JoinService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/metacoding/join")
@RequiredArgsConstructor
@Slf4j
public class JoinController {
	private final JoinService joinService;

	@GetMapping("/joinForm")
	public String login() {
		log.info("joinForm");
		return "/metacoding/join/joinForm";
	}
	
	@PostMapping("/join")
	@ResponseBody
	public ResultData join(@RequestBody UserDto nUserDto) {
		ResultData resultData = new ResultData(ResultData.CODE_SUCCESS, null, null);

		try {
			log.info("nUserDto = " + nUserDto);
			resultData = joinService.insertUser(nUserDto);
		} catch (Exception e) {
			log.error("e = " + e.toString());
		}

		return resultData;
	}
}

