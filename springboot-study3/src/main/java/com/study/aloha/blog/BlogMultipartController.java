package com.study.aloha.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/aloha/blog/multipart")
public class BlogMultipartController {
	@Autowired
	BlogService blogService;

	@GetMapping("/select")
	public String select(Model model) throws Exception {
		log.info("select");

		model.addAttribute("blogList", blogService.select());

		return "/aloha/blog/multipart/select";
	}

	@GetMapping("/insert")
	public String insert() throws Exception {
		log.info("insert");
		
		return "/aloha/blog/multipart/insert";
	}

	@PostMapping("/insert")
	public String insert(BlogDto dto) throws Exception {
		log.info("insert");
		log.info("dto = " + dto.toString());

		long id = blogService.insert(dto);
		log.info("id = " + id);

		return "redirect:/aloha/blog/multipart/select";
	}
	
	@GetMapping("/detail")
	public String detail(@RequestParam int id, Model model) throws Exception {
		log.info("detail");		
		log.info("id = " + id);
		
		BlogDto dto = blogService.detail(id);
		log.info("dto = " + dto.toString());
		
		model.addAttribute("blog", dto);
		
		return "/aloha/blog/multipart/detail";
	}

}
