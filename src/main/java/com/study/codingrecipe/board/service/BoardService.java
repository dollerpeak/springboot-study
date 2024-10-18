package com.study.codingrecipe.board.service;

import org.springframework.stereotype.Service;

import com.study.codingrecipe.board.dto.BoardDto;
import com.study.codingrecipe.board.entity.BoardEntity;
import com.study.codingrecipe.board.repository.BoardRepository;
import com.study.common.util.DateFormat;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;
	String defaultFrstRegUserId = "SYSTEM";
	String defaultLastChgUserId = "SYSTEM";

	public void insert(BoardDto boardDto) {
		// class전환
		BoardEntity boardentity = boardDto.toBoardEntity();
		
		// 예외처리
		if(boardentity.getFrstRegDate() == null || boardentity.getFrstRegDate().length() <= 0) {
			boardentity.setFrstRegDate(DateFormat.getFormatString(System.currentTimeMillis(), null));
		}
		if(boardentity.getFrstRegUserId() == null || boardentity.getFrstRegUserId().length() <= 0) {
			boardentity.setFrstRegUserId(defaultFrstRegUserId);
		}
		if(boardentity.getLastChgDate() == null || boardentity.getLastChgDate().length() <= 0) {
			boardentity.setLastChgDate(DateFormat.getFormatString(System.currentTimeMillis(), null));
		}
		if(boardentity.getLastChgUserId() == null || boardentity.getLastChgUserId().length() <= 0) {
			boardentity.setLastChgUserId(defaultLastChgUserId);
		}
		
		boardRepository.insert(boardentity);
	}
	
//	public void select() {
//		boardRepository.select();
//	}
}
