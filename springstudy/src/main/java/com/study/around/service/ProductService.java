package com.study.around.service;

import com.study.around.data.dto.ProductDto;

public interface ProductService {
	ProductDto getProduct(String productId);

	ProductDto saveProduct(ProductDto productDto);
}
