package com.shm.user;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserRepository {
	private String namespace = "com.shm.user.";
	private SqlSessionTemplate sqlSessionTemplate;

	public int insert(UserEntity userEntity) throws Exception {
		return sqlSessionTemplate.insert(namespace + "insert", userEntity);
	}

	public List<UserEntity> selectByUserName(String name) throws Exception {
		return sqlSessionTemplate.selectList(namespace + "selectByUserName", name);
	}

	public int update(UserEntity userEntity) throws Exception {
		return sqlSessionTemplate.update(namespace + "update", userEntity);
	}

	public int deleteByUserName(String name) throws Exception {
		return sqlSessionTemplate.delete(namespace + "deleteByUserName", name);
	}
}



