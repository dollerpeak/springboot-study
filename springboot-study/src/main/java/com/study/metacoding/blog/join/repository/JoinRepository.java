package com.study.metacoding.blog.join.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.study.metacoding.blog.user.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JoinRepository {
	private static final String namespace = "com.study.metacoding.blog.join.";
	private final SqlSessionTemplate sqlSessionTemplate;
	
	public int selectNameCount(UserEntity nUserEntity) {
		return sqlSessionTemplate.selectOne(namespace + "selectNameCount", nUserEntity);
	}
	
	public int insertUser(UserEntity nUserEntity) {
		return sqlSessionTemplate.insert(namespace + "insertUser", nUserEntity);
	}
	
	public List<UserEntity> selectUser(UserEntity nUserEntity) {
		return sqlSessionTemplate.selectList(namespace + "selectUser", nUserEntity);
	}
	
}
