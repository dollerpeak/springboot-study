package com.study.codingrecipe.board.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class BoardDto {
	private long id;
	private String title;
	private String contents;
	private String writer;
	private String password;	
	private int hits;
	private String frstRegDate;
	private String frstRegUserId;
	private String lastChgDate;
	private String lastChgUserId;
}
