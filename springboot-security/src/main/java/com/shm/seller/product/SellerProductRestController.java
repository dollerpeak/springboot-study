package com.shm.seller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shm.common.resultdata.ResultData;
import com.shm.common.security.CustomUserDetails;
import com.shm.common.security.GlobalAuthentication;
import com.shm.product.ProductDto;
import com.shm.user.UserDto;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/seller/product")
@Slf4j
public class SellerProductRestController {
	private final GlobalAuthentication globalAuthentication;
	private final SellerProductService sellerProductService;
	
	@Autowired
	public SellerProductRestController(GlobalAuthentication globalAuthentication, SellerProductService sellerProductService) {
		this.globalAuthentication = globalAuthentication;
		this.sellerProductService = sellerProductService;
	}	

	@PostMapping("/insert")
	public ResultData insert(@RequestPart ProductDto productDto,
			@RequestPart("thumbnailImage") MultipartFile thumbnailImage,
			@RequestPart("detailImages") MultipartFile[] detailImage) {
		log.info("===> insert");
		//log.info("productDto = " + productDto.toString());
		//log.info("thumbnailImage = " + thumbnailImage.getOriginalFilename());
		//log.info("detailImage = " + detailImage[0].getOriginalFilename());
		
		UserDto userDto = globalAuthentication.getCustomUserDetails().getUserDto();
		ResultData resultData = sellerProductService.insert(userDto, productDto, thumbnailImage, detailImage);		

		return resultData;
	}

}
