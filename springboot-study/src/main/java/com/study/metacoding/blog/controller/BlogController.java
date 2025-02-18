package com.study.metacoding.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.common.ResultData;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/metacoding")
@RequiredArgsConstructor
@Slf4j
public class BlogController {
	private final BlogService blogService;
	
//	@Autowired
//	HttpSession nHttpSession;
//	@Autowired
//	HttpServletRequest nHttpServletRequest;
//	@Autowired
//	HttpServletResponse nHttpServletResponse;

	@GetMapping("/home")
	public String home(@AuthenticationPrincipal UserDetails nUserDetails, Model nModel) {
		ResultData resultData = new ResultData(ResultData.CODE_SUCCESS, null, null);
		
		log.info("======= metacoding home, BlogController");
		
		// session 테스트
//		if(nHttpSession.getAttribute("principal") != null) {			
//			log.info("session principal = " + nHttpSession.getAttribute("principal"));
//			
//			//log.info("nHttpSession.getMaxInactiveInterval() = " + nHttpSession.getMaxInactiveInterval());
//			//log.info("nHttpSession.getCreationTime() = " + DateFormat.getFormatString(nHttpSession.getCreationTime(), null));
//			//log.info("nHttpSession.getLastAccessedTime() = " + DateFormat.getFormatString(nHttpSession.getLastAccessedTime(), null));
//		} else {
//			log.info("session principal is null");
//		}		
		
		// security, UserDetails 정보, 로그인된 정보
		log.info("nUserDetails = " + nUserDetails.toString());
		
		try {
			resultData = blogService.selectAll();
			nModel.addAttribute("list", resultData.getData().get(ResultData.TYPE_LIST));
		} catch (Exception e) {
			log.error("e = " + e.toString());
		}

		return "/metacoding/home";
	}
	
//	@GetMapping("/login")
//	public String login() {		
//		return "/metacoding/user/login";
//	}
	
//	@GetMapping("/test")
//	public String test(HttpServletRequest nHttpServletRequest) {
//		log.info("#######################");
//		String path = nHttpServletRequest.getServletPath();
//		log.info("원본 path = " + path);
//		path = path + ".do";
//		log.info("설정 path = " + path);
//		
//		int index = FilenameUtils.indexOfExtension(path);
//		log.info("index = " + index);
//		if(index != -1) {
//			path = path.substring(1, index);
//		}		
//		log.info("최종 path = " + path);
//		return "/metacoding/home";
//	}
	
}


