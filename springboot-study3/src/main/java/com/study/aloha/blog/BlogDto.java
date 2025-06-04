package com.study.aloha.blog;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.study.aloha.blog.attach.AttachDto;

import lombok.Data;

@Data
public class BlogDto {
	long id;
	String title;
	String writer;
	String contents;
	int attachCount;
	String frstRegDate;
	String frstRegUserId;
	String lastChgDate;
	String lastChgUserId;
	
	List<MultipartFile> multipartFileList;
	List<AttachDto> attachList;
	
	public BlogEntity toEntity() {
		BlogEntity entity = new BlogEntity();
		
		entity.setId(id);
		entity.setTitle(title);
		entity.setWriter(writer);
		entity.setContents(contents);
		entity.setAttachCount(attachCount);
		entity.setFrstRegDate(frstRegDate);
		entity.setFrstRegUserId(frstRegUserId);
		entity.setLastChgDate(lastChgDate);
		entity.setLastChgUserId(lastChgUserId);
		
		return entity;
	}
}
