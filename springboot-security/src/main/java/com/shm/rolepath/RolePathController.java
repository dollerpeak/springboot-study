package com.shm.rolepath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shm.common.exception.CustomExceptionData;
import com.shm.common.resultdata.ResultData;
import com.shm.common.security.GlobalAuthentication;
import com.shm.user.UserDto;
import com.shm.user.UserRole;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/rolepath")
@Slf4j
public class RolePathController {
	private final GlobalAuthentication globalAuthentication;

	@Autowired
	public RolePathController(GlobalAuthentication globalAuthentication) {
		this.globalAuthentication = globalAuthentication;
	}

	@GetMapping("/division")
	public String main() {
		log.info("===> main");

		String path = "";

		UserDto userDto = globalAuthentication.getCustomUserDetails().getUserDto();
		//log.info("userDto = " + userDto.toString());

		if (userDto.getRole().equals(UserRole.ROLE_ADMIN.getName())) {
			path = "/admin";
		} else if (userDto.getRole().equals(UserRole.ROLE_SELLER.getName())) {
			path = "/seller";
		} else if (userDto.getRole().equals(UserRole.ROLE_USER.getName())) {
			path = "/user";
		} else {
			ResultData resultData = new ResultData(HttpStatus.OK.value(), "[내 정보]", null, null, null);

			resultData.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			resultData.setMessage("ROLE 정보가 명확하지 않습니다.");
			resultData.setLog("ROLE = " + userDto.getRole());

			throw new CustomExceptionData(resultData);
		}
		//log.info("path = " + path);

		return "redirect:" + path;
	}

}
