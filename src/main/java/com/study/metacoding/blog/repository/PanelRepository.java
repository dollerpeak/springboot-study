package com.study.metacoding.blog.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.study.codingrecipe.board.entity.BoardEntity;
import com.study.metacoding.blog.entity.PanelEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PanelRepository {
	private static final String namespace = "com.study.metacoding.blog.entity.PanelEntity.";
	private final SqlSessionTemplate sqlSessionTemplate;

	public int insert(PanelEntity nPanelEntity) {
		return sqlSessionTemplate.insert(namespace + "insert", nPanelEntity);
	}

}
