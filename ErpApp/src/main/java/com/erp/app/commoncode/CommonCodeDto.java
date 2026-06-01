package com.erp.app.commoncode;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommonCodeDto {
	private String groupCode; // 그룹코드 (CG00000001)
	private String code; // 공통코드 (CC00000001)
	private String name;
	private int sortOrder;
	private String useYn;
	private String firstRegDate;
	private String firstRegUserId;
	private String lastChgDate;
	private String lastChgUserId;
}
