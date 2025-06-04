package com.study.metacoding.blog.panel.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.common.ResultData;
import com.study.common.util.DateFormat;
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
		
		UserEntity userEntity = null;
		int count = 0;
		PanelEntity panelEntity = null;
		int row = 0; 	
		
		// 유저 확인
		userEntity = new UserEntity();
		userEntity.setName(nUserName);
		count = userRepository.selectNameCount(userEntity);
		//log.info("count = " + count);
		
		if (count > 0) {
			//유저 있을때 
			
			// 유저정보 가져오기
			userEntity = userRepository.selectUserName(userEntity);
			log.info("userEntity = " + userEntity);
			
			// userid, 및 작성자 정보 설정
			nPanelDto.setUserId(userEntity.getId());
			nPanelDto.setFrstRegUserId(nUserName);
			nPanelDto.setLastChgUserId(nUserName);
			//log.info("nPanelDto.getTitle() = " + nPanelDto.getTitle());
			
			// 변환
			panelEntity = nPanelDto.toPanelEntity();
			//log.info("panelEntity.getTitle() = " + panelEntity.getTitle());
			
			// insert, useGeneratedKeys
			row = panelRepository.insert(panelEntity);
			// 성공여부
			log.info("row = " + row);
			// 리턴받은 pk적용
			log.info("panelEntity = " + panelEntity);
			
			resultMap.put(ResultData.TYPE_OBJECT, panelEntity.toPanelDto());
			resultData.setData(resultMap);
			resultData.setMessage("글쓰기 성공");
		} else {
			// 유저 없을때
			resultData.setMessage("작성자 계정이 없습니다.");
		}
		log.info(resultData.getMessage());

		return resultData;
	}

	public ResultData detailPanel(int nId, boolean nHits) throws Exception {
		ResultData resultData = new ResultData(ResultData.CODE_ERROR_SERVER, null, null);
		Map<String, Object> resultMap = new HashMap<>();
		
		PanelEntity panelEntity = null;
		int row = 0;
		
		// 조회
		panelEntity = panelRepository.select(nId);
		if (panelEntity == null) {
			resultData.setMessage(nId + " 게시물이 없음");
		} else {
			// 조회수 적용
			if (nHits == true) {
				panelEntity.setHits(panelEntity.getHits() + 1);
				row = panelRepository.updateHits(panelEntity);
				log.info("row = " + row);
			}
			
			panelEntity = panelRepository.select(nId);
			
			resultMap.put(ResultData.TYPE_OBJECT, panelEntity.toPanelDto());
			resultData.setData(resultMap);
			resultData.setCode(ResultData.CODE_SUCCESS);
			resultData.setMessage("조회 성공, nId = " + nId);
		}
		
		return resultData;		
	}

	public ResultData deletePanel(int nId) throws Exception {
		ResultData resultData = new ResultData(ResultData.CODE_ERROR_SERVER, null, null);
		Map<String, Object> resultMap = new HashMap<>();

		PanelEntity panelEntity = null;
		int row = 0;
		
		panelEntity = panelRepository.select(nId);
		log.info("panelEntity = " + panelEntity);
		
		row = panelRepository.delete(nId);
		log.info("row = " + row);

		if (row >= 1) {			
			resultMap.put(ResultData.TYPE_OBJECT, panelEntity.toPanelDto());
			resultData.setData(resultMap);
			resultData.setCode(ResultData.CODE_SUCCESS);
			resultData.setMessage(panelEntity.getTitle() + ", 글을 삭제했습니다.");
		} else {
			resultData.setMessage(nId + " 게시물이 없음");
		}

		return resultData;
	}

	public ResultData update(PanelDto nPanelDto) throws Exception {
		ResultData resultData = new ResultData(ResultData.CODE_ERROR_SERVER, null, null);
		Map<String, Object> resultMap = new HashMap<>();
		
		PanelEntity panelEntity = null;
		int row = 0;
		
		// 업데이트 정보
		nPanelDto.setLastChgDate(DateFormat.getFormatString(System.currentTimeMillis(), null));
		
		panelEntity = nPanelDto.toPanelEntity();
		log.info("panelEntity = " + panelEntity);
		row = panelRepository.update(panelEntity);
		log.info("row = " + row);
		
		panelEntity = panelRepository.select(panelEntity.getId());
		resultMap.put(ResultData.TYPE_OBJECT, panelEntity.toPanelDto());
		resultData.setData(resultMap);
		resultData.setCode(ResultData.CODE_SUCCESS);
		resultData.setMessage(panelEntity.getTitle() + ", 글을 수정했습니다.");
		
		return resultData;
	}
}
