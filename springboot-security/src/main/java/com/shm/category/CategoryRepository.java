package com.shm.category;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class CategoryRepository {
	private final String namespace = "com.shm.category.";	
	private final SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	public CategoryRepository(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	public List<CategoryEntity> select() throws Exception {
		return sqlSessionTemplate.selectList(namespace + "select");
	}
	
	

}
