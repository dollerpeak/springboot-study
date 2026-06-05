package com.erp.app.global.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonResponseCode implements ResponseCode {
	SUCCESS("COM_200", "성공"), 
	//
	ERROR_REQUEST("COM_400", "요청 데이터가 유효하지 않습니다."),
	ERROR_SELECT("COM_401", "데이터 조회에 실패했습니다."),
	ERROR_INSERT("COM_402", "데이터 저장에 실패했습니다."),
	ERROR_UPDATE("COM_403", "데이터 업데이트에 실패했습니다."),
	ERROR_DELETE("COM_404", "데이터 삭제에 실패했습니다."),
	//
	ERROR_SERVER("COM_500", "서버 내부 오류가 발생했습니다.");	

	private final String code;
	private final String message;

}
