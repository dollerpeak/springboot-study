package com.study.aloha.test.reponse;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MediaUtill {
	static Map<String, MediaType> mediaType;
	
	static {
		mediaType = new HashMap<>();
		mediaType.put("JPG", MediaType.IMAGE_JPEG);
		mediaType.put("JPEG", MediaType.IMAGE_JPEG);
		mediaType.put("PNG", MediaType.IMAGE_PNG);
		mediaType.put("WEBP", MediaType.parseMediaType("image/webp"));	
	}
	
//	public static MediaType getMediaType() {
//		Map<String, String> mediaType = new HashMap<>();
//		mediaType.put("JPG", MediaType.IMAGE_JPEG);
//		mediaType.put("JPEG", MediaType.IMAGE_JPEG);
//		mediaType.put("PNG", MediaType.IMAGE_PNG);
//		mediaType.put("WEBP", MediaType.parseMediaType("image/webp"));
//	}
	
	public static MediaType getMediaType(String ext) {
//		log.info("ext = " + ext);
		MediaType type = mediaType.get(ext.toUpperCase());
//		log.info("type = " + type);
		
		return type;
	}
	
	
	
	
}
