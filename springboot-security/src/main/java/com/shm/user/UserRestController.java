package com.shm.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shm.common.resultdata.ResultData;
import com.shm.common.security.GlobalAuthentication;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserRestController {
	private final GlobalAuthentication globalAuthentication;
	private final UserService userService;

	@Autowired
	public UserRestController(GlobalAuthentication globalAuthentication, UserService userService) {
		this.globalAuthentication = globalAuthentication;
		this.userService = userService;
	}
	
	@GetMapping("/select/info")
	public ResultData selectWithInfoByEmail() {
		log.info("===> selectWithInfoByEmail");
		
		UserDto userDto = globalAuthentication.getCustomUserDetails().getUserDto();
		ResultData resultData = userService.selectWithInfoByEmail(userDto);
		
		return resultData;
	}
	
	//@GetMapping("/select/order")
	
	//@GetMapping("/select/return")

}
