package com.shm.join;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
		ResultData resultData = new ResultData(HttpStatus.OK.value(), "[회원가입]", null, null, null);
		Map<String, String> resultMap = new HashMap<>();

		resultData = joinService.insert(userDto);
		if (resultData.getCode() == HttpStatus.OK.value()) {
			resultMap.put(ResultData.TYPE_URL, "/login");
			resultData.setData(resultMap);
		}
		log.info("resultData = " + resultData.toString());

		return resultData;
	}

}
