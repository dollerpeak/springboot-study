package com.erp.app.commoncode;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonCodeMapper {

	// basic
	int insert(CommonCodeDto dto);
	CommonCodeDto selectByCode(CommonCodeDto dto);
	List<CommonCodeDto> selectList(CommonCodeDto dto);
	int update(CommonCodeDto dto);
	int delete(String code);

	// add
	CommonCodeDto selectMaxCode(String groupCode);

}
