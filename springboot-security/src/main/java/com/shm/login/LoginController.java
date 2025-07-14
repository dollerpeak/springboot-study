package com.shm.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

	@GetMapping("")
	public String main() {
		return "/login/login";
	}
	
//	// from에서 요청하는 URL로 핸들러가 없어야 내부 처리가 가능
//	// - 만들어 둔다면 별도로 처리해야 함
//	@PostMapping("/loginin")
//	public String customLogin() {
//		return "/main/main";
//	}

}
