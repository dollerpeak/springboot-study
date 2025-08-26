package com.shm.common.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.shm.common.exception.CustomExceptionData;
import com.shm.common.resultdata.ResultData;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GlobalAuthentication {

	public CustomUserDetails getCustomUserDetails() {
		log.info("===> GlobalAuthentication");
		CustomUserDetails customUserDetails = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication == null || authentication.getPrincipal().equals("anonymousUser")) {
			customUserDetails = null;
			log.info("로그인정보 없음");			
			
//			// throw new IllegalStateException("인증되지 않은 사용자");
//			ResultData resultData = new ResultData(HttpStatus.OK.value(), "[인증에러]", null, null, null);
//			resultData.setCode(HttpStatus.UNAUTHORIZED.value());
//			resultData.setMessage("로그인을 먼저 해주세요.");
//			resultData.setLog("401, 인증에러");
//			
//			throw new CustomExceptionData(resultData);
		} else {
			customUserDetails = (CustomUserDetails) authentication.getPrincipal();
			log.info("로그인정보 있음 : " + customUserDetails.toString());
		}

		return customUserDetails;
	}

}
