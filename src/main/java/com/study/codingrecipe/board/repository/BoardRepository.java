package com.study.codingrecipe.board.repository;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.study.codingrecipe.board.dto.BoardDto;

@Repository
public class BoardRepository {
	//private SqlSessionTemplate sqlSessionTemplate;

	public void insert(BoardDto boardDto) {
		System.out.println("repository");
		//sqlSessionTemplate.insert(null, boardDto);
	}

}
