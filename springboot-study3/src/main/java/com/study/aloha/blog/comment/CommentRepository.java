package com.study.aloha.blog.comment;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class CommentRepository {
	String namespace = "com.study.aloha.blog.comment.";
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int insert(CommentEntity entity) throws Exception {
		log.info("insert");
		return sqlSessionTemplate.insert(namespace + "insert", entity);
	}

	public List<CommentEntity> select() throws Exception {
		log.info("select");
		return sqlSessionTemplate.selectList(namespace + "select");
	}
	
	public CommentEntity detail(long id) throws Exception {
		log.info("detail");
		return sqlSessionTemplate.selectOne(namespace + "detail", id);
	}

	public List<CommentEntity> selectBlog(long blogId) throws Exception {
		log.info("select");
		return sqlSessionTemplate.selectList(namespace + "selectBlog", blogId);
	}

//	public int update(CommentEntity entity) throws Exception {
//		log.info("blog - update");
//		return sqlSessionTemplate.update(namespace + "update", entity);
//	}

//	public int delete(long id) throws Exception {
//		log.info("blog - delete");
//		return sqlSessionTemplate.delete(namespace + "delete", id);
//	}

}
