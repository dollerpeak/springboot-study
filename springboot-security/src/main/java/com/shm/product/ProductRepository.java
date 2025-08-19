package com.shm.product;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ProductRepository {
	private final String namespace = "com.shm.product.";	
	private final SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public ProductRepository(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	public int insert(ProductEntity productEntity) throws Exception {
		return sqlSessionTemplate.insert(namespace + "insert", productEntity);
	}

	public List<ProductEntity> select() throws Exception {
		return sqlSessionTemplate.selectList(namespace + "select");
	}

	public List<ProductEntity> selectById(String id) throws Exception {
		return sqlSessionTemplate.selectList(namespace + "selectById", id);
	}

	public List<ProductEntity> selectByUserId(String userId) throws Exception {
		return sqlSessionTemplate.selectList(namespace + "selectByUserId", userId);
	}
		

}
