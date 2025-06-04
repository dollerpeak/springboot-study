package com.study.aloha.blog.attach;

import lombok.Data;

@Data
public class AttachEntity {
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
	
	public AttachDto toDto() {
		AttachDto dto = new AttachDto();

		dto.setId(id);
		dto.setBlogId(blogId);
		dto.setOriginalName(originalName);
		dto.setSaveName(saveName);
		dto.setPath(path);
		dto.setSize(size);
		dto.setFrstRegDate(frstRegDate);
		dto.setFrstRegUserId(frstRegUserId);
		dto.setLastChgDate(lastChgDate);
		dto.setLastChgUserId(lastChgUserId);
		
		return dto;
	}
}
