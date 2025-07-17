package com.shm.logout.custom;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shm.common.resultdata.ResultData;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/custom/logout")
@Slf4j
public class CustomLogoutRestController {

	// security에서 처리하지 않고 수동처리
	@PostMapping("")
	public ResultData customLogout(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) {
		log.info("===> CustomLogoutRestController");

		ResultData resultData = new ResultData(HttpStatus.OK.value(), "[로그아웃]", "로그아웃 되었습니다.", null, null);
		Map<String, String> resultMap = new HashMap<>();
		
		boolean sessionTimeout = false;
		boolean auth = false;

		// 세션제거, .invalidateHttpSession(true)
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
			sessionTimeout = false;
		} else {
			// 세션 타임아웃
			sessionTimeout = true;
		}

		// SecurityContext 제거
		SecurityContextHolder.clearContext();

		// 클라이언트 쿠키 삭제
		Cookie cookie = new Cookie("JSESSIONID", null);
		cookie.setPath("/");
		cookie.setMaxAge(0); // 즉시 만료
		response.addCookie(cookie);
		
		// 인증정보 확인
		if (authentication != null) {
			auth = true;
		} else {
			auth = false;
		}
		
		// DB에 로그작성이 필요하다면 추가해볼만한 사항
		if (sessionTimeout == true) {
			// 세션타임아웃이면 무조건 인증정보가 없음
			if (auth == true) {
				log.info("timeout = O / auth = O, 로그아웃 필요 있음");
			} else {
				log.info("timeout = O / auth = X, 로그아웃 필요 없음");
			}
		} else {
			if (auth == true) {
				// 정상적인 로그아웃으로 DB 로그작성 가능
				log.info("timeout = X / auth = O, 로그아웃 필요 있음");
			} else {
				// 이런 경우는 없어야 겠지
				log.info("timeout = X / auth = X, 로그아웃 필요 없음");
			}
		}			
		
		// 로그아웃에 대해서는 메인화면으로 이동
		resultMap.put(ResultData.TYPE_URL, "/");
		resultData.setData(resultMap);

		log.info("resultData = " + resultData.toString());

		return resultData;
	}
}
