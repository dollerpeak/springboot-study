package com.study.metacoding.blog.user.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.study.metacoding.blog.user.entity.UserEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepository {
	private static final String namespace = "com.study.metacoding.blog.user.";
	private final SqlSessionTemplate sqlSessionTemplate;

	public int insert(UserEntity nUserEntity) {
		return sqlSessionTemplate.insert(namespace + "insert", nUserEntity);
	}
	
	public UserEntity select(int nId) {
		return sqlSessionTemplate.selectOne(namespace + "select", nId);
	}
	
	public int selectNameCount(UserEntity nUserEntity) {
		return sqlSessionTemplate.selectOne(namespace + "selectNameCount", nUserEntity);
	}
	
	public UserEntity selectUserName(UserEntity nUserEntity) {
		return sqlSessionTemplate.selectOne(namespace + "selectUserName", nUserEntity);
	}
	
	public List<UserEntity> selectAll() {
		return sqlSessionTemplate.selectList(namespace + "selectAll");
	}
	
	public int update(UserEntity nUserEntity) {
		return sqlSessionTemplate.update(namespace + "update", nUserEntity);
	}
	
	public int delete(int nId) {
		return sqlSessionTemplate.delete(namespace + "delete", nId);
	}

}
