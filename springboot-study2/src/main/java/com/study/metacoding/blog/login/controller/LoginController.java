package com.study.metacoding.blog.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.metacoding.blog.login.service.LoginService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/metacoding/auth/login")
@RequiredArgsConstructor
@Slf4j
public class LoginController {
//	private final LoginService loginService;
	
	@Autowired
	HttpSession nHttpSession;
	@Autowired
	HttpServletRequest nHttpServletRequest;
	@Autowired
	HttpServletResponse nHttpServletResponse;

	@GetMapping("/loginForm")
	public String login() {		
		log.info("LoginController, loginForm");
		return "/metacoding/login/loginForm";
	}
	
	// session 이용
//	@PostMapping("/login")
//	@ResponseBody
//	public ResultData login(@RequestBody UserDto nUserDto) {
//		ResultData resultData = new ResultData(ResultData.CODE_SUCCESS, null, null);
//		UserDto resultDto;
//
//		try {
//			log.info("nUserDto = " + nUserDto);
//			resultData = loginService.selectUser(nUserDto);
//			log.info("resultData.toString() = " + resultData.toString());
//			resultDto = (UserDto) resultData.getData().get(ResultData.TYPE_OBJECT);
//			log.info("resultDto.getId() = " + resultDto.getId());
//						
//			if(resultData.getData() != null) {
//				nHttpSession.setAttribute("principal", resultDto.getId());
//				nHttpSession.setMaxInactiveInterval(30);
//				
//				log.info("session make, resultDto.getId()");
//				log.info("nHttpSession.getMaxInactiveInterval() = " + nHttpSession.getMaxInactiveInterval());				
//			}
//			log.info("session = " + nHttpSession.getAttribute("principal"));
//			//log.info("nHttpSession.getCreationTime() = " + nHttpSession.getCreationTime());
//			//log.info("nHttpSession.getLastAccessedTime() = " + nHttpSession.getLastAccessedTime());
//			
//			//Enumeration<String> session = nHttpSession.getAttributeNames();
//			//while(session.hasMoreElements()) {
//			//	log.info("session.nextElement() = " + session.nextElement().toString());
//			//}
//		} catch (Exception e) {
//			log.error("e = " + e.toString());
//		}
//
//		return resultData;
//	}
	
}
