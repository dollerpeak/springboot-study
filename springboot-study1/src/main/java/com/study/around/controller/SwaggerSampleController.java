package com.study.around.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.around.data.dto.SwaggerSampleDTO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/around/swagger")
@Tag(name = "Controller 제목", description = "Controller 설명")
public class SwaggerSampleController {

	// Swagger
	// - swagger annotation만 적용하면 자동으로 생성된다.
	// - UI에서 실제 API call이 가능하다.
	// - annotation 괘많은데 몇개만 사용하자.
	//   @Tag, @Operation, @Parameter
	//   @ApiResponse는 케이스가 많아 선택사항으로 두자.
	// - @Parameter 전부 작성해 주면 UI에서 변수별 설명 및 예제까지 확인이 가능하다.
	// - @ApiResponse 케이스별로 다 작성을 해야되고 Error인경우 클래스도 매핑이 되어야 한다.
	// - @ApiResponse는 제외하고 @Parameter 까지는 작성해 주면 좋을 것 같다.

	// @PathVariable
	@GetMapping("/get/{value}")
	@Operation(summary = "@PathVariable 한개", description = "@PathVariable 한개 문자열 반환")
	@Parameter(name = "value", description = "문자열 한개", example = "test1", required = true) // default required = false
	public String getVariableOne(@PathVariable String value) {
		// http://localhost:8081/around/swagger/get/test1
		return value;
	}
	
	@GetMapping("/get/many/v1/{value1}/v2/{value2}/{v3}")
	@Operation(summary = "@PathVariable 여러개", description = "@PathVariable 여러개 문자열 반환")
	@Parameters({ @Parameter(name = "value1", description = "문자열", example = "test1", required = true),
			@Parameter(name = "value2", description = "문자열", example = "test2", required = true),
			@Parameter(name = "v3", description = "문자열", example = "test3", required = true) 
	})
	public String getVariableMany(@PathVariable String value1, @PathVariable String value2, @PathVariable String v3) {
		// http://localhost:8081/around/swagger/get/many/v1/test1/v2/test2/test3
		return value1 + value2 + v3;
	}
	
	@GetMapping("/get/dto/v1/{id}/v2/{name}/{age}")
	@Operation(summary = "@PathVariable 여러개", description = "@PathVariable 여러개 DTO반환")
	@Parameter(name = "id", description = "id문자열", example = "isid", required = true)
	@Parameter(name = "name", description = "name문자열", example = "isname", required = true)
	@Parameter(name = "age", description = "age", example = "12", required = true)
	public SwaggerSampleDTO getVariableManyToDto(@PathVariable String id, @PathVariable String name,
			@PathVariable String age) {
		// http://localhost:8081/around/swagger/get/dto/v1/isid/v2/isname/12
		SwaggerSampleDTO dto = new SwaggerSampleDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setAge(Integer.parseInt(age));

		return dto;
	}

	// @RequestParam
	@GetMapping("/get/one")
	@Operation(summary = "@RequestParam 한개", description = "@RequestParam 한개 문자열 반환")
	@Parameter(name = "value", description = "문자열", example = "test1", required = true)
	public String getParamOne(@RequestParam String value) {
		// http://localhost:8081/around/swagger/get/one?value=test1
		return value;
	}
	
	@GetMapping("/get/many")
	@Operation(summary = "@RequestParam 여러개", description = "@RequestParam 여러개 문자열 반환")
	@Parameter(name = "value", description = "문자열", example = "value1=test1&value2=test2", required = true)
	public String getParamMany(@RequestParam String value1, @RequestParam String value2) {
		// http://localhost:8081/around/swagger/get/many?value1=test1&value2=test2
		return value1 + value2;
	}
	
	@GetMapping("/get/map")
	@Operation(summary = "@RequestParam 여러개", description = "@RequestParam 여러개 map 반환")
	@Parameter(name = "map", description = "map", example = "key1=value1&key2=value2&key3=value3", required = true)
	public Map<String, String> getParamToMap(@RequestParam Map<String, String> map) {
		// http://localhost:8081/around/swagger/get/map?key1=value1&key2=value2&key3=value3
		return map;
	}
	
	@GetMapping("/get/dto")
	@Operation(summary = "@RequestParam 여러개", description = "@RequestParam 여러개 dto 반환")
	@Parameter(name = "map", description = "map", example = "key1=isid&key2=isname&key3=12", required = true)
	public SwaggerSampleDTO getParamToDto(@RequestParam Map<String, String> map) {
		// http://localhost:8081/around/swagger/get/dto?key1=isid&key2=isname&key3=12
		SwaggerSampleDTO dto = new SwaggerSampleDTO();
		dto.setId(map.get("key1"));
		dto.setName(map.get("key2"));
		dto.setAge(Integer.parseInt(map.get("key3")));

		return dto;
	}

	// @RequestBody
	@PostMapping("/post/map")
	@Operation(summary = "@RequestBody map", description = "@RequestBody map 받기")
	@Parameter(name = "map", description = "map", example = "http://localhost:8081/swagger/post/map", required = true)
	public Map<String, String> postToMap(@RequestBody Map<String, String> map) {
		// http://localhost:8081/around/swagger/post/map
		// "id": "isid",
		// "name": "isname",
		// "age": 12
		return map;
	}
		
	@PostMapping("/post/dto")
	@Operation(summary = "@RequestBody dto", description = "@RequestBody dto 받기")
	@Parameter(name = "dto", description = "dto", example = "http://localhost:8081/swagger/post/dto", required = true)
	@ApiResponses({
			@ApiResponse(responseCode = "200", description = "성공", content = @Content(schema = @Schema(implementation = SwaggerSampleDTO.class))),
			@ApiResponse(responseCode = "400", description = "클라이언트 에러", content = @Content(schema = @Schema(implementation = SwaggerSampleDTO.class))),
			@ApiResponse(responseCode = "500", description = "서버 에러", content = @Content(schema = @Schema(implementation = SwaggerSampleDTO.class))) 
	})
	public SwaggerSampleDTO postDto(@RequestBody SwaggerSampleDTO dto) {
		// http://localhost:8081/around/swagger/post/dto
		// "id": "isid",
		// "name": "isname",
		// "age": 12
		return dto;
	}
	
	@PostMapping("/post/entity")
	@Operation(summary = "@RequestBody ResponseEntity", description = "@RequestBody ResponseEntity 반환")
	public ResponseEntity<SwaggerSampleDTO> postEntity(@RequestBody SwaggerSampleDTO dto) {
		// http://localhost:8081/around/swagger/entity/dto
		// "id": "isid",
		// "name": "isname",
		// "age": 12
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);
	}
	
	
	
	
}
