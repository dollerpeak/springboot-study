package com.shm.seller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/seller")
@Slf4j
public class SellerController {

	@GetMapping("")
	public String main() {
		log.info("=====> SellerController");
		return "/seller/seller";
	}

}
