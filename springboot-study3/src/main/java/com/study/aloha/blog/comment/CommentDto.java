package com.study.aloha.blog.comment;

import lombok.Data;

@Data
public class CommentDto {
	private long id;
	private long blogId;
	private String writer;
	private String contents;
	private String frstRegDate;
	private String frstRegUserId;
	private String lastChgDate;
	private String lastChgUserId;
	
	public CommentEntity toEntity() {
		CommentEntity entity = new CommentEntity();
		
		entity.setId(id);
		entity.setBlogId(blogId);
		entity.setWriter(writer);
		entity.setContents(contents);
		entity.setFrstRegDate(frstRegDate);
		entity.setFrstRegUserId(frstRegUserId);
		entity.setLastChgDate(lastChgDate);
		entity.setLastChgUserId(lastChgUserId);
		
		return entity;
	}
}
