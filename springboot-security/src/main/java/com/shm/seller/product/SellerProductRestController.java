package com.shm.seller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shm.common.resultdata.ResultData;
import com.shm.product.ProductDto;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/seller/product")
@Slf4j
public class SellerProductRestController {
	private final SellerProductService sellerProductService;
	
	@Autowired
	public SellerProductRestController(SellerProductService sellerProductService) {
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

		ResultData resultData = sellerProductService.insert(productDto, thumbnailImage, detailImage);		

		return resultData;
	}

}
