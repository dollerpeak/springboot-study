package com.shm.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shm.common.resultdata.ResultData;
import com.shm.user.UserDto;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/join")
@Slf4j
public class JoinRestController {
	@Autowired
	private JoinService joinService;

	@PostMapping("/join")
	public ResultData join(@RequestBody UserDto userDto) {
		log.info("===> JoinRestController");

		ResultData resultData = joinService.insert(userDto);

		return resultData;
	}

}
