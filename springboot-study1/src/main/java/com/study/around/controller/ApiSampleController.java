package com.study.around.controller;

import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.around.data.dto.ApiSampleDTO;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/around/api")
@Tag(name = "ApiSampleController", description = "desc ApiSampleController")
public class ApiSampleController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	// API를 통해 값을 전달하는 방법
	
	// @PathVariable
	// - URL에 값을 전달 : http://localhost:8081/around/api/test8/value
	// - mapping에 값을 명시 해야함 : @GetMapping("/test8/{name}")
	// - 하나의 URL에 여러값을 전달할 수 있음
	// - value옵션을 사용할 수 있음 : URL에 있는 {}이름과 아큐먼트이름이 같지 않아도 됨
	//   @GetMapping("/test9/{name}")
	//   public String test9(@PathVariable(value = "name") String value) {
	
	// @RequestParam (query string)	
	// - URL에 값을 전달 : http://localhost:8081/around/api/test3?name=value
	//   전달 방식은 URL끝에 ?시작하고 값은 key=value 형식이고 연결은 &
	// - mapping에는 URL까지만 작성
	// - value, required, defaultValue 사용가능
	// - key=value형식의 값이므로 Map, DTO형태로도 받을 수 있음
	// - 아무런 어노테이션이 없다면 @RequestParam 이 디폴트
	
	// @RequestBody
	// - request body에 값을 전달하는 방식으로 주로 POST에서 사용
	// - 꼭 @RequestBody 필요

	@GetMapping("/test1")
	public String test1() {
		// http://localhost:8081/around/api/test1
		// 파라메터가 없는 경우
		logger.info("hell world");
		return "hell world";
	}

	// default는 @RequestParam으로 작동함
	@GetMapping("/test2")
	public String test2(@RequestParam String name) {
		// http://localhost:8081/around/api/test2
		// - 파라메터가 없어도 에러가 안남
		// - name말고 다른 파라메터로 넘어가도 에러 안남
		// System.out.println("name = " + name);
		logger.info("name = {}", name);
		return name;
	}

	// @RequestParam test
	@GetMapping("/test3")
	public String test3(@RequestParam(defaultValue = "default") String name) {
		// http://localhost:8081/around/api/test3?name=value
		// - 파라메터가 없어도 에러 발생하지 않고 디폴트값 출력
		// - name말고 다른 파라메터로 넘겨도 에러나지 않고 디폴트값 출력
		logger.info("name = {}", name);
		return name;
	}

	// required는 동일명의 파라메터가 있는지만 체크
	// required로 에로 조건이라도 defaultValue값이 있으면 에러는 발생 안함
	@GetMapping("/test4")
	public String test4(@RequestParam(required = false, defaultValue = "default") String name) {
		// http://localhost:8081/around/api/test4?name=value
		logger.info("name = {}", name);
		return name;
	}

	@GetMapping("/test5")
	public String test5(@RequestParam(required = true, defaultValue = "default") String name) {
		// http://localhost:8081/around/api/test5?name=value
		logger.info("name = {}", name);
		return name;
	}

	@GetMapping("/test6")
	public String test6(@RequestParam(value = "name", defaultValue = "default") String value) {
		// http://localhost:8081/around/api/test5?name=value
		// - value = "name"과 uri의 동일값으로 value에 적용됨
		logger.info("value = {}", value);
		return value;
	}

	@GetMapping("/test7")
	public String test7(String value1, String value2) {
		// http://localhost:8081/around/api/test7?value1=aaa&value2=bbb
		// - value = "name"과 uri의 동일값으로 value에 적용됨
		logger.info("value1 = {}, value2 = {}, value1+value2 = {}", value1, value2, value1+value2);
		return value1 + value2;
	}

	// @RequestParam, map파라메터 예제
	// - URL은 동일하고 변수가 키가 된다.
	@GetMapping("/test71")
	public String test71(@RequestParam Map<String, String> map) {
		// http://localhost:8081/around/api/test71?value1=aaa&value2=bbb
		// System.out.println(map.toString());

		String result = "";
		for (Entry<String, String> entry : map.entrySet()) {
			result += entry.getKey() + entry.getValue();
		}

		logger.info("result = {}", result);
		return result;
	}

	// @PathVariable test
	@GetMapping("/test8/{name}")
	public String test8(@PathVariable String name) {
		// http://localhost:8081/around/api/test8/value
		logger.info("name = {}", name);
		return name;
	}

	// @PathVariable도 value = "name" 옵션은 사용 가능함
	@GetMapping("/test9/{name}")
	public String test9(@PathVariable(value = "name") String value) {
		// http://localhost:8081/around/api/test9/value
		logger.info("value = {}", value);
		return value;
	}

	// @PathVariable, 여러개도 가능
	@GetMapping("/test10/{value1}/{value2}")
	public String test10(@PathVariable String value1, @PathVariable String value2) {
		// http://localhost:8081/around/api/test10/aaa/bbb
		logger.info("value1 = {}, value2 = {}, value1+value2 = {}", value1, value2, value1+value2);
		return value1 + value2;
	}

	// @PathVariable, 여러개도 가능
	@GetMapping("/test101/1/{value1}/2/{value2}")
	public String test101(@PathVariable String value1, @PathVariable String value2) {
		// http://localhost:8081/around/api/test101/1/abb/2/bcc
		logger.info("value1 = {}, value2 = {}, value1+value2 = {}", value1, value2, value1+value2);
		return value1 + value2;
	}

	// ///////////////////////////////////////////////////////////////////////////
	// DTO로 받는 방법
	// - @RequestParam, @PathVariable, @RequestBody 사용하지 않는다.
	// ///////////////////////////////////////////////////////////////////////////
	@GetMapping("/test11")
	public String test11(ApiSampleDTO dto) {
		// http://localhost:8081/around/api/test11?id=a&name=b&age=10
		// System.out.println(dto.toString());
		logger.info("dto = {}", dto.toString());
		return dto.toString();
	}

	// POST
	@PostMapping("/test12")
	public String test12(@RequestBody ApiSampleDTO dto) {
		// http://localhost:8081/around/api/test11?id=a&name=b&age=10
		logger.info("dto = {}", dto.toString());
		return dto.toString();
	}

	@PostMapping("/test13")
	public String test13(@RequestBody Map<String, String> map) {
		// http://localhost:8081/around/api/test11?id=a&name=b&age=10
		String reval = "";

		for (Entry<String, String> entry : map.entrySet()) {
			reval += entry.getKey() + entry.getValue();
		}

		logger.info("reval = {}", reval);
		return reval;
	}

}
