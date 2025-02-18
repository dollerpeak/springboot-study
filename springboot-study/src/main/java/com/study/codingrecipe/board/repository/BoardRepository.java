package com.study.codingrecipe.board.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.study.codingrecipe.board.entity.BoardEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
	private static final String namespace = "com.study.codingrecipe.board.entity.BoardEntity.";
	private final SqlSessionTemplate sqlSessionTemplate;

	public int insert(BoardEntity boardEntity) {
		return sqlSessionTemplate.insert(namespace + "insert", boardEntity);
	}

	public List<BoardEntity> selectAll() {
		return sqlSessionTemplate.selectList(namespace + "selectAll");
	}

	public void updateSeq(long seq) {
		sqlSessionTemplate.selectList(namespace + "updateSeq", seq);
	}

	public BoardEntity selectSeq(long seq) {
		return sqlSessionTemplate.selectOne(namespace + "selectSeq", seq);
	}

}
