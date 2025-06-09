package com.study.aloha.blog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.study.aloha.blog.attach.AttachDto;
import com.study.aloha.blog.attach.AttachService;
import com.study.common.DateFormat;
import com.study.common.ResultData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class BlogService {
	@Autowired
	BlogRepository blogRepository;
	@Autowired
	AttachService attachService;

	// repository로 mapper연결할때
	//public List<BlogDto> select() throws Exception {
	public List<BlogDto> select() {
		log.info("select");
		
		List<BlogDto> listDto = new ArrayList<>();
		
		try {
			// <<< 에러 만들기
			//String str = "abc";
			//int a = Integer.parseInt(str);
			// >>> 에러 만들기
			
			List<BlogEntity> listEntity = blogRepository.select();

			for (BlogEntity entity : listEntity) {
				//log.info("service - writer = " + entity.getWriter());
				listDto.add(entity.toDto());
			}	
		} catch (Exception e) {
			log.error("에러 만들기");
			//log.error("repository 에러 만들기");
			//log.error("service 에러 만들기");
		}		

		return listDto;
	}
	
	public ResultData exception_select() {
		log.info("select");
		
		ResultData resultData = new ResultData(HttpStatus.OK.value(), null, null);
		List<BlogDto> listDto = new ArrayList<>();
		
		try {
			// <<< 에러 만들기
			String str = "abc";
			int a = Integer.parseInt(str);
			// >>> 에러 만들기
			
			List<BlogEntity> listEntity = blogRepository.select();

			for (BlogEntity entity : listEntity) {
				//log.info("service - writer = " + entity.getWriter());
				listDto.add(entity.toDto());
			}	
		} catch (Exception e) {
			log.error("에러 만들기, e = " + e.getMessage());
			//log.error("repository 에러 만들기");
			//log.error("service 에러 만들기");
			
			resultData.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			resultData.setMessage("서비스에서 에러발생");
			resultData.setData(null);
		}		

		return resultData;
	}
	
//	@Autowired
//	BlogMapper blogMapper;
//	// interface mapper연결할때
//	public List<BlogDto> select_mapper() throws Exception {
//		log.info("select_mapper");
//		List<BlogDto> listDto = new ArrayList<>();
//		List<BlogEntity> listEntity = blogMapper.select();
//
//		log.info("service - select_mapper = " + listEntity.size());
//		for (BlogEntity entity : listEntity) {
//			//log.info("service - writer = " + entity.getWriter());
//			listDto.add(entity.toDto());
//		}
//
//		return listDto;
//	}

	public BlogDto detail(long id) throws Exception {
		log.info("detail");

		BlogEntity blogEntity = blogRepository.detail(id);
		BlogDto blogDto = blogEntity.toDto();

		List<AttachDto> attachDtoList = attachService.selectBlog(blogDto.getId());
		
		blogDto.setAttachList(attachDtoList);

		return blogDto;
	}
	
	public long insert(BlogDto blogDto) throws Exception {
		log.info("insert");
		
		BlogEntity blogEntity = blogDto.toEntity();
		int count = 0;
		
		if(blogEntity.getFrstRegUserId() == null || blogEntity.getFrstRegUserId().length() <= 0) {
			blogEntity.setFrstRegUserId("SYSTEM");
		}
		if(blogEntity.getLastChgUserId() == null || blogEntity.getLastChgUserId().length() <= 0) {
			blogEntity.setLastChgUserId("SYSTEM");
		}
		
		log.info("blogDto.getFileList().size() = " + blogDto.getMultipartFileList().size());
		count = 0;
		for (MultipartFile multipartFile : blogDto.getMultipartFileList()) {
			if(multipartFile.isEmpty() == false) {
				count += 1;
			}
		}
		blogEntity.setAttachCount(count);		
		
		blogRepository.insert(blogEntity);
		log.info("blogEntity = " + blogEntity.toString());
		
		for (MultipartFile multipartFile : blogDto.getMultipartFileList()) {
			if (multipartFile.isEmpty() == false) {
				attachService.insert(blogEntity.getId(), multipartFile);
			}
		}		

		return blogEntity.getId();
	}
	
//	public int update(BlogDto blogDto) throws Exception {
//		log.info("update");
//		BlogEntity blogEntity = blogDto.toEntity();
//		if(blogEntity.getFrstRegDate() == null || blogEntity.getFrstRegDate().length() <= 0) {
//			blogEntity.setFrstRegDate(DateFormat.getFormatString(System.currentTimeMillis(), null));
//		}
//		if(blogEntity.getLastChgDate() == null || blogEntity.getLastChgDate().length() <= 0) {
//			blogEntity.setLastChgDate(DateFormat.getFormatString(System.currentTimeMillis(), null));
//		}
//		int result = blogRepository.update(blogEntity);
//
//		return result;
//	}

//	public int delete(long id) throws Exception {		
//		log.info("delete");
//		int result = blogRepository.delete(id);
//
//		return result;
//	}

}
