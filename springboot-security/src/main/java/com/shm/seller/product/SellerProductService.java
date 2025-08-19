package com.shm.seller.product;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.shm.common.exception.CustomExceptionData;
import com.shm.common.properties.Properties;
import com.shm.common.resultdata.ResultData;
import com.shm.common.util.FilePath;
import com.shm.common.util.Util;
import com.shm.product.ProductDto;
import com.shm.product.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class SellerProductService {
	private final ProductRepository productRepository;
	private final Properties properties;

	@Autowired
	public SellerProductService(ProductRepository productRepository, Properties properties) {
		this.productRepository = productRepository;
		this.properties = properties;
	}

	public ResultData insert(ProductDto productDto, MultipartFile thumbnailImage, MultipartFile[] detailImages) {
		ResultData resultData = new ResultData(HttpStatus.OK.value(), "[상품등록]", null, null, null);
		Map<Object, Object> resultMap = new HashMap<>();
		
		Path targetPath;
		String fileName;
		
		try {
			targetPath = Util.getFilePathCreate(properties, FilePath.PATH_PRODUCT_THUMBNAIL);
			if(targetPath != null) {
				if (thumbnailImage != null && false == thumbnailImage.isEmpty()) {
					// 썸네일 파일 저장
		            fileName = Util.getDateFormatString(System.currentTimeMillis(), "yyyyMMddHHmmssSSS") + "_" + thumbnailImage.getOriginalFilename();
		            thumbnailImage.transferTo(targetPath.resolve(fileName).toFile());
		             
		            // 디테일 파일 저장
		            
		            // 상품정보 저장
		            
		        } else {
					resultData.setCode(HttpStatus.BAD_REQUEST.value());
					resultData.setMessage("썸네일 이미지를 업로드하세요.");
					
					resultMap.put(ResultData.TYPE_URL, "/seller/seller");
					resultData.setData(resultMap);
				}	
			} else {
				resultData.setCode(HttpStatus.BAD_REQUEST.value());
				resultData.setMessage("썸네일 디렉토리가 존재하지 않습니다.");
				
				resultMap.put(ResultData.TYPE_URL, "/seller/seller");
				resultData.setData(resultMap);
			}
		} catch (Exception e) {
			log.error("e = " + e.toString());
			resultData.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			resultData.setMessage("상품등록에 실패했습니다.");
			resultData.setLog(e.toString());
			
			throw new CustomExceptionData(resultData);
		}
		log.info("resultData = " + resultData.toString());		
		
		return resultData;
	}

}
