package com.study.aloha.test.reponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.aloha.test.request.RequestBoard;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/aloha/test/response")
public class ControllerResponse {

	@GetMapping(value = "/login")
	public String user() {
//	public void user() {
		log.info("[GET] - /login - 로그인 페이지");
		return "/aloha/test/response/login";
	}

	@GetMapping(value = { "/", "" })
	public String home() {
		log.info("[GET] - / - 메인 페이지");
		log.info("<<<<<<<<<<<<<< Aloha test Response >>>>>>>>>>>>>>");
		return "/aloha/test/response/index";
	}

	@ResponseBody
	@GetMapping(value = "/hello")
	public String hello() {
		log.info("[GET] - /hello - 뷰가 아닌 문자열 본문을 응답합니다.");
		return "Hello Spring Boot~!";
	}
	
	@ResponseBody
	@GetMapping(value = "/object")
	public RequestBoard object() {
		RequestBoard requestBoard = new RequestBoard("제목", "작성자", "내용");
		return requestBoard;
	}
	
	@ResponseBody
	@GetMapping(value = "/entity")
	public ResponseEntity<String> entity() {		
		//return new ResponseEntity<>("success", HttpStatus.OK);
		return new ResponseEntity<>("bad request", HttpStatus.BAD_REQUEST);
	}
	
	
	// 이미지 보여주기
	@ResponseBody
	@GetMapping(value = "/show1")
	public ResponseEntity<byte[]> show1() throws IOException {
		// http://localhost:8081/aloha/test/response/show1
		log.info("[GET] - show1");
		//ClassPathResource imageFile = new ClassPathResource("/static/file/hamburger.png");
		ClassPathResource imageFile = new ClassPathResource("/static/file/beef.jpg");
		byte[] imageByte = imageFile.getContentAsByteArray();
		
		HttpHeaders httpHeaders = new HttpHeaders();
		//httpHeaders.setContentType(MediaType.IMAGE_PNG);
		httpHeaders.setContentType(MediaType.IMAGE_JPEG);

		return new ResponseEntity<>(imageByte, httpHeaders, HttpStatus.OK);
	}
	
//	@ResponseBody
	@GetMapping(value = "/show2")
	public void show2(@RequestParam String path, HttpServletResponse response) throws Exception {
		// http://localhost:8081/aloha/test/response/show2?path=C:/Users/P088454/Downloads/m3.PNG
		log.info("[GET] - show2");
		log.info("path = " + path);

		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		ServletOutputStream sos = response.getOutputStream();		
		FileCopyUtils.copy(fis, sos);

		// 확장자 구분이 필요함
		//response.setContentType(MediaType.IMAGE_JPEG.toString());
		String ext = path.substring(path.lastIndexOf(".") + 1);
//		log.info("ext = " + ext);
//		log.info("mediatype = " + MediaUtill.getMediaType(ext).toString());
		response.setContentType(MediaUtill.getMediaType(ext).toString());

	}
	
	// 이미지 다운로드
	@ResponseBody
	@GetMapping(value = "/download1")
	public ResponseEntity<byte[]> download1() throws IOException {
		log.info("[GET] - download1");
		ClassPathResource imageFile = new ClassPathResource("/static/file/beef.jpg");
		byte[] imageByte = imageFile.getContentAsByteArray();
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		httpHeaders.setContentDispositionFormData("attchment", "111.jpg");
		
		// 테스트
		//Path path = Paths.get("/static/file").resolve("beef.jpg").normalize();
		//log.info("path = " + path.toString());
		//byte[] testByte = Files.readAllBytes(path); // 왜 에러나지?

		return new ResponseEntity<>(imageByte, httpHeaders, HttpStatus.OK);
	}
	
	@ResponseBody
	@GetMapping(value = "/download2")
	public void download2(@RequestParam String path, HttpServletResponse response) throws Exception {
		// http://localhost:8081/aloha/test/response/download2?path=C:/Users/P088454/Downloads/m3.PNG
		log.info("[GET] - download2");
		log.info("path = " + path);
		
		response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attchment; filename=222.jpg");

		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		ServletOutputStream sos = response.getOutputStream();		
		FileCopyUtils.copy(fis, sos);
		
		// 테스트, MediaType을 지정해 줌
		Path testPath = Paths.get(path.toString());
		String mediaType = Files.probeContentType(testPath);		
		log.info("mediaType = " + mediaType);		
		//HttpHeaders httpHeaders = new HttpHeaders();
		//httpHeaders.add(HttpHeaders.CONTENT_TYPE, mediaType);
		//httpHeaders.setContentDisposition(ContentDisposition.builder("attchment").filename("222.jpg").build());
		// "/static/file/beef.jpg"
	}

}



