
start ================================================================================
개발은 STS
view VSCODE를 사용해야 하나?
API 목록은 크롬 확장프로그램인 Talend API Tester 사용



================================================================================
springboot =====================================================================
	# 구조	
			Client
				DTO
			Controller/Restcontroller
				DTO
			Service
				Entity/Domain
			Repository/DAO
				Entity/Domain
			DB
		DTO : layer간 데이터 전송에 사용되는 class
		Entity/Domain : DB와 완전 매핑이 되는 class 혹은 @Entity로 테이블 스키마 역할
		DTO <-> Entity
			둘간에는 어떤식으로든 변활할 수 있는 방법이 있어야 함
		@Mapper : 이 방법으로는 사용하지 않음
			mybatis에서 인터페이스로만 생성해서 실제 쿼리가 있는 xml파일과 연동
	# IoC (Inversion of Control, 제어의 역전)
		new로 생성하는 것이 아니라 @Bean으로 객체를 생성해서 spring이 관리
			@Component, @ComponentScan을 통해 자동으로 @Bean 등록
			@Configuration, 내부에 @Component 존재
			@Controller, @RestController, @Service, @Repository, 내부에 @Component 존재
	# DI (Dependency Injection, 의존성 주입)
		IoC가 있기에 가능
		* 생성자 주입(Constructor Injection)
			public class A {     
				private B b;        
				@Autowired    
				public A(B b) {
					this.b = b;    
				}
			}
		* Field 주입(Field Injection)
			public class A {
				@Autowired
				private B b; 
			}
		* Setter 주입(Setter Injection)
			public class A {     
				private B b;
				
				@Autowired    
				public setB(B b) {
					this.b = b;    
				}
			}
		재귀호출 문제로 생성자 주입을 권장
			Lombok을 이용해서 생성자 주입을 간단히 할수 있음
				@RequiredArgsConstructor
				public class A {
					@Autowired     
					private final B b;
				}


================================================================================
주요 Annotation =====================================================================
	@Bean
		spring 컨테이너에 인스턴스 생성
	@Component
		@ComponentScan을 통해 자동으로 @Bean 등록
		* 클래스 레벨에서 사용 가능해서 개발자가 작성해서 제어가 가능한 클래스에 사용
			전체 프로젝트에 필요한 클래스를 자동으로 적용한다 생각하면 편할 듯
		생성시 마다 다른 객체로 인식
	@Configuration
		내부에 @Component 존재
		@Bean을 명시했을때 여러개 @Bean을 한번에 등록
			싱글톤으로 사용 가능
		* 직접 제어가 불가능한 라이브러리 등록에 사용
		* 전체 프로젝트에 필요한 커스텀 기능을 수동으로 적용한다 생각하면 편할 듯
			* 예를 들어 DB가 교체될수도 있을때
				인터페이스Repository 로 기능을 정의하고
				DB별로 Repository를 만들어서 인터페이스Repository를 상속받고
				@Configuration에서 인터페이스Repository를 @Bean으로 등록을 하면
					DB별로 Repository를 그때그때 변경해서 비지니스 코드는 수정을 안해도 됨
	@Controller
		내부에 @Component 존재
		client와 통신, 페이지를 리턴
	@RestController
		내부에 @Component 존재
		client와 통신, 데이터를 리턴(json)
	@Service
		내부에 @Component 존재
		실제 비지니스 로직이 들어감
	@Repository
		내부에 @Component 존재
		SqlSessionTemplate을 이용해서 mybatis xml파일과 연동해서 사용


================================================================================
application.properties/yml, 설정값 가져오기 ============================================
	[사용] 
		@Component로 @Bean에 등록
			@PropertySource, @Value 같이 사용
				@PropertySource 경로를 설정하고
				@Value 값을 가져오고
		단, 경로를 적용하더라도 여러파일에 동일하게 접근하게 되면 default로 접근하게 되니 접근하는 패스는 파일이 다르더라도 다른 패스로 명기하자
		아니면 @ConfigurationProperties 로 파일별로 클래스로 만들어서 사용		
	* @PropertySource, @Value 상하 관계가 아니다.
		@PropertySource 사용할 경우 Environment class 사용할 수 있어 용이하다
		@Value는 @PropertySource관계없이 @Bean에 등록되어 있는 경로만 있다면 무조건 값을 가져오고
			겹치는 경로를 가지는 설정파일이 있다면 디폴트값인 application 값을 가져오고 없다면 에러가 발생한다.
		특정 properties를 사용할려면 @PropertySource경로를 명시하고 @Value 키가 있는 값을 가져올 수 있다.
			없으면 물론 에러가 발생한다.
	@Controller, @RestController, @Service, @Repository 등.. 내부에 @Component 존재하기에
		@Value("${test.property.1}") 형식으로 바로 적용할 수 있음, 단 default로 로드된 application파일이 있을때
	1. Annotation 사용
		@Value("${test.property.one}")으로 변수에 값을 매핑
	2. Environment class 사용
		@PropertySource("classpath:test.properties")으로 properties파일의 경로 지정
			멀티, 여러개도 가능
		내부에 Environment 사용해서 매핑, @Component로 @Bean에 등록해서 사용
			@Autowired
			private Environment environment;
			environment.getProperty("test.property.2");
	주의 : 버전별로 차이가 많은 것 같음
		yml파일의 경우 list로 받을때 - 이런식으로 줄바꿈하면 안되고 properties파일처럼 , 로 데이터를 구분해서 사용
			- 이걸로 사용할려면 string[]로 받아야 함
		yaml파일의 경우 
			YamlPropertySourceFactory.class 구현하고
			이런식으로 사용해야 가능하다고 하는데
				@PropertySource(value = "classpath:foo.yml", factory = YamlPropertySourceFactory.class)
			그냥 되네? 업데이트 되었나?
	@ConfigurationProperties
		설정정보를 class에 바로 매핑할 수 있다.
			prefixtest.number: 789 값은 class의 number라는 변수에 매핑
		@ConfigurationProperties(prefix = "prefixtest") 사용하면
			디폴트 값인 application 기준으로 값을 가져오고
			다른 파일을 가져오고 싶다면 @PropertySource 사용
			* 마지막으로 @Bean에 등록해야 해야 하는데 @Component 적당할 것 같다.
				@Configuration은 하나만 사용하는게 좋지 않을까?
			그외 getter, setter를 위해 Lombok을 사용하고
				Lombok사용시 값이 없는 경우 에러가 발생하지 않고 초기값이 셋팅된다
		사용할 경우 spring-boot-configuration-processor 추가라하고 나온느데
			기능은 target/classes/META-INF/spring-configuration-metadata.json 경로에 
			@ConfigurationProperties 사용한 데이터를 json으로 파일형식으로 생성해 준다.

	기타
		server:
		  port: 8081 <= 실행 포트 설정이 가능  
		  servlet:
		    context-path: /abc <= URI의 부모값, 맨앞에 주소를 공통적으로 적용
		    ex) http://localhost:8081/http/get => http://localhost:8081/abc/http/get 


================================================================================
기타설정 ========================================================================
	Common Application Properties
		https://docs.spring.io/spring-boot/appendix/application-properties/index.html#appendix.application-properties.json
	포트설정
		디폴트는 8080
		성정방법
			server:
			  port: 8081
	URI 설정
		디폴트는 /
			그래서 이렇게 설정, http://localhost:8081/ 됨
		설정방법 
			server:  
			  servlet:
			    context-path: /abc <= URI의 부모값, 맨앞에 주소를 공통적으로 적용
			아니면 main()에 코드로 설정
				public static void main(String[] args) {
					System.setProperty("server.servlet.context-path", "/abc");
					SpringApplication.run(SpringbootStudyApplication.class, args);
				}
			ex) http://localhost:8081/http/get => http://localhost:8081/abc/http/get 
	UTF-8 설정
		server:  
		  servlet:
		    encoding:
		      charset: utf-8
		      enabled: true # 설정 encoding 활성화 여부
		      force: true # request, response 둘다 적용
		      #force-request: true
		      #force-response: true
	spring boot3에는 아래 설정이 전부 
		* application.yml에 모두 설정
		spring legacy
			web.xml
				WAS가 기동할대 최초로 실행
				내부에 root-context.xml, servlet-context.xml 로드 설정이 있음
			root-context.xml
				view와 관련되지 않은 객체를 @Bean 생성, 싱글톤으로 관리
				주로 데이터베이스, dao
			servlet-context.xml
				view쪽, 프론트엔드 설정들
				jsp, thymeleaf 이런 설정들		      


================================================================================
view 설정 ========================================================================
	JSP 설정
		JSP 컴파일러
			<dependency>
			    <groupId>org.apache.tomcat.embed</groupId>
			    <artifactId>tomcat-embed-jasper</artifactId>
			</dependency>
		JSTL (JSP Standard Tag Library), JSP개발 단순화
			<dependency>
			    <groupId>jakarta.servlet</groupId>
			    <artifactId>jakarta.servlet-api</artifactId>
			</dependency>
			<dependency>
			    <groupId>jakarta.servlet.jsp.jstl</groupId>
			    <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
			</dependency>
			<dependency>
			    <groupId>org.glassfish.web</groupId>
			    <artifactId>jakarta.servlet.jsp.jstl</artifactId>
			</dependency>
		view 설정
			전체경로
				src/main/webapp/WEB-INF/views/*.jsp
			설정
				spring:
				  mvc:
				    view:
				      prefix: /WEB-INF/views/
				      suffix: .jsp
	Thymeleaf 설정
		* maven에 적용되면 자동으로 설정 됨 
		자동설정
			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-thymeleaf</artifactId>
			</dependency>
		전체경로
			src/main/resource/templates
			다른 뷰와 구분을 위해 src/main/resource/templates/thymeleaf 사용이 가능
		설정
			spring:
			  thymeleaf:
			    prefix: classpath:/templates/
			    suffix: .html
			    cache: false # 테스트 시에만 사용, html파일 수정 후 저장하면 바로 적용가능하게 설정
			    #view-names: thymeleaf/* # 정확한 기능을 모르겠음


================================================================================
Controller =====================================================================
	@RequestMapping("/v1") : 반복되는 중간 뎁스 url에 사용
	@Controller
		기본적으로 view를 반환, 리턴되는 문자열의 페이지를 반환
		데이터를 반환할때는 function에 @ResponseBody를 붙이면 json데이터 반환
			일반적으로 데이터 반환시에는 ResponseEntity로 감싸서 반환
		둘다 반환이 필요할 경우 Model사용
			model.addAttribute()로 데이터 반환
			return으로 view반환
		리턴 종류
			일반적으로 view name
			data를 반환하고 싶은경우 
				function에 @ResponseBody를 붙이면 json데이터 반환
			둘다
				Model사용, model.addAttribute()로 데이터 반환, return값은 view
				ModelAndView, old한 방법으로 사용하지 말자
					ModelAndView mav = new ModelAndView("view name");
					modelAndView.addObject("key", "value");
					return mav;
			void
				현재 view name 리턴
			redirect
				controller에서 바로 URI전송(다른 controller)		
	@RestController = @Controller + @ResponseBody 
		기본적으로 json데이터 반환
			일반적으로 데이터 반환시에는 ResponseEntity로 감싸서 반환
		
		
================================================================================
ResponseEntity =====================================================================
	@ResponseEntity
		status값 종류
			1XX : 요청에 대한 정보, HttpStatus.CONTINUE
			2XX : 성공, HttpStatus.OK
			3XX : 리다이렉션, HttpStatus.MULTIPLE_CHOICES
			4XX : 클라이언트 오류, HttpStatus.BAD_REQUEST
			5XX : 서버오류, HttpStatus.INTERNAL_SERVER_ERROR
		리턴 방식
			상태값 :ResponseEntity<>(HttpStatus.OK);
		    데이터, 상태값 : ResponseEntity<>(response, HttpStatus.CREATED);
		    데이터, 헤더, 상태값 : ResponseEntity<>(response, new HttpHeaders(HttpHeaders.EMPTY), HttpStatus.CREATED);


================================================================================
Http Method =====================================================================
	주요 method
		GET : 조회
			@RequestBody 사용할 수 있으나 대다수의 서버가 GetMapping일 경우 Body부분을 읽지 않아 사용하지 않음
		POST : 등록(추가)
			@RequestBody를 주로 사용
		PUT : 대체(덮어쓰기, 없으면 등록)
		DELETE : 삭제
			GET처럼 @PathVariable, @RequestParam 사용 권장
		PATCH : 부분 변경
	기타 method
		HEAD : GET과 동일하나 Body를 제외하고 상태줄과 헤더만 반환
		OPTIONS : 통신 가능 옵션 확인, method/header/content-type (주로 CORS에 사용)
		CONNECT : 대상 자원으로 식별되는 서버에 대한 터널을 설정
		TRACE : 대상 경로를 따라 메세지 루프백 테스트 수행


================================================================================
Controller에서 Request Data를 받아오는 방식 =========================================
	@PathVariable, 변수 하나씩 받는 방식
		형식 : http://url/url/key/value
			URI는 / 끝내고 / 이걸 구분자로 값을 넣는다.
				ex) http://localhost:8081/codingrecipe/test/select/4
			controller에서 사용할때는 
				@GetMapping("/select/{seq}")
				값에 변수 이름을 매핑 시키고 @PathVariable long seq 형태
				변수이름과 실제 변수와 차이가 있을때는 @PathVariable("seq") long nSeq 형태				
	@RequestParam, 변수를 map으로 받을 수 있음
		형식 : http://url?key=value&abc=def
			URI는 ? 끝내고 key=value 형식, 여러개 일경우는 & 구분자
				ex) http://localhost:8081/codingrecipe/test/select4?seq=4&v1=123&v2=abc
			controller에서 사용할때는 값은 표현하지 않음
				@GetMapping("/select")
				값에 변수 이름을 매핑 시키고 @RequestParam long seq 형태
				변수이름과 실제 변수와 차이가 있을때는 @RequestParam("seq") long nSeq 형태
			기본 key=value라서 얼마나 길게 올지 모르니 그냥 Map<>으로 받을 수 있음
	@ModelAttribute, DTO로 받을수 있음, 생략가능
		형식 : http://url?key=value&abc=def
			@RequestParam와 동일형식으로 인자, map으로 받을 수 있지만 DTO로 바로 매핑도 가능
		조건
			변수이름과 완전 매핑이 되어야 함
			setter가 있어야 함
	@RequestBody, DTO로 받을수 있음, @PostMapping만 가능, map으로도 가능
		형식 : http://url
			요청데이터는 RequestBody에 넣어서 보낸다.
			데이터는 디폴트인 json사용
		controller에서 사용할때는 값은 표현하지 않음
				@PostMapping("/select")
				값을 받을때 @RequestBody BoardDto nDto
		json 외의 데이터를 보낼때, 주로 class가 아닌 다른 것들..
			Content-Type: application/x-www-form-urlencoded 이외 기타 등등이 있는데
			이런걸 보내면 데이터를 받지 못한다 그럴때는
			@RequestBody 를 생략하면 될수도 있음
		조건
			변수이름과 완전 매핑이 되어야 함
			setter가 없어도 됨
	HttpServletRequest
		client에서 server로 요청
			controller에서 HttpServletRequest request 형식으로 값을 받을 수 있다.
			위쪽에 있는 annotation으로 추상화된 방식으로 데이터를 받기 전에 사용 됐을 것으로 보인다.
		@GetMapping
			 @RequestParam 방식으로만 받을 수 있음
		@PostMapping
			body에 데이터를 넣어서 보낼경우 확인 가능
		특이점
			HttpServletRequest은 @Bean에 등록되어 있으므로 매번 controller에서 받지 않고
				@Autowired
				HttpServletRequest request;
				위 방법으로 매번 값을 받을 수 있음
			body값은 1회성 값으로 별도로 저정하지 않는다면 getInputStream() 읽으면 값이 사라짐
				또 @RequestBody와 값을 같이 받을 경우 @RequestBody내부에서 한번 소비해 버려서
				HttpServletRequest.body에는 값이 없어 짐
			요청이 끝날때까지 임시 저장소로 사용 가능
				setAttribute(String, Object)
				getAttribute(String)
	HttpServletResponse 
		server에서 client 응답
		특이점
			HttpServletRequest은 @Bean에 등록되어 있으므로 매번 controller에서 받지 않고
				@Autowired
				HttpServletRequest request;
				위 방법으로 매번 값을 받을 수 있음


================================================================================
Cookie, Session ===========================================================================
	client가 서버에 요청하면 응답으로 session이 cookie의 JSESSIONID에 보관
	Cookie
		브라우저가 종료되어도 쿠키 만료 시간이 있다면 클라이언트에 보관 됨
		Cookie, HttpServletResponse.addCookie()
		key-values로 String만 가능
	Session
		쿠키기반이지만 서버측에서 관리
		브라우저가 종료되면 만료시간이 있다고 해도 삭제 됨
		HttpSession, setAttribute() / getAttribute


================================================================================
Exception ===========================================================================
	@ExceptionHandler
		클래스에서 발생하는 exception에 대해서 특정 함수가 처리하게 적용
		@ExceptionHandler(NoSuchElementFoundException.class)
			이런식으로 특정 exception에 대해서만 처리도 가능
			패키지도 가능한것으로 알고 있음
	@ControllerAdvice, @RestControllerAdvice + @ExceptionHandler 형식으로 많이 사용
		controller에서 발생하는 모든 exception에 대해서 exception별로 @ExceptionHandler 지정해서 
		사용하는 방식

================================================================================
lombok =====================================================================
	[사용]
		특별한거 없으면 @Data
		@Data사용 후에는 모든 DI는 @RequiredArgsConstructor로 사용하고 final처리
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


================================================================================
logging =====================================================================
	[사용] 
		컬러가 포함되지 않는 xml파일을 사용하고
		설정값은 application에 logging설정해서 사용
	springboot는 기본적으로 spring-boot-starter-logging 즉 logback
	별도로 기존 logback을 제외하고 spring-boot-starter-log4j2로 사용하기도 함, 대세는??
    logback-spring.xml (디폴트로 지정된 파일 이름이 있음)으로 상세 설정이 가능하고
    	사용할 값은 application.yml파일에서 받아서 사용
    		cofing파일명도 변경이 가능함
    		max-history: 3 는 갯수가 아니라 일자를 나타냄, 3일유지
    		'[com.study]': warn 형식으로 적용하면 log level을 패키지별로 지정할 수 있음
    			mybatis 사용시에 debug 레벨을 주면 SQL 로그 확인이 가능
    	받을때는 <springProperty name="LOG_LEVEL" source="logging.level.root" /> 형식으로 사용
		color 별도 설정 가능
			<conversionRule conversionWord="clr" converterClass="org.springframework.boot.logging.logback.ColorConverter" />
			clr로 패턴을 감싸주는 형태로 사용, %clr(%-40.40logger{36}){cyan}
				등급은 색상 지정을 하지 않아도 자동 적용
				그런데 color적용하면 파일에 로그작성 시 관련 문자가 들어가서 별로임, 사용하지 않음		


================================================================================
mybatis =====================================================================
	[사용]
		xml파일에 일반적인 설정 사용하고
		설정값은 application에 mybatis설정해서 사용
		그외
			datasource는 application에 사용
		    hikarie는 application에 사용
		로그 출력방법은 logging에 작성
	application.yml에 
	config-path 지정 : config-location: classpath:mybatis/mybatis-config.xml
		config 설정이 들어가 있음
	config-path-mapper 지정 : mapper-locations: classpath:mybatis/mariadb/**/*.xml
		사용하는 mapper가 들어가 있음
	config
		mybatis설정값이 들어감 대표적으로
			<setting name="mapUnderScoreToCamelCase" value="true" />
				application.yml에 config-path를 지정하면 camecase적용이 안되기에 config파일에 지정해야 함
			<typeAlias type="com.study.codingrecipe.board.dto.BoardDto" alias="board" />
				namespace나 parameterType, resultType에 패키지명까지 기입해야 하기에 간단히 사용할려고 설정
				더 번거러워 질것 같으니 사용 안함
	mapper
		namespace : mapper 고유 ID, 주로 DB와 매핑되는 Entity를 패키지까지 전체경로로 사용
		id : 각 sql고유 ID
		parameterType : 입력값, 피키지포함해서 Entity까지 작성
			#{title} 이런식으로 입력값을 쿼리에 매핑
		resultType : 출력값, 패키지포함해서 Entity까지 작성 
		그외 Entity가 아닌 경우 자바타입으로 사용
			java.util.Hashmap
			java.lang.String
			java.lang.Integer
		SQL
			xml이라 크다작다 <>를 사용하지 못함
			대신 &lt; &gt; 이런식으로 사용하거나
			<![CDATA[내용]]> 이런식으로 사용하는데 이게 제일 편할듯 함
		[사용]적용_1
			DB와 매핑되는 Entity로만 데이터를 주고 받음
			mapper.xml에 
				namespace를 패키지.Entity로 사용하고
				@Repository에서 sqlSessionTemplate.insert(namespace.id, nParam)형식으로 사용
		적용_2, 근데 이건 함수명이 달라지면 어떻게 되나? 같은 entity에 select도 여러 종류가 있을텐데
			DB와 매핑되는 Entity로만 데이터를 주고 받음
			mapper.xml에
				namespace를 패키지.@Mapper인터페이스로 사용하고
				@Service에서 바로 @Mapper인터페이스 호출, testMapper.insert(nParam)
		SqlSessionTemplate 사용 가능 method
			<T> T selectOne(String statement, Object parameter)
			<E> List<E> selectList(String statement, Object parameter)
			<T> Cursor<T> selectCursor(String statement, Object parameter)
			<K,V> Map<K,V> selectMap(String statement, Object parameter, String mapKey)
			int insert(String statement, Object parameter)
			int update(String statement, Object parameter)
			int delete(String statement, Object parameter)
		log
			[사용]종속성이 있지만 가장 괜찮은 방법
				org.bgee.log4jdbc-log4j2 추가
				log4jdbc.log4j2.properties 추가, 파일명 변경 안됨
				spring.datasource:
				    driver-class-name, url 변경적용
				logback_config.xml에 logger추가
					logging의 level.root와는 별개로 적용 됨
					<logger name="jdbc.audit" level="OFF"/>, 로그량이 많음, db분석용
					<logger name="jdbc.resultset" level="OFF"/>, 로그량이 많음, db분석용
					<logger name="jdbc.connection" level="OFF"/>, 로그량이 많음, db분석용
					<logger name="jdbc.sqlonly" level="OFF"/>, sql만 출력
					<logger name="jdbc.sqltiming" level="INFO"/>, sql, execute time까지 출력 
				  	<logger name="jdbc.resultsettable" level="INFO"/>, 결과값을 테이블 형태로 출력
			동일한 로그 가능, logback-config.xml 사용하는게 가장 좋음
				mybatis-config.xml 파일에 작성하면 stdout 콘솔로그 확인 가능, 커스텀은 불가능
					<setting name="logImpl" value="STDOUT_LOGGING"/>
				application.yml logging.level에 '[com.study]' 특정패키지로 적용하면 가능
	    			mybatis 사용시에 debug 레벨을 주면 SQL 로그 확인이 가능
	    		logback-config.xml 에 아래 작성하면 동일하게 확인 가능
	    			<logger name="com.study" level="DEBUG" appender-ref="console" />
			logback을 사용할려면 아래처럼 하면 가능하나 mybatis를 @Mapper interface사용할때만 가능
				<setting name="logImpl" value="SLF4J"/>
				logback 설정파일에 아래처럼 @Mapper interface 패키지를 작성해 줘야 함
					<logger name="com.baeldung.mybatis.mapper.AddressMapper" level="TRACE"/>
					전체 mapper, <logger name="com.baeldung.mybatis.mapper" level="TRACE"/>


================================================================================
HikariCP =====================================================================
	[사용] spring.datasource.hikari에 필요한 만큼만 설정
		maximum-pool-size 운영상의 이유
		connection-timeout=30000 운영상의 이유로 비율에 맞게 적용
		idle-timeout=600000
	springboot에 자동구성되어 있음
	SQL사용 시 아래 로그 확인할 수 있음 
		com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
		com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection net.sf.log4jdbc.sql.jdbcapi.ConnectionSpy@6a899d10
		com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
	application.yaml spring.datasource.hikari에 별도 설정을 할 수 있음, 아래는 default값
		spring.datasource.hikari.pool-name: auto naming
		spring.datasource.hikari.maximum-pool-size=10
		spring.datasource.hikari.minimum-idle=maximum-pool-size 동일
		spring.datasource.hikari.connection-timeout=30000
		spring.datasource.hikari.idle-timeout=600000
		spring.datasource.hikari.auto-commit=true		
		spring.datasource.hikari.keepalivetime=0 (비활성화)
		spring.datasource.hikari.max-lifetime=1800000
		spring.datasource.hikari.connection-init-sql=없음, ex) select 1 from dual
			최초 sql시 pool 갯수만큼 실행 됨, 사용하지 않음 권장
		spring.datasource.hikari.connection-test-query=없음, ex) select 1 from dual
			sql 실행 시 마다 사전에 실행되는 sql, 사용하지 않음 권장


end ================================================================================









