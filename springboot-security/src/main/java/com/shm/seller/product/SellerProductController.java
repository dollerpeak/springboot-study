package com.shm.seller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shm.category.CategoryService;
import com.shm.common.resultdata.ResultData;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/seller/product")
@Slf4j
public class SellerProductController {
	private final CategoryService categoryService;

	@Autowired
	public SellerProductController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@GetMapping("/insert")
	public String insert(Model model) {
		log.info("===> insert");
		
		// 카테고리 정보
		ResultData resultData = categoryService.select();
		model.addAttribute("category", resultData.getData());		
		
		return "/seller/product/product_insert";
	}

}
