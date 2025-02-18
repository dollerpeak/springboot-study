package com.study.metacoding.blog.dto;

import com.study.metacoding.blog.entity.ReplyEntity;

import lombok.Data;

@Data
public class ReplyDto {
	private int id;
	private String contents;
	private int panelId;
	private int userId;
	private String frstRegDate;
	private String frstRegUserId;
	private String lastChgDate;
	private String lastChgUserId;

	public ReplyEntity toReplyEntity() {
		ReplyEntity replyEntity = new ReplyEntity();

		replyEntity.setId(id);
		replyEntity.setContents(contents);
		replyEntity.setPanelId(panelId);
		replyEntity.setUserId(userId);
		replyEntity.setFrstRegDate(frstRegDate);
		replyEntity.setFrstRegUserId(frstRegUserId);
		replyEntity.setLastChgDate(lastChgDate);
		replyEntity.setLastChgUserId(lastChgUserId);

		return replyEntity;
	}

}
