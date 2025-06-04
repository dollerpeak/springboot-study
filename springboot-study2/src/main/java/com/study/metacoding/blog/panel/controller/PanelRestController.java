package com.study.metacoding.blog.panel.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.common.ResultData;
import com.study.metacoding.blog.panel.dto.PanelDto;
import com.study.metacoding.blog.panel.service.PanelService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/metacoding/rest/panel")
@RequiredArgsConstructor
@Slf4j
public class PanelRestController {
	private final PanelService panelService;

	@PostMapping("/insert")
	public ResultData insertPanel(@RequestBody PanelDto nPanelDto, @AuthenticationPrincipal UserDetails nUserDetails) {
		ResultData resultData = new ResultData(ResultData.CODE_SUCCESS, null, null);

		try {
			resultData = panelService.insertPanel(nPanelDto, nUserDetails.getUsername());
		} catch (Exception e) {
			log.error("e = " + e.toString());
		}

		return resultData;
	}
	
	@DeleteMapping("/deletePanel/{nId}")
	public ResultData deletePanel(@PathVariable int nId) {
		ResultData resultData = new ResultData(ResultData.CODE_ERROR_SERVER, null, null);

		log.info("deletePanel");
		log.info("nId = " + nId);
		
		try {
			resultData = panelService.deletePanel(nId);
		} catch (Exception e) {
			log.error("e = " + e.toString());
		}
		
		return resultData;
	}
	
	@PostMapping("/update")
	public ResultData updatePanel(@RequestBody PanelDto nPanelDto, @AuthenticationPrincipal UserDetails nUserDetails) {
		ResultData resultData = new ResultData(ResultData.CODE_SUCCESS, null, null);
		log.info("updatePanel");
		
		try {
			nPanelDto.setLastChgUserId(nUserDetails.getUsername());
			resultData = panelService.update(nPanelDto);
		} catch (Exception e) {
			log.error("e = " + e.toString());
		}

		return resultData;
	}
	
}
