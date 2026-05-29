package com.erp.app.commoncode;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonGroupCodeMapper {

	int insert(CommonGroupCodeDto dto);
	CommonGroupCodeDto selectByCode(String code);
	List<CommonGroupCodeDto> selectList(CommonGroupCodeDto searchDto);
	int update(CommonGroupCodeDto dto);
	int delete(String code);
	
	// add
	String selectMaxGroupCode();
}
