package com.study.metacoding.blog.entity;

import com.study.metacoding.blog.dto.ReplyDto;

import lombok.Data;

@Data
public class ReplyEntity {
	private int id;
	private String contents;
	private int panelId;
	private int userId;
	private String frstRegDate;
	private String frstRegUserId;
	private String lastChgDate;
	private String lastChgUserId;

	public ReplyDto toReplyDto() {
		ReplyDto replyDto = new ReplyDto();

		replyDto.setId(id);
		replyDto.setContents(contents);
		replyDto.setPanelId(panelId);
		replyDto.setUserId(userId);
		replyDto.setFrstRegDate(frstRegDate);
		replyDto.setFrstRegUserId(frstRegUserId);
		replyDto.setLastChgDate(lastChgDate);
		replyDto.setLastChgUserId(lastChgUserId);

		return replyDto;
	}
}
