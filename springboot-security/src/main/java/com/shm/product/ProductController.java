package com.shm.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/product")
@Slf4j
public class ProductController {

	@GetMapping("/insert")
	public String insert() {
		log.info("===> ProductController");
		return "/product/insert";
	}

}
