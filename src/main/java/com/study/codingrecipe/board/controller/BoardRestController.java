package com.study.codingrecipe.board.controller;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.codingrecipe.board.dto.BoardDto;
import com.study.codingrecipe.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/codingrecipe/test")
@RequiredArgsConstructor
@Slf4j
public class BoardRestController {
	private final BoardService boardService;
	
	// @PathVariable
	@GetMapping("/select1/{seq}")
	public ResponseEntity<BoardDto> select1(@PathVariable("seq") long nSeq) {
		log.info("nSeq = " + nSeq);
		BoardDto boarddto = selectSeq(nSeq);
		
		return new ResponseEntity<>(boarddto, HttpStatus.OK);
	}
	
	// @PathVariable, 여러개 썩어서
	@GetMapping("/select2/{seq}/uri1/{v1}/uri2/{v2}")
	public ResponseEntity<BoardDto> select2(@PathVariable("seq") long nSeq, @PathVariable("v1") int nValue,
			@PathVariable String v2) {
		log.info("nSeq = " + nSeq);
		log.info("nValue = " + nValue);
		log.info("v2 = " + v2);
		BoardDto boarddto = selectSeq(nSeq);

		return new ResponseEntity<>(boarddto, HttpStatus.OK);
	}
	
	// @RequestParam
	@GetMapping("/select3")
	public ResponseEntity<BoardDto> select3(@RequestParam("seq") long nSeq) {
		log.info("nSeq = " + nSeq);
		BoardDto boarddto = selectSeq(nSeq);

		return new ResponseEntity<>(boarddto, HttpStatus.OK);
	}

	// @RequestParam, 여러개
	@GetMapping("/select4")
	public ResponseEntity<BoardDto> select4(@RequestParam("seq") long nSeq, @RequestParam("v1") int nValue,
			@RequestParam String v2) {
		log.info("nSeq = " + nSeq);
		log.info("nValue = " + nValue);
		log.info("v2 = " + v2);
		BoardDto boarddto = selectSeq(nSeq);

		return new ResponseEntity<>(boarddto, HttpStatus.OK);
	}
	
	// @RequestParam, map
	@GetMapping("/select5")
	public ResponseEntity<BoardDto> select5(@RequestParam Map<String, Object> nMap) {
		for (Entry<String, Object> entry : nMap.entrySet()) {
			log.info("key = " + entry.getKey() + ", value = " + entry.getValue());
		}
		BoardDto boarddto = selectSeq(Long.parseLong(nMap.get("seq").toString()));

		return new ResponseEntity<>(boarddto, HttpStatus.OK);
	}
	
	// @ModelAttribute
	@GetMapping("/select6")
	public ResponseEntity<BoardDto> select6(@ModelAttribute BoardDto nDto) {
		log.info("nDto = " + nDto.toString());
		//BoardDto boarddto = selectSeq(nDto.getSeq());

		return new ResponseEntity<>(nDto, HttpStatus.OK);
	}
	
	// @RequestBody, dto
	@PostMapping("/select7")
	public ResponseEntity<BoardDto> select7(@RequestBody BoardDto nDto) {
		log.info("nDto = " + nDto.toString());
		// BoardDto boarddto = selectSeq(nDto.getSeq());

		return new ResponseEntity<>(nDto, HttpStatus.OK);
	}
	
	// @RequestBody, map
	@PostMapping("/select8")
	public ResponseEntity<BoardDto> select8(@RequestBody Map<String, Object> nMap) {
		for (Entry<String, Object> entry : nMap.entrySet()) {
			log.info("key = " + entry.getKey() + ", value = " + entry.getValue());
		}
		BoardDto boarddto = selectSeq(Long.parseLong(nMap.get("seq").toString()));

		return new ResponseEntity<>(boarddto, HttpStatus.OK);
	}

	
	//	
	List<BoardDto> selectAll() {
		List<BoardDto> boarddtolist = boardService.selectAll();
		//log.info("select all, boardDtoList = " + boarddtolist.toString());
		
		return boarddtolist;
	}
	
	BoardDto selectSeq(long seq) {
		BoardDto boarddto = boardService.selectSeq(seq);
		//log.debug("select seq, boarddto = " + boarddto.toString());
		//log.info("select seq, boarddto = " + boarddto.toString());
		
		return boarddto;
	}
	

}
