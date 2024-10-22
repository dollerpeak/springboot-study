package com.study.codingrecipe.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.codingrecipe.board.dto.BoardDto;
import com.study.codingrecipe.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/codingrecipe")
@RequiredArgsConstructor
@Slf4j
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("/home")
	public String home(Model model) {
		List<BoardDto> boardDtoList = selectAll();
		model.addAttribute("boardDtoList", boardDtoList);
		
		return "/codingrecipe/home";
	}
	
	@GetMapping("/insert")
	public String insert() {		
		return "/codingrecipe/insert";
	}
	
	@PostMapping("/insert")
	public String insert(BoardDto boardDto, Model model) {		
		boardService.insert(boardDto);
		log.info("insert, boardDto = " + boardDto.toString());
		
		List<BoardDto> boardDtoList = selectAll();
		model.addAttribute("boardDtoList", boardDtoList);
		
		return "/codingrecipe/home";
	}
	
	@GetMapping("/select")
	public String select(Model model) {
		List<BoardDto> boardDtoList = selectAll();
		model.addAttribute("boardDtoList", boardDtoList);
		
		return "/codingrecipe/home";
	}
	
	List<BoardDto> selectAll() {
		List<BoardDto> boardDtoList = boardService.selectAll();
		log.info("select, boardDtoList = " + boardDtoList.toString());
		
		return boardDtoList;
	}
	
	
}


