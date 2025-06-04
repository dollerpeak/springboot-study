package com.study.aloha.blog;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapper {

	// mapper.xml의 ID와 동일해야 함
	public List<BlogEntity> select() throws Exception;

}
