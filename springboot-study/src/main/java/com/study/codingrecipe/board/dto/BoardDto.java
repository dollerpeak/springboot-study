package com.study.codingrecipe.board.dto;

import com.study.codingrecipe.board.entity.BoardEntity;

import lombok.Data;

@Data
public class BoardDto {
	private long seq;
	private String title;
	private String contents;
	private String password;
	private int hits;
	private String frstRegDate;
	private String frstRegUserId;
	private String lastChgDate;
	private String lastChgUserId;

	public BoardEntity toBoardEntity() {
		//BoardEntity boardEntity = new BoardEntity(seq, title, contents, password, hits, frstRegDate,
		//		frstRegUserId, lastChgDate, lastChgUserId);
		BoardEntity boardEntity = new BoardEntity();

		boardEntity.setSeq(seq);
		boardEntity.setTitle(title);
		boardEntity.setContents(contents);
		boardEntity.setPassword(password);
		boardEntity.setHits(hits);
		boardEntity.setFrstRegDate(frstRegDate);
		boardEntity.setFrstRegUserId(frstRegUserId);
		boardEntity.setLastChgDate(lastChgDate);
		boardEntity.setLastChgUserId(lastChgUserId);

		return boardEntity;
	}

}
