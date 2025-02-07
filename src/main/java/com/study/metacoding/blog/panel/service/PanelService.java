package com.study.metacoding.blog.panel.service;

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
import com.study.metacoding.blog.user.entity.UserEntity;
import com.study.metacoding.blog.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PanelService {
	private final PanelRepository panelRepository;	
	private final UserRepository userRepository;
	
	public ResultData insertPanel(PanelDto nPanelDto, String nUserName) throws Exception {
		ResultData resultData = new ResultData(ResultData.CODE_SUCCESS, null, null);
		Map<String, Object> resultMap = new HashMap<>();
		
		UserEntity userEntity;
		int count = 0;
		PanelEntity panelEntity;
		int row = 0; 		
		int maxid = 0;
		List<PanelEntity> panelEntityList = new ArrayList<>();
		int i;
		List<PanelDto> panelDtoList = new ArrayList<>();
		
		userEntity = new UserEntity();
		userEntity.setName(nUserName);
		count = userRepository.selectNameCount(userEntity);
		log.info("count = " + count);
		
		if (count > 0) {
			userEntity = userRepository.selectUserName(userEntity);
			log.info("userEntity = " + userEntity);
			
			nPanelDto.setUserId(userEntity.getId());
			log.info("nPanelDto.getTitle() = " + nPanelDto.getTitle());
			
			panelEntity = nPanelDto.toPanelEntity();
			log.info("panelEntity.getTitle() = " + panelEntity.getTitle());
			
			row = panelRepository.insert(panelEntity);
			log.info("row = " + row);
			
//			maxid = panelRepository.selectMaxId();
//			log.info("maxid = " + maxid);
			
//			panelEntity = panelRepository.select(maxid);
//			log.info("panelEntity.getTitle() = " + panelEntity.getTitle());
			panelEntityList = panelRepository.selectAll();
			log.info("panelEntityList.size() = " + panelEntityList.size());
			for (i = 0; i < panelEntityList.size(); i += 1) {
				panelDtoList.add(panelEntityList.get(i).toPanelDto());
			}
			
			resultMap.put(ResultData.TYPE_LIST, panelDtoList);
			resultData.setData(resultMap);
			resultData.setMessage("글쓰기 성공");
		} else {
			resultData.setMessage("작성자 계정이 없습니다.");
		}
		log.info(resultData.getMessage());

		return resultData;
	}
}
