package com.study.aloha.blog.attach;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class AttachRepository {
	String namespace = "com.study.aloha.blog.attach.";
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public int insert(AttachEntity entity) throws Exception {
		log.info("insert");
		return sqlSessionTemplate.insert(namespace + "insert", entity);
	}

	public List<AttachEntity> select() throws Exception {
		log.info("select");
		return sqlSessionTemplate.selectList(namespace + "select");
	}

	public AttachEntity detail(long id) throws Exception {
		log.info("detail");
		return sqlSessionTemplate.selectOne(namespace + "detail", id);
	}

	public List<AttachEntity> selectBlog(long blogId) throws Exception {
		log.info("selectBlog");
		return sqlSessionTemplate.selectList(namespace + "selectBlog", blogId);
	}

//	public int update(AttachEntity entity) throws Exception {
//		log.info("update");
//		return sqlSessionTemplate.update(namespace + "update", entity);
//	}
//
//	public int delete(long id) throws Exception {
//		log.info("delete");
//		return sqlSessionTemplate.delete(namespace + "delete", id);
//	}

}
