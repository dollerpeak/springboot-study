package com.study.metacoding.blog.user.controller;
//package com.study.metacoding.blog.controller;
//
//import java.util.List;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.study.metacoding.blog.dto.UserDto;
//import com.study.metacoding.blog.service.UserService;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@RestController
//@RequestMapping("/metacoding/user")
//@RequiredArgsConstructor
//@Slf4j
//public class UserRestController {
//	private final UserService userService;
//	
////	@Autowired
////	private HttpServletRequest request;
////	@Autowired
////	private HttpServletResponse response;
//
//	@PostMapping("/insert")
//	public int insert(@RequestBody UserDto nUserDto) {
//		log.info(nUserDto.toString());
//
//		int row = -1;
//
//		try {
//			row = userService.insert(nUserDto);
//			log.info("row = " + row);
//		} catch (Exception e) {
//			log.error("e = " + e.toString());
//		}
//
//		return row;
//	}
//	
////	@ExceptionHandler
////	public ResponseEntity<Map<String, Integer>> errorHandle(Exception e){
////		log.info("e = " + e.toString());
////		log.info("e = " + e.getMessage());
////		log.info("e = " + e.getStackTrace());
////		for(StackTraceElement ele		:e.getStackTrace()) {
////			log.info("e = " + ele.toString());
////		}
////		
//////		e.getStackTrace().
////		HttpStatus code = HttpStatus.NOT_FOUND;
////		log.info("ve = " + code.value());
////		log.info("ve = " + code.series());
////		log.info("ve = " + code.getReasonPhrase());
////
////		log.info("post::request.getMethod() = " + request.getMethod());
////		log.info("post::request.getProtocol() = " + request.getProtocol());
////		log.info("post::request.getScheme() = " + request.getScheme());
////		log.info("post::request.getRequestURL() = " + request.getRequestURL());
////		log.info("post::request.getRequestURI() = " + request.getRequestURI());
////		log.info("post::request.getQueryString() = " + request.getQueryString());
////
////		Map<String, Integer> map = new HashMap<>();
////		map.put("a", 0);
////		map.put("b", 1);
////		map.put("c", 2);
////		return new ResponseEntity<>(map, HttpStatus.OK);
////	}
//	
////	@GetMapping("/selectt/{id}")
////	public UserDto selectt(@PathVariable("id") int nId) {
////		UserDto userDto = new UserDto();
////
////		String str = "a";
////		int a = Integer.parseInt(str);	
////		
////		return userDto;
////	}
//	
//	@GetMapping("/select/{id}")
//	public UserDto select(@PathVariable("id") int nId) {
//		UserDto userDto = null;
//
//		try {
//			userDto = userService.select(nId);
//		} catch (Exception e) {
//			log.error("e = " + e.toString());
//		}
//
//		return userDto;
//	}
//
////	@GetMapping("/select/{id}")
////	public UserDto select(@PathVariable("id") int nId) throws Exception {
////		UserDto userDto = null;
////
//////		try {
////			userDto = userService.select(nId);
//////		} catch (Exception e) {
//////			log.error("e = " + e.toString());
//////		}
////		
//////		ResponseEntity<HttpStatus> entity = new ResponseEntity<>(HttpStatus.OK);
//////		log.info("entity = " + entity.toString());
//////		HttpHeaders header = new HttpHeaders();
//////		log.info("header = " + header.toString());
////			
////		String str = "a";
////		int a = Integer.parseInt(str);
////
////		return userDto;
////	}
//
//	@GetMapping("/selectAll")
//	public List<UserDto> selectAll() {
//		List<UserDto> userDtoList = null;
//
//		try {
//			userDtoList = userService.selectAll();
//		} catch (Exception e) {
//			log.error("e = " + e.toString());
//		}
//
//		return userDtoList;
//	}
//	
//	@PutMapping("/update/{id}")
//	public int update(@PathVariable("id") int nId, @RequestBody UserDto nChangeUserDto) {
//		// password, email 만 변경
//		log.info(nChangeUserDto.toString());
//
//		int row = -1;
//
//		try {
//			row = userService.update(nId, nChangeUserDto);
//			log.info("row = " + row);
//		} catch (Exception e) {
//			log.error("e = " + e.toString());
//		}
//
//		return row;
//	}
//
//	@GetMapping("/delete/{id}")
//	public int delete(@PathVariable("id") int nId) {
//		int row = -1;
//
//		try {
//			row = userService.delete(nId);
//		} catch (Exception e) {
//			log.error("e = " + e.toString());
//		}
//
//		return row;
//	}
//
//}
