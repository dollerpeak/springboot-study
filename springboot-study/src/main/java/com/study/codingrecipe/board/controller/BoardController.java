package com.study.codingrecipe.board.controller;

import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.study.codingrecipe.PropertiesPrefix;
//import com.study.codingrecipe.PropertyApp;
//import com.study.codingrecipe.PropertyYml;
import com.study.codingrecipe.board.dto.BoardDto;
import com.study.codingrecipe.board.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/codingrecipe")
@RequiredArgsConstructor
@Slf4j
@PropertySource("classpath:/properties/test.properties")
public class BoardController {
	private final BoardService boardService;

//	@Autowired
//	private PropertyApp propertyApp;
//	@Value("${test.property.direct}")
//	private String testproperties;
//	
//	@Autowired
//	private PropertyYml propertyYml;
//	@Value("${test.yaml.direct}")
//	private String testyml;
//	
//	@Value("${test.property.list}")
//	private List<String> testymllist;
//	
//	@Autowired
//	private PropertiesPrefix propertiesPrefix;

	@GetMapping("/home")
	public String home(Model nMmodel) {
		List<BoardDto> boarddtolist = selectAll();
		nMmodel.addAttribute("boarddtolist", boarddtolist);

//		log.info("propertyApp, test1 = " + propertyApp.getTest1());
//		log.info("propertyApp, test2 = " + propertyApp.getTest2());
//		log.info("propertyApp, test3 = " + propertyApp.getTest3());
//		log.info("testproperties = " + testproperties);
//		
//		log.info("propertyYml, test1 = " + propertyYml.getTest1());
//		log.info("propertyYml, test2 = " + propertyYml.getTest2());
//		log.info("propertyYml, test3 = " + propertyYml.getTest3());
//		log.info("testyml = " + testyml);
//		
//		log.info("testymllist = " + testymllist);
//		
//		log.info("propertiesPrefix, number = " + propertiesPrefix.getNumber());
//		log.info("propertiesPrefix, str = " + propertiesPrefix.getStr());
//		log.info("propertiesPrefix, list = " + propertiesPrefix.getList());

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

	// @Transactional
	@GetMapping("/select/{seq}")
	public String selectSeq(@PathVariable("seq") long nSeq, Model nMmodel) {
		log.info("update hists, nSeq = " + nSeq);

		boardService.updateSeq(nSeq);
		BoardDto boarddto = selectSeq(nSeq);

		// @Transactional test
		// String test = "abc";
		// Integer.parseInt(test);

		nMmodel.addAttribute("boarddto", boarddto);

		return "/codingrecipe/detail";
	}

	List<BoardDto> selectAll() {
		List<BoardDto> boarddtolist = boardService.selectAll();
		// log.info("select all, boardDtoList = " + boarddtolist.toString());

		return boarddtolist;
	}

	BoardDto selectSeq(long seq) {
		BoardDto boarddto = boardService.selectSeq(seq);
		// log.debug("select seq, boarddto = " + boarddto.toString());
		// log.info("select seq, boarddto = " + boarddto.toString());

		return boarddto;
	}

}
