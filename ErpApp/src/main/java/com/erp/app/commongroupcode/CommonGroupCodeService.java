package com.erp.app.commongroupcode;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erp.app.global.code.CommonResponseCode;
import com.erp.app.global.exception.BusinessException;

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

		int result = commonGroupCodeMapper.insert(dto);
		if (result == 0) {
			throw new BusinessException(CommonResponseCode.ERROR_INSERT);
		}

		return result;
	}

	public CommonGroupCodeDto selectDetail(String code) {
		CommonGroupCodeDto dto = commonGroupCodeMapper.selectByCode(code);
		
		return dto;
	}

	public List<CommonGroupCodeDto> selectList(CommonGroupCodeDto dto) {
		List<CommonGroupCodeDto> dtoList = commonGroupCodeMapper.selectList(dto);
		
		return dtoList;
	}

	public int update(CommonGroupCodeDto dto) {
		int result = commonGroupCodeMapper.update(dto);
		if (result == 0) {
			throw new BusinessException(CommonResponseCode.ERROR_UPDATE);
		}
		
		return result;
	}

	public int delete(String code) {
		int result = commonGroupCodeMapper.delete(code);
		if (result == 0) {
			throw new BusinessException(CommonResponseCode.ERROR_DELETE);
		}
		
		return result;
	}
	
	// add

}
