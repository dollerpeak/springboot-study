package com.study.metacoding.blog.panel.entity;


import com.study.metacoding.blog.panel.dto.PanelDto;

import lombok.Data;

@Data
public class PanelEntity {
	private int id;
	private String title;
	private String contents;
	private int hits;
	private int userId;
	private String frstRegDate;
	private String frstRegUserId;
	private String lastChgDate;
	private String lastChgUserId;
	
	public PanelDto toPanelDto() {
		PanelDto panelDto = new PanelDto();

		panelDto.setId(id);
		panelDto.setTitle(title);
		panelDto.setContents(contents);
		panelDto.setHits(hits);
		panelDto.setUserId(userId);
		panelDto.setFrstRegDate(frstRegDate);
		panelDto.setFrstRegUserId(frstRegUserId);
		panelDto.setLastChgDate(lastChgDate);
		panelDto.setLastChgUserId(lastChgUserId);
		
		//panelDto.setUserDto(userId);

		return panelDto;
	}
	
}
