package com.study.metacoding.blog.panel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.common.ResultData;
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
		log.info("PanelController, insertForm");
		return "/metacoding/panel/insertForm";
	}

	@GetMapping("/detailPanel/{nId}")
	public String detailPanel(@PathVariable int nId, Model nModel) {
		ResultData resultData = new ResultData(ResultData.CODE_ERROR_SERVER, null, null);
		
		log.info("detailPanel");
		log.info("nId = " + nId);
		
		try {
			resultData = panelService.detailPanel(nId, true);
			nModel.addAttribute(ResultData.TYPE_OBJECT, resultData.getData().get(ResultData.TYPE_OBJECT));
		} catch (Exception e) {
			log.error("e = " + e.toString());
		}
		
		return "/metacoding/panel/detailForm";
	}
	
	@GetMapping("/updateForm/{nId}")
	public String updateForm(@PathVariable int nId, Model nModel) {
		ResultData resultData = new ResultData(ResultData.CODE_ERROR_SERVER, null, null);
		log.info("PanelController, updateForm");

		try {
			resultData = panelService.detailPanel(nId, false);
			nModel.addAttribute(ResultData.TYPE_OBJECT, resultData.getData().get(ResultData.TYPE_OBJECT));
		} catch (Exception e) {
			log.error("e = " + e.toString());
		}

		return "/metacoding/panel/updateForm";
	}

}
