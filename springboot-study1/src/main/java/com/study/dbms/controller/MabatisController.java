package com.study.dbms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.dbms.dto.MybatisDto;
import com.study.dbms.service.MybatisService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/dbms/mybatis")
public class MabatisController {
	@Autowired
	private MybatisService mybatisService;

	@GetMapping("/getCount")
	public int getCount() {
		return mybatisService.getCount();
	}

	@GetMapping("/getList")
	public List<MybatisDto> getList() {
		return mybatisService.getList();
	}
	
	@GetMapping("/getDetail")
	public MybatisDto getDetail(@RequestParam String id) {
		log.info("getDetail(@RequestParam String id)");
		return mybatisService.getDetail(id);
	}

}
