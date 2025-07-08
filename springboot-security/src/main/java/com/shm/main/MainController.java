package com.shm.main;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
//@RequestMapping("/")
@Slf4j
public class MainController {

	//@GetMapping({ "", "/" })
	@GetMapping("")
	public String main() {
		log.info("=====> main");
		
		// 날짜
		LocalDate today = LocalDate.of(2025, 2, 10);
		log.info("=====> today : " + today.toString());
		log.info("=====> year : " + today.getYear());
		log.info("=====> dayyear : " + today.getDayOfMonth());
		// 시간
		LocalDateTime time = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		// String format = "yyyy-MM-dd HH:mm:ss";
		log.info("=====> now : " + time.toString());
		log.info("=====> day : " + time.toLocalDate());
		log.info("=====> time : " + time.toLocalTime());
		log.info("=====> time : " + time.format(formatter));
		
		Timestamp timestamp = Timestamp.valueOf(time);
		log.info("=====> timestamp : " + timestamp.toString());
		
		
		
		return "/main/main";
	}

}
