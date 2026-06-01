package com.erp.app.commongroupcode;

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
public class CommonGroupCodeDto {
	private String code; // 그룹코드 (CG00000001)
	private String name;
	private String remark;
	private String useYn;
	private String firstRegDate;
	private String firstRegUserId;
	private String lastChgDate;
	private String lastChgUserId;
}
