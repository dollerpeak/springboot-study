package com.erp.app.commoncode;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.app.global.code.CommonResponseCode;
import com.erp.app.global.exception.BusinessException;
import com.erp.app.global.response.ApiResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/commoncode")
@RequiredArgsConstructor
public class CommonCodeController {

	private final CommonCodeService commonCodeService;

	// basic
	@PostMapping("/insert")
	public ResponseEntity<ApiResponse<Integer>> insert(@RequestBody CommonCodeDto dto) {
		if (dto == null) {
			throw new BusinessException(CommonResponseCode.ERROR_REQUEST);
		}

		if (dto.getGroupCode() == null || dto.getGroupCode().isBlank() == true) {
			throw new BusinessException(CommonCodeErrorCode.ERROR_001);
		}

		if (dto.getName() == null || dto.getName().isBlank() == true) {
			throw new BusinessException(CommonCodeErrorCode.ERROR_003);
		}

		int result = commonCodeService.insert(dto);

		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, CommonResponseCode.SUCCESS, result));
	}

	@PostMapping("/detail")
	public ResponseEntity<ApiResponse<CommonCodeDto>> selectByCode(@RequestBody CommonCodeDto dto) {
		CommonCodeDto resultDto = commonCodeService.selectDetail(dto);

		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, CommonResponseCode.SUCCESS, resultDto));
	}

	@PostMapping("/list")
	public ResponseEntity<ApiResponse<List<CommonCodeDto>>> selectList(@RequestBody(required = false) CommonCodeDto dto) {
		List<CommonCodeDto> dtoList = commonCodeService.selectList(dto);
		
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, CommonResponseCode.SUCCESS, dtoList));
	}

	@PostMapping("/update")
	public ResponseEntity<ApiResponse<Integer>> update(@RequestBody CommonCodeDto dto) {
		if (dto == null) {
			throw new BusinessException(CommonResponseCode.ERROR_REQUEST);
		}
		
		if (dto.getGroupCode() == null || dto.getGroupCode().isBlank() == true) {
			throw new BusinessException(CommonCodeErrorCode.ERROR_001);
		}

		if (dto.getCode() == null || dto.getCode().isBlank() == true) {
			throw new BusinessException(CommonCodeErrorCode.ERROR_002);
		}
		
		int result = commonCodeService.update(dto);
		
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, CommonResponseCode.SUCCESS, result));
	}

	@PostMapping("/delete")
	public ResponseEntity<ApiResponse<Integer>> delete(@RequestBody CommonCodeDto dto) {
		int result = commonCodeService.delete(dto);
		
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, CommonResponseCode.SUCCESS, result));
	}

}
