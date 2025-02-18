package com.study.around.data.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@NoArgsConstructor : 파라메터가 없는 생성자
//@AllArgsConstructor : 모든 파라메터가 있는 생성자
//@RequiredArgsConstructor : final, notnull 값만 갖는 생성자
//@EqualsAndHashCode : equals 동등성, hashcode 동일성 
//@Data : 위에 있는 전체다 적용
public class SwaggerSampleDTO {
	@Schema(description = "swagger dto 멤버설명")
	private String id;
	@Schema(description = "swagger dto 멤버설명")
	private String name;
	@Schema(description = "swagger dto 멤버설명")
	private int age;
}
