package com.study.metacoding.blog.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.study.metacoding.blog.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepository {
	private static final String namespace = "com.study.metacoding.blog.entity.UserEntity.";
	private final SqlSessionTemplate sqlSessionTemplate;

	public int insert(UserEntity nUserEntity) {
		return sqlSessionTemplate.insert(namespace + "insert", nUserEntity);
	}
	
	public UserEntity selectUser(long id) {
		return sqlSessionTemplate.selectOne(namespace + "selectUser", id);
	}
	
	public List<UserEntity> selectAll() {
		return sqlSessionTemplate.selectList(namespace + "selectAll");
	}

}
