package com.study.dbms.dao.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.study.dbms.dao.MybatisDao;
import com.study.dbms.dto.MybatisDto;

@Repository
public class MybatisDaoImpl implements MybatisDao {
	private SqlSessionTemplate sqlSessionTemplate;
	private String nameSpace = "com.study.dbms.dao.MybatisDao";

	@Override
	public int getCount() {
		return sqlSessionTemplate.selectOne(nameSpace + "getCount");
	}

	@Override
	public List<MybatisDto> getList() {
		return sqlSessionTemplate.selectList(nameSpace + "getList");
	}

	@Override
	public MybatisDto getDetail(String id) {
		return (MybatisDto) sqlSessionTemplate.selectList(nameSpace+"getDetail", id);
	}

}
