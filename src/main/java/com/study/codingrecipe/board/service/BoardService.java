package com.study.codingrecipe.board.service;

import org.springframework.stereotype.Service;

import com.study.codingrecipe.board.dto.BoardDto;
import com.study.codingrecipe.board.repository.BoardRepository;

@Service
public class BoardService {
	BoardRepository boardRepository;

	public void insert(BoardDto boardDto) {
		System.out.println("service");
		boardRepository.insert(boardDto);
	}
}
