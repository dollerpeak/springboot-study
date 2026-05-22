package com.erp.app.global.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseDto {
	private String firstRegDate; // 최초등록일
	private String firstRegUserId; // 최초등록자ID
	private String lastChgDate; // 최종변경일
	private String lastChgUserId; // 최종변경자ID
}
