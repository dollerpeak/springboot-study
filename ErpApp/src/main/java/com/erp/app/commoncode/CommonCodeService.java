package com.erp.app.commoncode;

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

		int result = commonCodeMapper.insert(dto);
		if (result == 0) {
			throw new BusinessException(CommonResponseCode.ERROR_INSERT);
		}

		return result;
	}

	public CommonCodeDto selectDetail(CommonCodeDto dto) {
		CommonCodeDto resultDto = commonCodeMapper.selectByCode(dto);

		return resultDto;
	}

	public List<CommonCodeDto> selectList(CommonCodeDto dto) {
		List<CommonCodeDto> dtoList = commonCodeMapper.selectList(dto);

		return dtoList;
	}

	public int update(CommonCodeDto dto) {
		int result = commonCodeMapper.update(dto);
		if (result == 0) {
			throw new BusinessException(CommonResponseCode.ERROR_UPDATE);
		}

		return result;
	}

	public int delete(CommonCodeDto dto) {
		int result = commonCodeMapper.delete(dto);
		if (result == 0) {
			throw new BusinessException(CommonResponseCode.ERROR_DELETE);
		}

		return result;
	}

	// add

}
