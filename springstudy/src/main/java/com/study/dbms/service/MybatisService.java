package com.study.dbms.service;

import java.util.List;

import com.study.dbms.dto.MybatisDto;

public interface MybatisService {
	public int getCount();
	public List<MybatisDto> getList();
	public MybatisDto getDetail(String id);
}
