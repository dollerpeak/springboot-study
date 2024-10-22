package com.study.codingrecipe.board.service;

import java.util.ArrayList;
import java.util.List;

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
	// private final TestMapper testMapper;

	String defaultFrstRegUserId = "SYSTEM";
	String defaultLastChgUserId = "SYSTEM";

	public void insert(BoardDto boardDto) {
		String nowtime = DateFormat.getFormatString(System.currentTimeMillis(), null);
		BoardEntity boardentity = boardDto.toBoardEntity();

		// 예외처리
		if (boardentity.getFrstRegDate() == null || boardentity.getFrstRegDate().length() <= 0) {
			boardentity.setFrstRegDate(nowtime);
		}
		if (boardentity.getFrstRegUserId() == null || boardentity.getFrstRegUserId().length() <= 0) {
			boardentity.setFrstRegUserId(defaultFrstRegUserId);
		}
		if (boardentity.getLastChgDate() == null || boardentity.getLastChgDate().length() <= 0) {
			boardentity.setLastChgDate(nowtime);
		}
		if (boardentity.getLastChgUserId() == null || boardentity.getLastChgUserId().length() <= 0) {
			boardentity.setLastChgUserId(boardentity.getFrstRegUserId());
		}

		boardRepository.insert(boardentity);
		// testMapper.insert(boardentity);
	}

	public List<BoardDto> selectAll() {
		List<BoardDto> boardDtoList = new ArrayList<>();
		List<BoardEntity> boardEntityList = boardRepository.selectAll();

		for (BoardEntity boardentity : boardEntityList) {
			BoardDto boarddto = boardentity.toBoardDto();
			boardDtoList.add(boarddto);
		}

		return boardDtoList;
	}

}
