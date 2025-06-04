package com.study.metacoding.blog.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.common.ResultData;
import com.study.metacoding.blog.panel.dto.PanelDto;
import com.study.metacoding.blog.panel.entity.PanelEntity;
import com.study.metacoding.blog.panel.repository.PanelRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BlogService {
	private final PanelRepository panelRepository;

	public ResultData selectAll() throws Exception {
		ResultData resultData = new ResultData(ResultData.CODE_SUCCESS, null, null);
		Map<String, Object> resultMap = new HashMap<>();
		
		List<PanelEntity> panelEntityList = new ArrayList<>();
		int i;
		List<PanelDto> panelDtoList = new ArrayList<>();
		
		panelEntityList = panelRepository.selectAll();
		log.info("panelEntityList.size() = " + panelEntityList.size());
		for (i = 0; i < panelEntityList.size(); i += 1) {
			panelDtoList.add(panelEntityList.get(i).toPanelDto());
		}
		
		resultMap.put(ResultData.TYPE_LIST, panelDtoList);
		resultData.setData(resultMap);
		resultData.setMessage("글쓰기 성공");
		
		return resultData;
	}

}
