package com.erp.app.commongroupcode;

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
@RequestMapping("/api/commongroupcode")
@RequiredArgsConstructor
public class CommonGroupCodeController {

	private final CommonGroupCodeService commonGroupCodeService;

	// basic
	@PostMapping("/insert")
	public ResponseEntity<Integer> insert(@RequestBody CommonGroupCodeDto dto) {
		return ResponseEntity.ok(commonGroupCodeService.insert(dto));
	}

	@GetMapping("/detail/{code}")
    public ResponseEntity<CommonGroupCodeDto> selectByCode(@PathVariable String code) {
        return ResponseEntity.ok(commonGroupCodeService.selectDetail(code));
    }

	@PostMapping("/list")
	public ResponseEntity<List<CommonGroupCodeDto>> selectList(@RequestBody(required = false) CommonGroupCodeDto dto) {
		return ResponseEntity.ok(commonGroupCodeService.selectList(dto));
	}

	@PostMapping("/update")
	public ResponseEntity<Integer> update(@RequestBody CommonGroupCodeDto dto) {
		return ResponseEntity.ok(commonGroupCodeService.update(dto));
	}

	@GetMapping("/delete/{code}")
    public ResponseEntity<Integer> delete(@PathVariable String code) {
        return ResponseEntity.ok(commonGroupCodeService.delete(code));
    }

}
