package com.shm.seller.product;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.shm.common.config.FilePath;
import com.shm.common.config.Properties;
import com.shm.common.config.Util;
import com.shm.common.exception.CustomExceptionData;
import com.shm.common.resultdata.ResultData;
import com.shm.product.ProductDto;
import com.shm.product.ProductEntity;
import com.shm.product.ProductRepository;
import com.shm.product.detail.ProductDetailDto;
import com.shm.product.detail.ProductDetailEntity;
import com.shm.product.detail.ProductDetailRepository;
import com.shm.user.UserDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class SellerProductService {
	private final ProductRepository productRepository;
	private final ProductDetailRepository productDetailRepository;
	private final Properties properties;

	@Autowired
	public SellerProductService(ProductRepository productRepository, ProductDetailRepository productDetailRepository,
			Properties properties) {
		this.productRepository = productRepository;
		this.productDetailRepository = productDetailRepository;
		this.properties = properties;
	}

	public ResultData insert(UserDto userDto, ProductDto productDto, MultipartFile thumbnailImage,
			MultipartFile[] detailImages) {
		ResultData resultData = new ResultData(HttpStatus.OK.value(), "[상품등록]", null, null, null);
		Map<Object, Object> resultMap = new HashMap<>();

		long nowTime = System.currentTimeMillis();
		int count = 0;
		Path thumbnailPath;
		String thumbnailFileName;
		String thumbnailUrl;
		Path detailPath;
		String detailFileName;
		String detailUrl;

		ProductEntity productEntity;
		ProductDetailDto productDetailDto;
		ProductDetailEntity productDetailEntity;

		try {
			// 썸네일
			thumbnailPath = Util.getFileAbsolutePathCreate(properties, FilePath.PATH_PRODUCT_THUMBNAIL);
			if (thumbnailPath != null) {
				if (thumbnailImage != null && false == thumbnailImage.isEmpty()) {
					// 파일 저장
					thumbnailFileName = Util.getDateFormatString(nowTime, "yyyyMMddHHmmssSSS") + "_"
							+ thumbnailImage.getOriginalFilename();
					thumbnailImage.transferTo(thumbnailPath.resolve(thumbnailFileName).toFile());
					thumbnailUrl = Util.getFilePropertiesPath(properties, thumbnailFileName,
							FilePath.PATH_PRODUCT_THUMBNAIL);

					// 데이터 저장
					productDto.setUserEmail(userDto.getEmail());
					productDto.setThumbnailUrl(thumbnailUrl);
					productDto.setFrstRegUserId(userDto.getEmail());
					productDto.setLastChgUserId(userDto.getEmail());					
					
					productEntity = productDto.toEntity();
					productRepository.insert(productEntity);
					log.info("productEntity = " + productEntity.toString());
					
					// 디테일 이미지
					detailPath = Util.getFileAbsolutePathCreate(properties, FilePath.PATH_PRODUCT_DETAIL);
					if (detailPath != null) {
						count = 0;
						if (detailImages != null && detailImages.length > 0) {
							for (MultipartFile file : detailImages) {
								if (file != null && false == file.isEmpty()) {
									// 디테일 파일 저장
									detailFileName = Util.getDateFormatString(nowTime, "yyyyMMddHHmmssSSS") + "_"
											+ Integer.toString(count) + "_" + file.getOriginalFilename();
									file.transferTo(detailPath.resolve(detailFileName).toFile());
									detailUrl = Util.getFilePropertiesPath(properties, detailFileName,
											FilePath.PATH_PRODUCT_DETAIL);									
									
									// 데이터 저장
									productDetailDto = new ProductDetailDto();
									productDetailDto.setProductId(productEntity.getId());
									productDetailDto.setSortOrder(count);
									productDetailDto.setImageUrl(detailUrl);
									productDetailDto.setFrstRegUserId(userDto.getEmail());
									productDetailDto.setLastChgUserId(userDto.getEmail());
									
									productDetailEntity = productDetailDto.toEntity();
									productDetailRepository.insert(productDetailEntity);									
									
									count += 1;
								}
							}
						}
						
						// 상세이미지가 없는 경우
						if (count <= 0) {							
							resultData.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
							resultData.setMessage("상품등록에 실패했습니다.");
							resultData.setLog("상세 이미지를 업로드하세요.");

							throw new CustomExceptionData(resultData);
						} else {							
							// 상품등록 성공
						}
					} else {
						resultData.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
						resultData.setMessage("상품등록에 실패했습니다.");
						resultData.setLog("상세 이미지 디렉토리가 존재하지 않습니다.");

						throw new CustomExceptionData(resultData);
					}
				} else {
					resultData.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
					resultData.setMessage("상품등록에 실패했습니다.");
					resultData.setLog("썸네일 이미지를 업로드하세요.");

					throw new CustomExceptionData(resultData);
				}
			} else {
				resultData.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
				resultData.setMessage("상품등록에 실패했습니다.");
				resultData.setLog("썸네일 디렉토리가 존재하지 않습니다.");

				throw new CustomExceptionData(resultData);
			}


//		            /*
//					// 디테일 이미지, 루트 확인
//					targetPath = Util.getFilePathCreate(properties, FilePath.PATH_PRODUCT_DETAIL);
//					if (targetPath != null) {
//						// 디테일 파일 저장
//						count = 0;
//						if (detailImages != null && detailImages.length > 0) {
//							for (MultipartFile file : detailImages) {
//								if (file != null && false == file.isEmpty()) {
//									fileName = Util.getDateFormatString(nowTime, "yyyyMMddHHmmssSSS") + "_" + file.getOriginalFilename();
//									file.transferTo(targetPath.resolve(fileName).toFile());
//									count += 1;
//								}
//							}
//						}
//
//						// 상세이미지가 없는 경우
//						if (count <= 0) {
//							resultData.setCode(HttpStatus.BAD_REQUEST.value());
//							resultData.setMessage("상세 이미지를 업로드하세요.");
//
//							resultMap.put(ResultData.TYPE_URL, "/seller/seller");
//							resultData.setData(resultMap);
//						} else {
//							// 데이터 저장
//							log.info("userDto : " + userDto.toString());
//							log.info("productDto : " + productDto.toString());
//							
//							productEntity = productDto.toEntity();
//							productEntity.setUserId(userDto.getId());
//							
//							productRepository.insert(productEntity);
//							log.info("productEntity : " + productEntity.toString());
//							
//							for (MultipartFile file : detailImages) {
//								
//							}
//							
//							상품, 상품상세 저장하자
//							
//							
//							[insert:82] userDto : UserDto(id=1, email=111@a.com, name=111, password=$2a$10$rhbgPDAgVTkExcROxcSEHeh48O/7oCUzerbJzbIQYpyddfdv70zo2, role=USER, frstRegDate=2025-08-18T17:13:32, frstRegUserId=SYSTEM, lastChgDate=2025-08-18T17:13:32, lastChgUserId=SYSTEM)
//							[insert:83] productDto : ProductDto(id=0, userId=0, categoryId=1, sold=true, name=11, price=11, viewCount=0, sellCount=0, desc=11, thumbnailUrl=null, frstRegDate=null, frstRegUserId=null, lastChgDate=null, lastChgUserId=null)
//							[insert:114] resultData = ResultData(code=200, title=[상품등록], message=null, log=null, data=null)
//						}
//					} else {
//						resultData.setCode(HttpStatus.BAD_REQUEST.value());
//						resultData.setMessage("상세 이미지 디렉토리가 존재하지 않습니다.");
//
//						resultMap.put(ResultData.TYPE_URL, "/seller/seller");
//						resultData.setData(resultMap);
//					}
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
