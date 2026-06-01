package com.erp.app.commongroupcode;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommonGroupCodeMapper {

	// basic
	int insert(CommonGroupCodeDto dto);
	CommonGroupCodeDto selectByCode(String code);
	List<CommonGroupCodeDto> selectList(CommonGroupCodeDto dto);
	int update(CommonGroupCodeDto dto);
	int delete(String code);
	
	// add
	String selectMaxGroupCode();
}
