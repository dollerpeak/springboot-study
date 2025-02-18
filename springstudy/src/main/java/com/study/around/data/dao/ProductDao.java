package com.study.around.data.dao;

import com.study.around.data.entity.ProductEntity;

public interface ProductDao {
	ProductEntity getProduct(String productId);
	ProductEntity saveProduct(ProductEntity productEntity);
}
