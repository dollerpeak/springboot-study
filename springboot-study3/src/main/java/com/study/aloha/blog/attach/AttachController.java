package com.study.aloha.blog.attach;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.aloha.test.reponse.MediaUtill;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/aloha/blog/multipart/attach")
public class AttachController {
	@Autowired
	AttachService attachService;

	@GetMapping("/thumnail")
	public ResponseEntity<byte[]> thumnail(@RequestParam long id) throws Exception {
		log.info("thumnail");
		log.info("id = " + id);
		
		AttachDto dto = attachService.detail(id);
		String path = dto.getPath() + dto.getSaveName();
		log.info("path = " + path);
		
		File file = new File(path);
		byte[] byteData = FileCopyUtils.copyToByteArray(file);
		String ext = path.substring(path.lastIndexOf(".") + 1);
		
		MediaType mediaType = MediaUtill.getMediaType(ext);
		HttpHeaders httpHeaders = new HttpHeaders(); 
		httpHeaders.setContentType(mediaType);
		
		return new ResponseEntity<>(byteData, httpHeaders, HttpStatus.OK);
	}
	
	
}
