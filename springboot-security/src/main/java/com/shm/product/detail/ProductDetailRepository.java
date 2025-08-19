package com.shm.product.detail;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shm.product.ProductEntity;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ProductDetailRepository {
	private final String namespace = "com.shm.product.detail.";	
	private final SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public ProductDetailRepository(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public int insert(ProductDetailEntity productDetailEntity) throws Exception {
		return sqlSessionTemplate.insert(namespace + "insert", productDetailEntity);
	}

	public List<ProductEntity> selectByProductId(String productId) throws Exception {
		return sqlSessionTemplate.selectList(namespace + "selectByProductId", productId);
	}

}
