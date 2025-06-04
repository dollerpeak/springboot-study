package com.study.metacoding.blog.login.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.study.metacoding.blog.user.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LoginRepository {
	private static final String namespace = "com.study.metacoding.blog.login.";
	private final SqlSessionTemplate sqlSessionTemplate;
	
	public int selectNameCount(UserEntity nUserEntity) {
		return sqlSessionTemplate.selectOne(namespace + "selectNameCount", nUserEntity);
	}
	
	public UserEntity selectUser(UserEntity nUserEntity) {
		return sqlSessionTemplate.selectOne(namespace + "selectUser", nUserEntity);
	}
	
	public UserEntity selectUserName(UserEntity nUserEntity) {
		return sqlSessionTemplate.selectOne(namespace + "selectUserName", nUserEntity);
	}
	
}
