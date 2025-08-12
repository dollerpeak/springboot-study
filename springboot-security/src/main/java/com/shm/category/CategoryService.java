package com.shm.category;

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

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class CategoryService {
	private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public ResultData select() {
		ResultData resultData = new ResultData(HttpStatus.OK.value(), "[카테고리 조회]", null, null, null);
		Map<Object, Object> resultMap = new HashMap<>();
		
		List<CategoryEntity> categoryEntityList = new ArrayList<>();
		
		try {
			categoryEntityList = categoryRepository.select();
			
			resultData.setMessage("카테고리 조회를 성공했습니다.");

			resultMap.put(ResultData.TYPE_LIST, categoryEntityList);
			resultData.setData(resultMap);
		} catch (Exception e) {
			log.error("e = " + e.toString());			
			resultData.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			resultData.setMessage("카테고리 조회를 실패했습니다.");
			resultData.setLog(e.toString());
			
			throw new CustomExceptionData(resultData);
		}
		log.info("resultData = " + resultData.toString());

		return resultData;
	}

}
