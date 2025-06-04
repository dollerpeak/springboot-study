package com.study.codingrecipe.board.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
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
import com.study.common.util.DateFormat;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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
	
	// HttpServletRequest
	@GetMapping("/request-get")
	public ResponseEntity<BoardDto> requestGet(HttpServletRequest request) {
		log.info("get::request = " + request);
		
		log.info("get::request.getHeaderNames() = " + request.getHeaderNames());
		Iterator<String> iterator = request.getHeaderNames().asIterator();
		while (iterator.hasNext()) {
			String headerkey = iterator.next();
			log.info("---get::request.getHeader(" + headerkey + ") = " + request.getHeader(headerkey));
		}
		
		log.info("get::request.getMethod() = " + request.getMethod());
		log.info("get::request.getProtocol() = " + request.getProtocol());
		log.info("get::request.getScheme() = " + request.getScheme());
		log.info("get::request.getRequestURL() = " + request.getRequestURL());
		log.info("get::request.getRequestURI() = " + request.getRequestURI());
		log.info("get::request.getQueryString() = " + request.getQueryString());
		log.info("get::request.isSecure() = " + request.isSecure());
		
		log.info("get::request.getParameter(\"seq\") = " + request.getParameter("seq"));
		log.info("get::request.getParameter(\"title\") = " + request.getParameter("title"));
		log.info("get::request.getParameter(\"contents\") = " + request.getParameter("contents"));
		
		log.info("get::request.getAttribute(\"test\") = " + request.getAttribute("test"));
		
		BoardDto boarddto = new BoardDto();
		boarddto.setSeq(0);
		boarddto.setTitle("꿈");
		boarddto.setContents("꿈내용");		
		boarddto.setFrstRegUserId("사용자");
		boarddto.setFrstRegDate(DateFormat.getFormatString(System.currentTimeMillis(), null));		
		boarddto.setLastChgUserId("사용자");
		boarddto.setLastChgDate(DateFormat.getFormatString(System.currentTimeMillis(), null));

		return new ResponseEntity<>(boarddto, HttpStatus.OK);
	}
	
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	
	// HttpServletRequest, HttpServletResponse
	@PostMapping("/request-post")
	//public ResponseEntity<BoardDto> requestPost(HttpServletRequest request) {
	//public ResponseEntity<BoardDto> requestPost(HttpServletResponse response) {
	public ResponseEntity<BoardDto> requestPost() {
		log.info("post::request = " + request);

		log.info("post::request.getHeaderNames() = " + request.getHeaderNames());
		Iterator<String> iterator = request.getHeaderNames().asIterator();
		while (iterator.hasNext()) {
			String headerkey = iterator.next();
			log.info("---post::request.getHeader(" + headerkey + ") = " + request.getHeader(headerkey));
		}

		log.info("post::request.getMethod() = " + request.getMethod());
		log.info("post::request.getProtocol() = " + request.getProtocol());
		log.info("post::request.getScheme() = " + request.getScheme());
		log.info("post::request.getRequestURL() = " + request.getRequestURL());
		log.info("post::request.getRequestURI() = " + request.getRequestURI());
		log.info("post::request.getQueryString() = " + request.getQueryString());
		log.info("post::request.isSecure() = " + request.isSecure());

		log.info("post::request.getParameter(\"seq\") = " + request.getParameter("seq"));
		log.info("post::request.getParameter(\"title\") = " + request.getParameter("title"));
		log.info("post::request.getParameter(\"contents\") = " + request.getParameter("contents"));
		
		log.info("post::request.getSession() = " + request.getSession());
		log.info("post::request.getCookies() = " + request.getCookies());
		
		request.setAttribute("test", "123");
		log.info("post::request.getAttribute(\"test\") = " + request.getAttribute("test"));
		
		HttpSession httpsession = request.getSession();
		log.info("post::httpsession.getId() = " + httpsession.getId());
		log.info("post::httpsession.getMaxInactiveInterval() = " + httpsession.getMaxInactiveInterval());
		log.info("post::httpsession.getLastAccessedTime() = " + httpsession.getLastAccessedTime());
		httpsession.setAttribute("123", "test");
		log.info("post::httpsession.getAttribute(\"123\") = " + httpsession.getAttribute("123"));
		
		Cookie cookie = new Cookie("cookie1", "cookie1");		
		response.addCookie(cookie);
		log.info("post::request.getCookies() = " + request.getCookies());
		log.info("post::request.getCookies().length = " + request.getCookies().length);
		
		
		try {
			ServletInputStream inputstream = request.getInputStream();
			String msg = StreamUtils.copyToString(inputstream, StandardCharsets.UTF_8);
			log.info("post::msg = " + msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		BoardDto boarddto = new BoardDto();
		boarddto.setSeq(0);
		boarddto.setTitle("꿈");
		boarddto.setContents("꿈내용");
		boarddto.setFrstRegUserId("사용자");
		boarddto.setFrstRegDate(DateFormat.getFormatString(System.currentTimeMillis(), null));
		boarddto.setLastChgUserId("사용자");
		boarddto.setLastChgDate(DateFormat.getFormatString(System.currentTimeMillis(), null));

		return new ResponseEntity<>(boarddto, HttpStatus.OK);
	}
	
	// Cookie, HttpSession
	@PostMapping("/request-cookie")
	public ResponseEntity<BoardDto> requestCookie() {
		//log.info("cookie::request = " + request.toString());
		//log.info("cookie::.toString() = " + response.toString());
		
		//log.info("cookie::request.getSession() = " + request.getSession());
		
		// cookie add
//		Cookie cookie = new Cookie("key", "value");
//		response.addCookie(cookie);
		
		// cookie delete
		log.info("cookie::request.getCookies() = " + request.getCookies());
		for (Cookie cookiedetail : request.getCookies()) {
			log.info("cookie::cookiedetail.getName() = " + cookiedetail.getName() + ", cookiedetail.getValue() = "
					+ cookiedetail.getValue());
			if (cookiedetail.getName().equals("JSESSIONID") == false) {
				cookiedetail.setMaxAge(0);
				response.addCookie(cookiedetail);
			}
		}
		

		BoardDto boarddto = new BoardDto();
		boarddto.setSeq(0);
		boarddto.setTitle("cookie");
		boarddto.setContents("cookie내용");
		boarddto.setFrstRegUserId("사용자");
		boarddto.setFrstRegDate(DateFormat.getFormatString(System.currentTimeMillis(), null));
		boarddto.setLastChgUserId("사용자");
		boarddto.setLastChgDate(DateFormat.getFormatString(System.currentTimeMillis(), null));

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
