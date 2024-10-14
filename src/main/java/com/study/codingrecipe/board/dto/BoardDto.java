package com.study.codingrecipe.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDto {
	private long id;
	private String title;
	private String contents;
	private String writer;
	private String password;	
	private int hits;
	private String createdAt;
	private String frstRegDate;
	private String frstRegUserId;
	private String lastChgDate;
	private String lastChgUserId;
}
