//package com.shm.category;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.shm.common.resultdata.ResultData;
//
//import lombok.extern.slf4j.Slf4j;
//
//@RestController
//@RequestMapping("/api/category")
//@Slf4j
//public class CategoryRestController {
//	private final CategoryService categoryService;
//
//	public CategoryRestController(CategoryService categoryService) {
//		this.categoryService = categoryService;
//	}
//	
//	@GetMapping("/select")
//	public ResultData select() {
//		log.info("===> select");
//
//		ResultData resultData = categoryService.select();
//
//		return resultData;
//	}
//
//}
