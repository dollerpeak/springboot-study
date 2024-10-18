package com.study.codingrecipe.board.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
//@Slf4j
public class BoardController {
	private final BoardService boardService;
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/insert")
	public String insert() {
		log.trace("log trace ===================");
		log.debug("log debug ===================");
		log.info("log info ===================");
		log.warn("log warn ===================");
		log.error("log error ===================");
		return "/codingrecipe/insert";
	}
	
	@PostMapping("/insert")
	public String insert(BoardDto boardDto) {
		boardService.insert(boardDto);
		
		return "/codingrecipe/home";
	}
	
//	@GetMapping("/select")
//	public String select() {
//		boardService.select();
//		
//		return "/codingrecipe/insert";
//	}
	
	
}


