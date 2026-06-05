package com.erp.app.commongroupcode;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/api/commongroupcode")
@RequiredArgsConstructor
public class CommonGroupCodeController {

	private final CommonGroupCodeService commonGroupCodeService;

	// basic
	@PostMapping("/insert")
	public ResponseEntity<ApiResponse<Integer>> insert(@RequestBody CommonGroupCodeDto dto) {
		if (dto == null) {
			throw new BusinessException(CommonResponseCode.ERROR_REQUEST);
		}

		if (dto.getName() == null || dto.getName().isBlank() == true) {
			throw new BusinessException(CommonGroupCodeErrorCode.ERROR_002);
		}

		int result = commonGroupCodeService.insert(dto);

		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, CommonResponseCode.SUCCESS, result));
	}

	@GetMapping("/detail/{code}")
	public ResponseEntity<ApiResponse<CommonGroupCodeDto>> selectByCode(@PathVariable String code) {
		CommonGroupCodeDto dto = commonGroupCodeService.selectDetail(code);

		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, CommonResponseCode.SUCCESS, dto));
	}

	@PostMapping("/list")
	public ResponseEntity<ApiResponse<List<CommonGroupCodeDto>>> selectList(@RequestBody(required = false) CommonGroupCodeDto dto) {
		List<CommonGroupCodeDto> dtoList = commonGroupCodeService.selectList(dto);

		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, CommonResponseCode.SUCCESS, dtoList));
	}

	@PostMapping("/update")
	public ResponseEntity<ApiResponse<Integer>> update(@RequestBody CommonGroupCodeDto dto) {
		if (dto == null) {
			throw new BusinessException(CommonResponseCode.ERROR_REQUEST);
		}

		if (dto.getCode() == null || dto.getCode().isBlank() == true) {
			throw new BusinessException(CommonGroupCodeErrorCode.ERROR_001);
		}
		
		int result = commonGroupCodeService.update(dto);

		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, CommonResponseCode.SUCCESS, result));
	}

	@GetMapping("/delete/{code}")
    public ResponseEntity<ApiResponse<Integer>> delete(@PathVariable String code) {
		int result = commonGroupCodeService.delete(code);
		
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, CommonResponseCode.SUCCESS, result));
    }

}
