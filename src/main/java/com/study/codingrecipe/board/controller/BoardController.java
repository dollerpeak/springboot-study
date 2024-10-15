package com.study.codingrecipe.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.codingrecipe.board.dto.BoardDto;
import com.study.codingrecipe.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/codingrecipe")
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("/insert")
	public String insert() {
		return "/codingrecipe/insert";
	}
	
	@PostMapping("/insert")
	//public String insert(@ModelAttribute BoardDto boardDto) {
	public String insert(BoardDto boardDto) {
		//System.out.println(boardDto.toString());
		System.out.println("controller");
		
		boardService.insert(boardDto);
		
		return "/codingrecipe/insert";
	}
	
	
}


