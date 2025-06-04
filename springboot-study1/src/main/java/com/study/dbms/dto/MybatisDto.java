package com.study.dbms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MybatisDto {
	private int id;
	private String title;
	private String content;
	private String name;
	private int hit;
	private String regDate; 
	private String chgDate;
}
