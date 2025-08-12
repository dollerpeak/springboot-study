package com.shm.seller.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/seller/product")
@Slf4j
public class SellerProductRestController {
	
//	@PostMapping("/insert")
//	public String insert(@ModelAttribute ProductDto productDto
//			, @RequestParam("thumbnail") MultipartFile thumbnail
//			, @RequestParam("detailImage") MultipartFile detailImage) {
//		log.info("=====> SellerProductRestController");
//		return "/seller/product/insert";
//	}
	
}
