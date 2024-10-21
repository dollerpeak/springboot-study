
spring =====================================================================
	구조
		client(browser)
		controller
		service			
		repository(dao)
	dto
		layer간 데이터 전송용 class
		controller, service간 사용
	entity
		db테이블과 완전 매핑되는 class
		service, repository간 사용
	dto <-> entity
		어디에서 변활할 것인가?
		service에서 하는게 유리할 것 같음
		@builder로 변환함수를 사용하거나 이외 다른 방법도 있을까?



Controller =====================================================================
	@Controller
	@RequestMapping("/v1") : 반복되는 url에 사용
	@ResponseBody
		사용하면 데이터가 반환됨
		사용하지 않으면 페이지가 반환됨
	@RestController = @Controller + @ResponseBody 
		데이터(JSON/XML) 반환
		리턴되는 값이 ModelAndView면 페이지도 표시가 됨
			리턴되는 값이 페이지만 아니라면 데이터로 표기되는 것 같음
			Model의 경우 리턴되는 값이 페이지를 의미하는 문자열이 리턴되지만 데이터로 인식됨



lombok =====================================================================
	@Getter : get 자동생성
	@Setter : set 자동생성
	@ToString : toString() 자동생성
		@ToString(exclude = "password") : 특정 필드는 출력을 안함
	생성자
		@NoArgsConstructor : 파라메터가 없는 기본 생성자
		@AllArgsConstructor : 모든 파라메터가 있는 생성자
		@RequiredArgsConstructor : final, NonNull인 값만 파라메터로 받는 생성자
			spring의 생성자 주입으로 주로 사용
			아니면 @Autowired 로 사용해야 함			
	@EqualsAndHashCode
		Equals : 동등성, 객체(주소)가 동일한지 비교
		HashCode : 동일성, 값이 동일한지 비교 
	@Data : 아래 내용 모두 적용
		@Getter
		@Setter
		@ToString
		@RequiredArgsConstructor
		@EqualsAndHashCode
	@RequiredArgsConstructor
		spring 의존성 주입시 생성자, 필드, set 이정도로 3개 있는데 안정성을 위해 생성자 주입을 권고
			왜냐하면 생성자는 한번만 호출되지만 다른건 재귀호출이 일어날 수도 있음
		그래서 생성자를 생략할 수 있는 @RequiredArgsConstructor 을 자주 사용 함 
	@Builder
		클래스를 생성할 수 있는데 예외 사항이 좀 있는것 같아 좀 더 확인해 사용 가능


logging =====================================================================
	springboot는 기본적으로 spring-boot-starter-logging 즉 logback
	별도로 기존 logback을 제외하고 spring-boot-starter-log4j2로 사용하기도 함, 대세는??
	logback의 자세한 설정은 logback-spring.xml에서 수행하고 (파일명이 몇개정도로 고정되어 있음)
	logback-spring.xml에서 사용할 값은 application.yml에서 설정을 해준다.
		level을 지정할때는 패키지별로 설정이 가능
			'[com.study]': warn
	color 별도 설정 가능		


mybatis =====================================================================
	mybatis설정 config.xml
		config-location: classpath:mybatis/mybatis-config.xml : 설정값을을 별도의 xml에 적용
		대표적으로 <setting name="mapUnderScoreToCamelCase" value="true" />
		근데 이건 application.yml에서도 지정해 줄수 있음
			configuration.map-underscore-to-camel-case: true
	실제 쿼리가 들어가 있는 mapper xml
		mapper-locations: classpath:mybatis/mariadb/**/*.xml : 실제 경로에 맞게 작성
			/resources 디렉토리 아래에 생성해서 관리
		mapper는 다수가 존재하고 namespace는 꼭 작성되어야 한다.
			namespace는 꼭 작성되어야 하는 유니크한 값이여야 한다.
			주로 VO, DAO의 패키지 명으로 정한다. 
			패키지명을 alias로 mybatis-config.xml 간단하게 매핑해서 사용할 수 있지만 더 번거러울 것 같아서 사용 안함
	필수 사항
		id : 고유 ID
		parameterType : 입력값  
			#{title} 이런식으로 입력값을 쿼리에 매핑
		resultType : 출력값
	<![CDATA[내용]]> : 크다작다(><)같은 문자는 html과 혼돈이 있어 cdata사용
			













======================================================================================

DispatcherServlet
	클라이언트에서 http프로토콜로 들어오는 모든 요청을 제일 앞에서 중앙집중식으로 처리해 주는 front controller
		오래전에는 controller 마다 servlet 설정이 필요했는데 spring이 DispatcherServlet 정의
		spring도 예전에는 DispatcherServlet 설정이 필요했지만
		지금은 특별한 경우가 아니라면 설정하는 경우가 없는 것 같음
	
ViewResolver
	controller에서 어노테이션에 따라 뷰인지 데이터인지를 구분하고 뷰일때 적절한 페이지를 반환
		예전에는 이것도 설정이 있었다는데 지금은 특별한 경우가 아니라면 설정하는 경우가 없는 것 같음
	
----------------------------------------------------------------------------------------

@RequestMapping
	controller에서 사용되며 url과 method 매핑에 사용 
	ex) @RequestMapping(value = "/main", method = RequestMethod.GET)
	현재는
		method매핑에 대해서 개별적인 어노테이션이 있고 controller에 중복되는 url을 처리해주는데 사용되고 있음
			@GetMapping("/data"), @PostMapping("/data"), @PutMapping("/data"), @DeleteMapping("/data")
	자주 사용되는 method 종류 
		GET : read
		POST : create
		PUT : update
		PATCH : 일부 update
		DELETE : delete
	
@Controller
	뷰(HTML 페이지) 반환
	데이터를 반환하고 싶을때 @RestController 처럼
		메소드에 @ResponseBody 추가
	뷰와 데이터를 같이 반환하고 싶을때
		Model, ModelAndView
		더 쎄련된 방법은? 더 구식인 방법은?
	
@RestController = @Controller + @ResponseBody 
	데이터(JSON/XML) 반환
	리턴되는 값이 ModelAndView면 페이지도 표시가 됨
		리턴되는 값이 페이지만 아니라면 데이터로 표기되는 것 같음
		Model의 경우 리턴되는 값이 페이지를 의미하는 문자열이 리턴되지만 데이터로 인식됨





