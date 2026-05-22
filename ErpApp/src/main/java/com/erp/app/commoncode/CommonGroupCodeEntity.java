package com.erp.app.commoncode;

import java.time.format.DateTimeFormatter;

import com.erp.app.global.domain.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CommonGroupCodeEntity extends BaseEntity {
	private String code; // 그룹코드 (CGC0000001)
	private String name;
	private String remark;
	private String useYn;

	public CommonGroupCodeDto toDto() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		CommonGroupCodeDto dto = new CommonGroupCodeDto();
		dto.setCode(this.code);
		dto.setName(this.name);
		dto.setRemark(this.remark);
		dto.setUseYn(this.useYn);
		dto.setFirstRegDate(this.getFirstRegDate() != null ? this.getFirstRegDate().format(formatter) : null);
		dto.setFirstRegUserId(this.getFirstRegUserId());
		dto.setLastChgDate(this.getLastChgDate() != null ? this.getLastChgDate().format(formatter) : null);
		dto.setLastChgUserId(this.getLastChgUserId());

		return dto;
	}
}
