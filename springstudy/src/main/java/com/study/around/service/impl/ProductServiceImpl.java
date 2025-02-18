package com.study.around.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.around.data.dao.ProductDao;
import com.study.around.data.dto.ProductDto;
import com.study.around.service.ProductService;

//import jakarta.transaction.Transactional;

@Service
//@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;
	ProductDto productDto;

	@Override
	public ProductDto getProduct(String productid) {
		productDto = productDao.getProduct(productid).toDto();

		return productDto;
	}

	@Override
	public ProductDto saveProduct(ProductDto productdto) {
		productDto = productDao.saveProduct(productdto.toEntity()).toDto();
		
		return productDto;
	}

}
