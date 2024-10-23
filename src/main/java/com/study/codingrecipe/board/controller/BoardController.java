package com.study.codingrecipe.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String home(Model nMmodel) {
		List<BoardDto> boarddtolist = selectAll();
		nMmodel.addAttribute("boarddtolist", boarddtolist);
		
		return "/codingrecipe/home";
	}
	
	@GetMapping("/insert")
	public String insert() {		
		return "/codingrecipe/insert";
	}
	
	@PostMapping("/insert")
	public String insert(BoardDto nBoardDto, Model nMmodel) {		
		int row = boardService.insert(nBoardDto);
		log.info("insert, nBoardDto = " + nBoardDto.toString());
		log.info("insert, row = " + row);
		
		List<BoardDto> boarddtolist = selectAll();
		nMmodel.addAttribute("boarddtolist", boarddtolist);
		
		return "/codingrecipe/home";
	}
	
	@GetMapping("/select")
	public String select(Model nMmodel) {
		List<BoardDto> boarddtolist = selectAll();
		nMmodel.addAttribute("boarddtolist", boarddtolist);
		
		return "/codingrecipe/home";
	}
	
	//@Transactional
	@GetMapping("/select/{seq}")
	public String selectSeq(@PathVariable("seq") long nSeq, Model nMmodel) {
		log.info("update hists, nSeq = " + nSeq);
		
		boardService.updateSeq(nSeq);
		BoardDto boarddto = selectSeq(nSeq);
		
		// @Transactional test 
		//String test = "abc";
		//Integer.parseInt(test);
		
		nMmodel.addAttribute("boarddto", boarddto);
		
		return "/codingrecipe/detail";
	}
	
	List<BoardDto> selectAll() {
		List<BoardDto> boarddtolist = boardService.selectAll();
		log.info("select all, boardDtoList = " + boarddtolist.toString());
		
		return boarddtolist;
	}
	
	BoardDto selectSeq(long seq) {
		BoardDto boarddto = boardService.selectSeq(seq);
		log.debug("select seq, boarddto = " + boarddto.toString());
		log.info("select seq, boarddto = " + boarddto.toString());
		
		return boarddto;
	}
	
	
}


