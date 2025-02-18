package com.study.metacoding.blog.panel.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.study.metacoding.blog.panel.entity.PanelEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class PanelRepository {
	private static final String namespace = "com.study.metacoding.blog.panel.";
	private final SqlSessionTemplate sqlSessionTemplate;

	public int insert(PanelEntity nPanelEntity) {
		return sqlSessionTemplate.insert(namespace + "insert", nPanelEntity);
	}
	
	public int selectMaxId() {
		return sqlSessionTemplate.selectOne(namespace + "selectMaxId");
	}
	
	public PanelEntity select(int nId) {
		return sqlSessionTemplate.selectOne(namespace + "select", nId);
	}

	public List<PanelEntity> selectAll() {
		return sqlSessionTemplate.selectList(namespace + "selectAll");
	}
	
	public int updateHits(PanelEntity nPanelEntity) {
		return sqlSessionTemplate.update(namespace + "updateHits", nPanelEntity);
	}

	public int delete(int nId) {
		return sqlSessionTemplate.delete(namespace + "delete", nId);		
	}

	public int update(PanelEntity nPanelEntity) {
		return sqlSessionTemplate.update(namespace + "update", nPanelEntity);		
	}

}
