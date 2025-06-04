package com.study.aloha.test.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/aloha/test/request")
public class ControllerRequest {
	@GetMapping("/selects")
	// public List<RequestBoard> requests() {
	public ResponseEntity<List<RequestBoard>> requestsGet() {
		List<RequestBoard> requestBoardList = new ArrayList<>();
		requestBoardList.add(new RequestBoard("제목1", "작성자1", "내용1"));
		requestBoardList.add(new RequestBoard("제목2", "작성자2", "내용2"));
		requestBoardList.add(new RequestBoard("제목3", "작성자3", "내용3"));

		log.info(requestBoardList.toString());

		// return requestBoardList;
		return new ResponseEntity<>(requestBoardList, HttpStatus.OK);
	}

	@GetMapping("/select/{id}")
	public ResponseEntity<RequestBoard> requestGetPathVariable(@PathVariable int id) throws Exception {
		log.info(">>>>> GET, @PathVariable");

		RequestBoard requestBoard = new RequestBoard("제목PathVariable", "작성자PathVariable", "내용PathVariable");

		return new ResponseEntity<>(requestBoard, HttpStatus.OK);
	}

	@GetMapping("/select")
	public ResponseEntity<RequestBoard> requestGetRequestParam(@RequestParam int id) throws Exception {
		log.info(">>>>> GET, @RequestParam");

		RequestBoard requestBoard = new RequestBoard("제목RequestParam", "작성자RequestParam", "내용RequestParam");

		return new ResponseEntity<>(requestBoard, HttpStatus.OK);
	}

	@PostMapping("/selects")
	public ResponseEntity<String> requestPost(RequestBoard board) throws Exception {
		log.info(">>>>> POST");
		int result = new Random().nextInt(2);

		if (result == 0) {
			return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<String> requestPut(RequestBoard board) throws Exception {
		log.info(">>>>> PUT");
		int result = new Random().nextInt(2);

		if (result == 0) {
			return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> requestDelete(RequestBoard board) throws Exception {
		log.info(">>>>> DELETE");
		int result = new Random().nextInt(2);

		if (result == 0) {
			return new ResponseEntity<>("FAIL", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
	}

}
