package com.shm.join;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shm.common.exception.CustomExceptionData;
import com.shm.common.resultdata.ResultData;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/join")
@Slf4j
public class JoinController {

	@GetMapping("")
	public String main() {
		log.info("===> JoinController");
		
		try {

			String a = "abc";
			int b = Integer.parseInt(a);	
		} catch (Exception e) {
			ResultData resultData = new ResultData(HttpStatus.OK.value(), "error", "대표message", e.toString(), null);
			throw new CustomExceptionData(resultData);
		}
		
		
		return "/join/join";
	}
	
	
	
}
