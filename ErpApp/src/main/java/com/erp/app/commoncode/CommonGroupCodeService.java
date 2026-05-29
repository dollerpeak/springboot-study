package com.erp.app.commoncode;

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

	public int insert(CommonGroupCodeDto dto) {
		String nextCode;
		String maxCode = commonGroupCodeMapper.selectMaxGroupCode();		

		if (maxCode == null || maxCode.isEmpty()) {
			// 초기값
			nextCode = "CGC0000001";
		} else {
			// CGC + 0000001
			int sequence = Integer.parseInt(maxCode.substring(3)) + 1;
			nextCode = "CGC" + String.format("%07d", sequence);
		}
		dto.setCode(nextCode);

		return commonGroupCodeMapper.insert(dto);
	}

	public CommonGroupCodeDto selectDetail(String code) {
		return commonGroupCodeMapper.selectByCode(code);
	}

	public List<CommonGroupCodeDto> selectList(CommonGroupCodeDto searchDto) {
		return commonGroupCodeMapper.selectList(searchDto);
	}

	public int update(CommonGroupCodeDto dto) {
		return commonGroupCodeMapper.update(dto);
	}

	public int delete(String code) {
		return commonGroupCodeMapper.delete(code);
	}

}
