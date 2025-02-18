package com.study.metacoding.blog.panel.dto;

import com.study.metacoding.blog.panel.entity.PanelEntity;

import lombok.Data;

@Data
public class PanelDto {
	private int id;
	private String title;
	private String contents;
	private int hits;
	private int userId;
	private String frstRegDate;
	private String frstRegUserId;
	private String lastChgDate;
	private String lastChgUserId;

	//private UserDto userDto;

	public PanelEntity toPanelEntity() {
		PanelEntity panelEntity = new PanelEntity();

		panelEntity.setId(id);
		panelEntity.setTitle(title);
		panelEntity.setContents(contents);
		panelEntity.setHits(hits);
		panelEntity.setUserId(userId);
		panelEntity.setFrstRegDate(frstRegDate);
		panelEntity.setFrstRegUserId(frstRegUserId);
		panelEntity.setLastChgDate(lastChgDate);
		panelEntity.setLastChgUserId(lastChgUserId);
		
		//userDto.getId()

		return panelEntity;
	}

}
