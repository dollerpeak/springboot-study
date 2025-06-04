package com.study.aloha.blog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class Blog {
	long id;
	String title;
	String writer;
	String content;
	String regDate;
	String upDate;
	
//	public Blog(String nTitle, String nWriter, String nContent) {
//		id = 0;
//		title = nTitle;
//		writer = nWriter;
//		content = nContent;
//		regDate = "";
//		upDate = "";
//	}
}
