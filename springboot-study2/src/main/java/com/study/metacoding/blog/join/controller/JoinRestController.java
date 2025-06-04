package com.study.metacoding.blog.join.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.common.ResultData;
import com.study.metacoding.blog.join.service.JoinService;
import com.study.metacoding.blog.user.dto.UserDto;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/metacoding/auth/rest/join")
@RequiredArgsConstructor
@Slf4j
public class JoinRestController {
	private final JoinService joinService;
	
	@PostMapping("/join")
	public ResultData join(@RequestBody UserDto nUserDto) {
		ResultData resultData = new ResultData(ResultData.CODE_SUCCESS, null, null);
		UserDto resultDto;

		try {
			log.info("nUserDto = " + nUserDto);
			resultData = joinService.insertUser(nUserDto);
			resultDto = (UserDto) resultData.getData().get(ResultData.TYPE_OBJECT);
			log.info("resultDto.getId() = " + resultDto.getId());

//			if (resultData.getData() != null) {
//				nHttpSession.setAttribute("principal", resultDto.getId());
//				nHttpSession.setMaxInactiveInterval(30);
//
//				log.info("session make, resultDto.getId()");
//				log.info("nHttpSession.getMaxInactiveInterval() = " + nHttpSession.getMaxInactiveInterval());
//			}
//			log.info("session = " + nHttpSession.getAttribute("principal"));
			//log.info("nHttpSession.getCreationTime() = " + nHttpSession.getCreationTime());
			//log.info("nHttpSession.getLastAccessedTime() = " + nHttpSession.getLastAccessedTime());

			//Enumeration<String> session = nHttpSession.getAttributeNames();
			//while (session.hasMoreElements()) {
			//	log.info("session.nextElement() = " + session.nextElement().toString());
			//}
		} catch (Exception e) {
			log.error("e = " + e.toString());
		}

		return resultData;
	}

}
