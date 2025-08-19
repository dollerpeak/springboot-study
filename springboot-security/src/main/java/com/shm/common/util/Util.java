package com.shm.common.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;

import com.shm.common.properties.Properties;

public class Util {

	// 마이크로타임을 format에 맞게 string으로 변경
	public static String getDateFormatString(long nTime, String nFormat) {
		String reval = "";
		String format = "yyyy-MM-dd HH:mm:ss";
		FastDateFormat fastdateformat = null;

		if (nFormat != null) {
			format = nFormat;
		}
		fastdateformat = FastDateFormat.getInstance(format);
		reval = fastdateformat.format(nTime);

		return reval;
	}
	
	// upload 디렉토리 체크해서 생성
	public static Path getFilePathCreate(Properties properties, FilePath filePath) throws Exception {
		Path reval = null;
		
		// root : upload
		Path rootPath = Paths.get(properties.getProperties("spring.servlet.multipart.location")).toAbsolutePath()
				.normalize();
		if (false == Files.exists(rootPath)) {
			Files.createDirectories(rootPath);
		}
		if(FilePath.PATH_ROOT == filePath) {
			reval = rootPath;
		}
		
		// thumbnail
		Path productThumbnailPath = Paths
				.get(properties.getProperties("spring.servlet.multipart.location")
						+ properties.getProperties("project-set.location-image.product-thumbnail"))
				.toAbsolutePath().normalize();
		if (false == Files.exists(productThumbnailPath)) {
			Files.createDirectories(productThumbnailPath);
		}
		if(FilePath.PATH_PRODUCT_THUMBNAIL == filePath) {
			reval = productThumbnailPath;
		}
		
		// detail
		Path productDetailPath = Paths
				.get(properties.getProperties("spring.servlet.multipart.location")
						+ properties.getProperties("project-set.location-image.product-detail"))
				.toAbsolutePath().normalize();		
		if (false == Files.exists(productDetailPath)) {
			Files.createDirectories(productDetailPath);
		}
		if(FilePath.PATH_PRODUCT_DETAIL == filePath) {
			reval = productDetailPath;
		}
		
		return reval;
	}

}
