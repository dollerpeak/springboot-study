package com.erp.app.commoncode;

import com.erp.app.global.domain.BaseDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonGroupCodeDto extends BaseDto {
	private String code; // 공통코드 (CC00000001)
	private String name;
	private String remark;
	private String useYn;

	public CommonGroupCodeEntity toEntity() {
		return CommonGroupCodeEntity.builder()
				.code(this.code)
				.name(this.name)
				.remark(this.remark)
				.useYn(this.useYn != null ? this.useYn : "Y")
				// firstRegDate는 mybatis에서 NOW()으로 적용
				.firstRegUserId(this.getFirstRegUserId())
				// lastChgDate는 mybatis에서 NOW()으로 적용
				.lastChgUserId(this.getLastChgUserId())
				.build();
	}
}
