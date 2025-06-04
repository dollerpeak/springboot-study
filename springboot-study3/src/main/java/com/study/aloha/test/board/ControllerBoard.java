package com.study.aloha.test.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.aloha.test.request.RequestBoard;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/aloha/test/board")
public class ControllerBoard {

	@GetMapping({"/", ""})
	public String home() {
		log.info("<<<<<<<<<<<<<< Aloha Test Board >>>>>>>>>>>>>>");
		return "/aloha/test/board/index";
	}
	
	@GetMapping("/lists")
	public ResponseEntity<List<RequestBoard>> lists() {
		List<RequestBoard> boardList = new ArrayList<>();
		
		boardList.add(new RequestBoard("제목1", "작성자1", "내용1"));
		boardList.add(new RequestBoard("제목2", "작성자2", "내용2"));
		boardList.add(new RequestBoard("제목3", "작성자3", "내용3"));
		
		return new ResponseEntity<>(boardList, HttpStatus.OK);
	}
	
	@GetMapping("/list/{nId}")
	public ResponseEntity<RequestBoard> list(@PathVariable String nId) {
		RequestBoard board = new RequestBoard("제목1", "작성자1", "내용1");
		
		return new ResponseEntity<>(board, HttpStatus.OK);
	}
	
	@PostMapping("/list")
	public ResponseEntity<String> insertBoard(RequestBoard board) {
		log.info("board = " + board.toString());
		
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
	@PutMapping("/list/update")
	public ResponseEntity<String> updateBoard(@RequestBody RequestBoard board) throws Exception {
		log.info("board = " + board.toString());
		int result = new Random().nextInt(2);

		if (result == 0) {
			return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}
	
	@DeleteMapping("/list/delete/{nId}")
	public ResponseEntity<String> deleteBoard(@PathVariable int nId) throws Exception {
		log.info("deleteBoard(), nId = " + nId);
		int result = new Random().nextInt(2);

		if (result == 0) {
			return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}
	
	@PostMapping("/list/delete")
	public ResponseEntity<String> deleteTestBoard(RequestBoard board) throws Exception {
		log.info("deleteTestBoard(), board = " + board.toString());
		int result = new Random().nextInt(2);

		if (result == 0) {
			return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}
	
}







