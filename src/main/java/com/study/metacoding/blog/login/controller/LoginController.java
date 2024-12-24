package com.study.metacoding.blog.login.controller;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.common.ResultData;
import com.study.metacoding.blog.dto.UserDto;
import com.study.metacoding.blog.login.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/metacoding/login")
@RequiredArgsConstructor
@Slf4j
public class LoginController {
	private final LoginService loginService;
	
	@Autowired
	HttpSession nHttpSession;
	@Autowired
	HttpServletRequest nHttpServletRequest;
	@Autowired
	HttpServletResponse nHttpServletResponse;

	@GetMapping("/loginForm")
	public String login() {		
		log.info("loginForm");
		return "/metacoding/login/loginForm";
	}
	
	@PostMapping("/login")
	@ResponseBody
	public ResultData login(@RequestBody UserDto nUserDto) {
		ResultData resultData = new ResultData(ResultData.CODE_SUCCESS, null, null);

		try {
			log.info("nUserDto = " + nUserDto);
			resultData = loginService.selectUser(nUserDto);
			
			if(nUserDto != null) {
				nHttpSession.setAttribute("principal", nUserDto);
			}			
			
		} catch (Exception e) {
			log.error("e = " + e.toString());
		}

		return resultData;
	}
	
	
}
