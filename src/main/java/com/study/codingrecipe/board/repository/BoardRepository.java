package com.study.codingrecipe.board.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.study.codingrecipe.board.entity.BoardEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
	private static final String namespace = "com.study.codingrecipe.board.entity.BoardEntity.";
	private final SqlSessionTemplate sqlSessionTemplate;

	public void insert(BoardEntity boardEntity) {
		sqlSessionTemplate.insert(namespace + "insert", boardEntity);
	}
	
//	public List<BoardEntity> select() {
//		return sqlSessionTemplate.selectList(namespace + "select");
//	}

}
