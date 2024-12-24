//package com.study.metacoding.blog.join.controller;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.study.common.ResultData;
//import com.study.metacoding.blog.dto.UserDto;
//import com.study.metacoding.blog.join.service.JoinService;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@RestController
//@RequestMapping("/metacoding/join/rest")
//@RequiredArgsConstructor
//@Slf4j
//public class JoinRestController {
//	private final JoinService joinService;
//
//	@PostMapping("/join")
//	public ResultData join(@RequestBody UserDto nUserDto) {
//		ResultData resultData = new ResultData(ResultData.CODE_SUCCESS, null, null);
//
//		try {
//			resultData = joinService.insertUser(nUserDto);
//		} catch (Exception e) {
//			log.error("e = " + e.toString());
//		}
//
//		return resultData;
//	}
//
//}
