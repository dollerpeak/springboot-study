package com.study.aloha.blog.comment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.common.DateFormat;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentService {
	@Autowired
	CommentRepository commentRepository;

	public List<CommentDto> select() throws Exception {
		log.info("select");
		
		List<CommentDto> listDto = new ArrayList<>();
		List<CommentEntity> listEntity = commentRepository.select();
		
		for(CommentEntity entity : listEntity) {
			listDto.add(entity.toDto());
		}
		
		return listDto;
	}
	
	public long insert(CommentDto dto) throws Exception {	
		log.info("insert");
		
		CommentEntity entity = dto.toEntity();
		
		if(entity.getFrstRegUserId() == null || entity.getFrstRegUserId().length() <= 0) {
			entity.setFrstRegUserId("SYSTEM");
		}
		if(entity.getLastChgUserId() == null || entity.getLastChgUserId().length() <= 0) {
			entity.setLastChgUserId("SYSTEM");
		}
		
		commentRepository.insert(entity);
		log.info("entity = " + entity.toString());
		
		return entity.getId();
	}
	
//	public int update(CommentDto dto) throws Exception {
//		int result = 0;
//		CommentEntity entity = dto.toEntity();
//
//		if(entity.getLastChgDate() == null || entity.getLastChgDate().length() <= 0) {
//			entity.setLastChgDate(DateFormat.getFormatString(System.currentTimeMillis(), null));
//		}
//		
//		result = commentRepository.update(entity);
//		
//		return result;
//	}
	
//	public int delete(long id) throws Exception {
//		int result = 0;		
//		result = commentRepository.delete(id);
//		
//		return result;
//	}
	
}
