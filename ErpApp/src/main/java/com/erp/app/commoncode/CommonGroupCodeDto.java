package com.erp.app.commoncode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonGroupCodeDto {
	private String code; // 공통코드 (CGC0000001)
	private String name;
	private String remark;
	private String useYn;
	private String firstRegDate;
	private String firstRegUserId;
	private String lastChgDate;
	private String lastChgUserId;
}
