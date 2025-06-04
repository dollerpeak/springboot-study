package com.study.aloha.blog.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/aloha/blog/comment")
public class CommentController {
	@Autowired
	CommentService commentService;
	
//	@GetMapping("")
//	public List<CommentDto> select() 
//	
//	
//	@PostMapping("/select")
	

}
