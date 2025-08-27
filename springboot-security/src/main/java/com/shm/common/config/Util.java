package com.shm.common.config;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.beans.factory.annotation.Autowired;

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

	// 설정에 적용된 디렉토리 생성 및 절대 경로 리턴
	public static Path getFileAbsolutePathCreate(Properties properties, FilePath filePath) throws Exception {
		Path reval = null;
		// 파일의 저장위치 ../형식의 상대경로 포함
		String uploadPath = "spring.servlet.multipart.location";

		// root : upload
		Path rootPath = Paths.get(properties.getProperties(uploadPath)).toAbsolutePath().normalize();
		if (false == Files.exists(rootPath)) {
			Files.createDirectories(rootPath);
		}
		if (FilePath.PATH_ROOT == filePath) {
			reval = rootPath;
		}

		// thumbnail - image
		Path productThumbnailPath = Paths
				.get(properties.getProperties(uploadPath)
						+ properties.getProperties("project-set.upload.image.product-thumbnail"))
				.toAbsolutePath().normalize();
		if (false == Files.exists(productThumbnailPath)) {
			Files.createDirectories(productThumbnailPath);
		}
		if (FilePath.PATH_PRODUCT_THUMBNAIL == filePath) {
			reval = productThumbnailPath;
		}

		// detail - image
		Path productDetailPath = Paths
				.get(properties.getProperties(uploadPath)
						+ properties.getProperties("project-set.upload.image.product-detail"))
				.toAbsolutePath().normalize();
		if (false == Files.exists(productDetailPath)) {
			Files.createDirectories(productDetailPath);
		}
		if (FilePath.PATH_PRODUCT_DETAIL == filePath) {
			reval = productDetailPath;
		}

		return reval;
	}

	// 설정에 적용된 경로
	public static String getFilePropertiesPath(Properties properties, String fileName, FilePath filePath) {
		String reval = null;
		// DB에 저장되는 /형식의 경로
		String uploadPath = "project-set.upload.root";

		// root : upload
		Path rootPath = Paths.get(properties.getProperties(uploadPath) + "/" + fileName).normalize();
		if (FilePath.PATH_ROOT == filePath) {
			reval = rootPath.toString();
		}

		// thumbnail
		Path productThumbnailPath = Paths
				.get(properties.getProperties(uploadPath)
						+ properties.getProperties("project-set.upload.image.product-thumbnail") + "/" + fileName)
				.normalize();
		if (FilePath.PATH_PRODUCT_THUMBNAIL == filePath) {
			reval = productThumbnailPath.toString();
		}

		// detail
		Path productDetailPath = Paths
				.get(properties.getProperties(uploadPath)
						+ properties.getProperties("project-set.upload.image.product-detail") + "/" + fileName)
				.normalize();
		if (FilePath.PATH_PRODUCT_DETAIL == filePath) {
			reval = productDetailPath.toString();
		}

		return reval;
	}

}
