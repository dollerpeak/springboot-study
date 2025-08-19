package com.shm.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shm.common.exception.CustomExceptionData;
import com.shm.common.resultdata.ResultData;
import com.shm.user.UserEntity;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class ProductService {
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public ResultData insert(ProductDto productDto) {
		ResultData resultData = new ResultData(HttpStatus.OK.value(), "[상품등록]", null, null, null);
		Map<Object, Object> resultMap = new HashMap<>();
		
		ProductEntity productEntity;
		
		try {			
			productEntity = productDto.toEntity();
			productRepository.insert(productEntity);
			
//			여기서 디테일도 저장해야 함
//			그럼 dto는 detail을 가지게 되나?
			
			resultData.setMessage("상품등록을 성공했습니다.");
			
			resultMap.put(ResultData.TYPE_OBJECT, productEntity);
			resultMap.put(ResultData.TYPE_URL, "/seller/product");
			resultData.setData(resultMap);			
		} catch (Exception e) {
			log.error("e = " + e.toString());			
			resultData.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			resultData.setMessage("상품등록을 실패했습니다.");
			resultData.setLog(e.toString());
			
			throw new CustomExceptionData(resultData);
		}
		log.info("resultData = " + resultData.toString());

		return resultData;
	}

}
