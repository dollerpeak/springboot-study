package com.study.dbms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.dbms.dao.MybatisDao;
import com.study.dbms.dto.MybatisDto;
import com.study.dbms.service.MybatisService;

@Service
@Transactional
public class MybatisServiceImpl implements MybatisService {
	@Autowired
	private MybatisDao mybatisDao;

	@Override
	public int getCount() {
		return mybatisDao.getCount();
	}

	@Override
	public List<MybatisDto> getList() {
		return mybatisDao.getList();
	}

	@Override
	public MybatisDto getDetail(String id) {
		return mybatisDao.getDetail(id);
	}

}
