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
		log.info("=====> main");
		
		// 로그인이 되어 있어야 하고
		// role = seller 이어야 함
		
		return "/seller/seller";
	}

}
