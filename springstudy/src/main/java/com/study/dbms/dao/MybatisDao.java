package com.study.dbms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.dbms.dto.MybatisDto;

@Mapper
public interface MybatisDao {

	public int getCount();

	public List<MybatisDto> getList();
	
	public MybatisDto getDetail(String id);

}
