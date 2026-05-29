package com.erp.app.commoncode;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/commoncode")
@RequiredArgsConstructor
public class CommonGroupCodeController {

	private final CommonGroupCodeService commonGroupCodeService;

	@PostMapping("/insert")
	public ResponseEntity<Integer> insert(@RequestBody CommonGroupCodeDto dto) {
		return ResponseEntity.ok(commonGroupCodeService.insert(dto));
	}

	@PostMapping("/detail")
	public ResponseEntity<CommonGroupCodeDto> selectByCode(@RequestBody CommonGroupCodeDto dto) {
		return ResponseEntity.ok(commonGroupCodeService.selectDetail(dto.getCode()));
	}

	@PostMapping("/list")
	public ResponseEntity<List<CommonGroupCodeDto>> selectList(@RequestBody CommonGroupCodeDto searchDto) {
		return ResponseEntity.ok(commonGroupCodeService.selectList(searchDto));
	}

	@PostMapping("/update")
	public ResponseEntity<Integer> update(@RequestBody CommonGroupCodeDto dto) {
		return ResponseEntity.ok(commonGroupCodeService.update(dto));
	}

	@PostMapping("/delete")
	public ResponseEntity<Integer> delete(@RequestBody CommonGroupCodeDto dto) {
		return ResponseEntity.ok(commonGroupCodeService.delete(dto.getCode()));
	}

}
