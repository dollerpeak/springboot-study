package com.study.aloha.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.common.DateFormat;
import com.study.common.ResultData;
import com.study.common.exception.CustomException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/aloha/blog")
public class BlogController {

	@Autowired
	BlogService blogService;

	@GetMapping({"/", ""})
	public String main() {
		return "/aloha/blog/main";
	}
	
	// select
	@GetMapping("/select")
	//public String select(Model model) throws Exception{
	public String select(Model model) {
//		blogService.select();
//		List<Blog> blogList = new ArrayList<>();
//		blogList.add(new Blog(0, "제목0", "작성자0", "내용0", DateFormat.getFormatString(System.currentTimeMillis(), null),
//				DateFormat.getFormatString(System.currentTimeMillis(), null)));
//		blogList.add(new Blog(1, "제목1", "작성자1", "내용1", DateFormat.getFormatString(System.currentTimeMillis(), null),
//				DateFormat.getFormatString(System.currentTimeMillis(), null)));
//		blogList.add(new Blog(2, "제목2", "작성자2", "내용2", DateFormat.getFormatString(System.currentTimeMillis(), null),
//				DateFormat.getFormatString(System.currentTimeMillis(), null)));

		// repository로 mapper연결할때
		model.addAttribute("blogList", blogService.select());

		// 에러만들어서 처리
		ResultData resultData = blogService.exception_select();
		
		log.info("resultData.getCode() = " + resultData.getCode());
		if(resultData.getCode() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
			throw new CustomException(resultData);
		}


		// interface mapper연결할때
		// model.addAttribute("blogList", blogService.select_mapper());
		
		log.info("controller - select");
		
		return "/aloha/blog/select";
	}
	
//	@GetMapping("/detail")
//	public String detail() {
//		return "/aloha/blog/detail";
//	}
	@GetMapping("/detail")
	public String detail(@RequestParam int id, Model model) {
		log.info("id = " + id);
		Blog blog = new Blog(4, "제목4", "작성자4", "내용4", DateFormat.getFormatString(System.currentTimeMillis(), null),
				DateFormat.getFormatString(System.currentTimeMillis(), null));
		
		model.addAttribute("blog", blog);
		return "/aloha/blog/detail";
	}
	
	// insert
	@GetMapping("/insert")
	public String insert() {
		return "/aloha/blog/insert";
	}
	
	@PostMapping("/insert")
	public String insert(Blog blog) {
		log.info("blog = " + blog.toString());
		
//		int result = new Random().nextInt(2);
//		if(result == 0) {
//			// 에러처리
//			return "redirect:/aloha/blog/insert";
//		}		
		
		return "redirect:/aloha/blog/select";
	}
	
	// update
//	@GetMapping("/update")
//	public String update() {
//		return "/aloha/blog/update";
//	}
	@GetMapping("/update")
	public String update(@RequestParam int id, Model model) {
		log.info("id = " + id);
		Blog blog = new Blog(id, "제목4", "작성자4", "내용4", DateFormat.getFormatString(System.currentTimeMillis(), null),
				DateFormat.getFormatString(System.currentTimeMillis(), null));
		
		model.addAttribute("blog", blog);
		return "/aloha/blog/update";
	}
	
	@PostMapping("/update")
	public String update(Blog blog) {
		log.info("blog = " + blog.toString());

//		int result = new Random().nextInt(2);
//		if (result == 0) {
//			// 에러처리
//			return "redirect:/aloha/blog/update?id=" + blog.getId();
//		}
		
		return "redirect:/aloha/blog/select";
	}
	
//	@ResponseBody
	@PutMapping("/update")
	public ResponseEntity<String> putUpdate(@RequestBody Blog blog) {
		log.info("blog = " + blog.toString());
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
//	public ResponseEntity<Blog> putUpdate(@RequestBody Blog blog) {
//		log.info("blog = " + blog.toString());
//		return new ResponseEntity<>(blog, HttpStatus.OK);
//	}
 
	// delete
	@GetMapping("/delete")
	public String delete(@RequestParam int id) {
		log.info("id = " + id);
		return "/aloha/blog/select";
	}
	
	@PostMapping("/delete")
	public String delete(Blog blog) {
		log.info("blog = " + blog.toString());
		return "redirect:/aloha/blog/select";
	}
	
//	@ResponseBody
	@DeleteMapping("/delete")
	public ResponseEntity<String> deletetest(@RequestParam int id) {
		log.info("id = " + id);
		return new ResponseEntity<>("success", HttpStatus.OK);
	}
	
//	//fetch
//	//@PostMapping("/test")
//	@GetMapping("/test")
//	//public ResponseEntity<List<Blog>> test() {
//	public String test() {
//		List<Blog> blogList = new ArrayList<>();
//		blogList.add(new Blog(0, "제목0", "작성자0", "내용0", DateFormat.getFormatString(System.currentTimeMillis(), null),
//				DateFormat.getFormatString(System.currentTimeMillis(), null)));
//		blogList.add(new Blog(1, "제목1", "작성자1", "내용1", DateFormat.getFormatString(System.currentTimeMillis(), null),
//				DateFormat.getFormatString(System.currentTimeMillis(), null)));
//		blogList.add(new Blog(2, "제목2", "작성자2", "내용2", DateFormat.getFormatString(System.currentTimeMillis(), null),
//				DateFormat.getFormatString(System.currentTimeMillis(), null)));
//		
//		//model.addAttribute("blog", blogList.get(0));
//		return "/aloha/blog/select";
//	}
	
	
	
}










