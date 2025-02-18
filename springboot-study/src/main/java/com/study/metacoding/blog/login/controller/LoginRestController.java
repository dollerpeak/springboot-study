//package com.study.metacoding.blog.login.controller;
//
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.study.common.ResultData;
//import com.study.metacoding.blog.dto.UserDto;
//import com.study.metacoding.blog.login.service.LoginService;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@RestController
//@RequestMapping("/metacoding/login/rest")
//@RequiredArgsConstructor
//@Slf4j
//public class LoginRestController {
//	private final LoginService loginService;
//
//	@PostMapping("/login")
//	public ResultData login(@RequestBody UserDto nUserDto) {
//		ResultData resultData = new ResultData(ResultData.CODE_SUCCESS, null, null);
//
//		try {
//			resultData = loginService.selectUser(nUserDto);
//		} catch (Exception e) {
//			log.error("e = " + e.toString());
//		}
//
//		return resultData;
//	}
//
//}
