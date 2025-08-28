package com.shm.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.yml")
public class Properties {
	private final Environment environment;

	@Autowired
	public Properties(Environment environment) {
		this.environment = environment;
	}

	public String getProperties(String path) {
		return environment.getProperty(path);
	}
	
//	// 모든 파일디렉토리 생성
//	void setFilePathCreate() throws Exception {
//		// root : upload
//		Path rootPath = Paths.get(getProperties("spring.servlet.multipart.location")).toAbsolutePath().normalize();
//		if (false == Files.exists(rootPath)) {
//			Files.createDirectories(rootPath);
//		}
//
//		// thumbnail
//		Path productThumbnailPath = Paths.get(getProperties("spring.servlet.multipart.location")
//				+ getProperties("project-set.location-image.product-thumbnail")).toAbsolutePath().normalize();
//		if (false == Files.exists(productThumbnailPath)) {
//			Files.createDirectories(productThumbnailPath);
//		}
//
//		// detail
//		Path productDetailPath = Paths.get(getProperties("spring.servlet.multipart.location")
//				+ getProperties("project-set.location-image.product-detail")).toAbsolutePath().normalize();
//		if (false == Files.exists(productDetailPath)) {
//			Files.createDirectories(productDetailPath);
//		}
//	}

}
