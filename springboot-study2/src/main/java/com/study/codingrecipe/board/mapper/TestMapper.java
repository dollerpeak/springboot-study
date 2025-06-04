package com.study.codingrecipe.board.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.study.codingrecipe.board.entity.BoardEntity;

@Mapper
public interface TestMapper {
	public void insert(BoardEntity boardEntity);
}
