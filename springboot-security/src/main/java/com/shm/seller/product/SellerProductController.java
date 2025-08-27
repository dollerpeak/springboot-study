package com.shm.seller.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/seller/product")
@Slf4j
public class SellerProductController {

	@GetMapping("/insert")
	public String insert(Model model) {
		log.info("===> insert");

		return "/seller/product/product_insert";
	}

}
