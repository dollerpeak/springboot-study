package com.study.aloha.test.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestBoard {
	int boardNo;
	String title;
	String writer;
	String content;
	String regDate;
	String updDate;
	int views;

	public RequestBoard(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}
}
