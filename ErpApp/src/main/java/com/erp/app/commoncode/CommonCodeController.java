package com.erp.app.commoncode;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class CommonCodeController {

	private final CommonCodeService commonCodeService;

	// basic
	@PostMapping("/insert")
	public ResponseEntity<Integer> insert(@RequestBody CommonCodeDto dto) {
		return ResponseEntity.ok(commonCodeService.insert(dto));
	}

	@PostMapping("/detail")
	public ResponseEntity<CommonCodeDto> selectByCode(@RequestBody CommonCodeDto dto) {
		return ResponseEntity.ok(commonCodeService.selectDetail(dto));
	}

	@PostMapping("/list")
	public ResponseEntity<List<CommonCodeDto>> selectList(@RequestBody(required = false) CommonCodeDto dto) {
		return ResponseEntity.ok(commonCodeService.selectList(dto));
	}

	@PostMapping("/update")
	public ResponseEntity<Integer> update(@RequestBody CommonCodeDto dto) {
		return ResponseEntity.ok(commonCodeService.update(dto));
	}

	@GetMapping("/delete/{code}")
	public ResponseEntity<Integer> delete(@PathVariable String code) {
		return ResponseEntity.ok(commonCodeService.delete(code));
	}

}
