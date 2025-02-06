package com.study.metacoding.blog.panel.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.common.ResultData;
import com.study.metacoding.blog.panel.dto.PanelDto;
import com.study.metacoding.blog.panel.service.PanelService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/metacoding/panel")
@RequiredArgsConstructor
@Slf4j
public class PanelController {
	private final PanelService panelService;

	@GetMapping("/insertForm")
	public String insertForm() {
		log.info("insertForm");
		return "/metacoding/panel/insertForm";
	}

	@PostMapping("/insertPanel")
	@ResponseBody
	public ResultData insertPanel(@RequestBody PanelDto nPanelDto, @AuthenticationPrincipal UserDetails nUserDetails) {
		ResultData resultData = new ResultData(ResultData.CODE_SUCCESS, null, null);
		PanelDto resultDto;

		try {
			panelService.insertPanel(nPanelDto, nUserDetails.getUsername());

			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put(ResultData.TYPE_OBJECT, nPanelDto);
			resultData.setData(resultMap);
			resultData.setMessage("글쓰기 성공");
		} catch (Exception e) {
			log.error("e = " + e.toString());
		}

		return resultData;
	}

//	@GetMapping("/updateForm")
//	public String updatePanel() {		
//		log.info("detailForm");
//		return "/metacoding/panel/saveForm";
//	}
//	
//	@GetMapping("/detailForm")
//	public String detailPanel() {		
//		log.info("detailForm");
//		return "/metacoding/panel/saveForm";
//	}

}
