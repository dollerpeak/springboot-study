package com.study.aloha.blog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/aloha/rest/blog")
@RestController
public class BoardRestController {
	@Autowired
	BlogService blogService;

	@GetMapping()
	public ResponseEntity<?> getAll() {
//		try {
//			List<BlogDto> blogList = blogService.select();
//			return new ResponseEntity<>(blogList, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}

		// RestControllerAdvice 테스트
		List<BlogDto> blogList = blogService.select();
		
		// <<< 에러 만들기
		//String str = "abc";
		//int a = Integer.parseInt(str);
		//log.info("에러 만들기");
		// >>> 에러 만들기
		
		return new ResponseEntity<>(blogList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		try {
			BlogDto blogDto = blogService.detail(id);
			return new ResponseEntity<>(blogDto, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping()
	public ResponseEntity<?> create(@RequestBody BlogDto blogDto) {
		try {
			long id = blogService.insert(blogDto);
			return new ResponseEntity<>(id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	@PutMapping()
//	public ResponseEntity<?> update(@RequestBody BlogDto blogDto) {
//		try {
//			int result = blogService.update(blogDto);
//			return new ResponseEntity<>(result, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

//	@DeleteMapping("/{id}")
//	public ResponseEntity<?> destroy(@PathVariable int id) {
//		try {
//			log.info("rest controller, id = " + id);
//			int result = blogService.delete(id);
//			return new ResponseEntity<>(result, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
//	@PostMapping("/delete")
//	public ResponseEntity<?> destroy_test(@RequestBody BlogDto blogDto) {
//		try {
//			log.info("rest controller, getId = " + blogDto.getId());
//			int result = blogService.delete(blogDto.getId());
//			return new ResponseEntity<>(result, HttpStatus.OK);
//		} catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

}
