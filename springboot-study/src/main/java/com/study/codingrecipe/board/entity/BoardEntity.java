package com.study.codingrecipe.board.entity;

import com.study.codingrecipe.board.dto.BoardDto;

import lombok.Data;

@Data
public class BoardEntity {
	private long seq = 0;
	private String title;
	private String contents;
	private String password;
	private int hits;
	private String frstRegDate;
	private String frstRegUserId;
	private String lastChgDate;
	private String lastChgUserId;

	public BoardDto toBoardDto() {
		BoardDto boardDto = new BoardDto();

		boardDto.setSeq(seq);
		boardDto.setTitle(title);
		boardDto.setContents(contents);
		boardDto.setPassword(password);
		boardDto.setHits(hits);
		boardDto.setFrstRegDate(frstRegDate);
		boardDto.setFrstRegUserId(frstRegUserId);
		boardDto.setLastChgDate(lastChgDate);
		boardDto.setLastChgUserId(lastChgUserId);

		return boardDto;
	}

}
