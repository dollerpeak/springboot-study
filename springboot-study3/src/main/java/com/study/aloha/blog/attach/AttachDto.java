package com.study.aloha.blog.attach;

import lombok.Data;

@Data
public class AttachDto {
	private long id;
	private long blogId;
	private String originalName;
	private String saveName;
	private String path;
	private String size;
	private String frstRegDate;
	private String frstRegUserId;
	private String lastChgDate;
	private String lastChgUserId;
	
	public AttachEntity toEntity() {
		AttachEntity entity = new AttachEntity();
		
		entity.setId(id);
		entity.setBlogId(blogId);
		entity.setOriginalName(originalName);
		entity.setSaveName(saveName);
		entity.setPath(path);
		entity.setSize(size);
		entity.setFrstRegDate(frstRegDate);
		entity.setFrstRegUserId(frstRegUserId);
		entity.setLastChgDate(lastChgDate);
		entity.setLastChgUserId(lastChgUserId);
		
		return entity;
	}
}
