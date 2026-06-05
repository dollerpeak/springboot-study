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
public class CommonCodeService {

	private final CommonCodeMapper commonCodeMapper;
	
	// basic
	public int insert(CommonCodeDto dto) {
		String nextCode;
		CommonCodeDto maxDto = commonCodeMapper.selectMaxCode(dto.getGroupCode());		
		dto.setCode(maxDto.getCode());
		dto.setSortOrder(maxDto.getSortOrder());

		if (dto.getCode() == null || dto.getCode().isEmpty()) {
			// 초기값
			nextCode = "CC00000001";
			dto.setSortOrder(0);
		} else {
			// CC + 00000001
			int sequence = Integer.parseInt(dto.getCode().substring(2)) + 1;
			nextCode = "CC" + String.format("%08d", sequence);
			dto.setSortOrder(dto.getSortOrder() + 1);
		}
		dto.setCode(nextCode);

		return commonCodeMapper.insert(dto);
	}

	public CommonCodeDto selectDetail(CommonCodeDto dto) {
		return commonCodeMapper.selectByCode(dto);
	}

	public List<CommonCodeDto> selectList(CommonCodeDto dto) {
		return commonCodeMapper.selectList(dto);
	}

	public int update(CommonCodeDto dto) {
		return commonCodeMapper.update(dto);
	}

	public int delete(CommonCodeDto dto) {
		return commonCodeMapper.delete(dto);
	}

	// add

}
