package com.study.aloha.blog.comment;

import lombok.Data;

@Data
public class CommentEntity {
	private long id;
	private long blogId;
	private String writer;
	private String contents;
	private String frstRegDate;
	private String frstRegUserId;
	private String lastChgDate;
	private String lastChgUserId;
	
	public CommentDto toDto() {
		CommentDto dto = new CommentDto();
		
		dto.setId(id);
		dto.setBlogId(blogId);
		dto.setWriter(writer);
		dto.setContents(contents);
		dto.setFrstRegDate(frstRegDate);
		dto.setFrstRegUserId(frstRegUserId);
		dto.setLastChgDate(lastChgDate);
		dto.setLastChgUserId(lastChgUserId);
		
		return dto;
	}
}
