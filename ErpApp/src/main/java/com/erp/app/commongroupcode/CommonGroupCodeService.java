package com.erp.app.commongroupcode;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class CommonGroupCodeService {

	private final CommonGroupCodeMapper commonGroupCodeMapper;

	// basic
	public int insert(CommonGroupCodeDto dto) {
		String nextCode;
		String maxCode = commonGroupCodeMapper.selectMaxGroupCode();		

		if (maxCode == null || maxCode.isEmpty()) {
			// 초기값
			nextCode = "CG00000001";
		} else {
			// CG + 00000001
			int sequence = Integer.parseInt(maxCode.substring(2)) + 1;
			nextCode = "CG" + String.format("%08d", sequence);
		}
		dto.setCode(nextCode);

		return commonGroupCodeMapper.insert(dto);
	}

	public CommonGroupCodeDto selectDetail(String code) {
		return commonGroupCodeMapper.selectByCode(code);
	}

	public List<CommonGroupCodeDto> selectList(CommonGroupCodeDto dto) {
		return commonGroupCodeMapper.selectList(dto);
	}

	public int update(CommonGroupCodeDto dto) {
		return commonGroupCodeMapper.update(dto);
	}

	public int delete(String code) {
		return commonGroupCodeMapper.delete(code);
	}
	
	// add

}
