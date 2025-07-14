package com.shm.user;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserRepository {
	private String namespace = "com.shm.user.";
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public int insert(UserEntity userEntity) throws Exception {
		return sqlSessionTemplate.insert(namespace + "insert", userEntity);
	}

	public List<UserEntity> selectByEmail(String email) throws Exception {
		return sqlSessionTemplate.selectList(namespace + "selectByEmail", email);
	}

	public int update(UserEntity userEntity) throws Exception {
		return sqlSessionTemplate.update(namespace + "update", userEntity);
	}

	public int deleteByEmail(String email) throws Exception {
		return sqlSessionTemplate.delete(namespace + "deleteByEmail", email);
	}
}
