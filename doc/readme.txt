
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


mybatis =====================================================================
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
		resultType : 출력값, 피키지포함해서 Entity까지 작성 
		그외 Entity가 아닌 경우 자바타입으로 사용
			java.util.Hashmap
			java.lang.String
			java.lang.Integer
		SQL
			xml이라 크다작다 <>를 사용하지 못함
			대신 &lt; &gt; 이런식으로 사용하거나
			<![CDATA[내용]]> 이런식으로 사용하는데 이게 제일 편할듯 함
		사용 1
			DB와 매핑되는 Entity로만 데이터를 주고 받음
			mapper.xml에 
				namespace를 패키지.Entity로 사용하고
				@Repository에서 sqlSessionTemplate.insert(namespace.id, nParam)형식으로 사용
		사용 2
			DB와 매핑되는 Entity로만 데이터를 주고 받음
			mapper.xml에
				namespace를 패키지.@Mapper인터페이스로 사용하고
				@Service에서 바로 @Mapper인터페이스 호출, testMapper.insert(nParam)
		익숙한 사용2가 더 적합
		SqlSessionTemplate 사용 가능 method
			<T> T selectOne(String statement, Object parameter)
			<E> List<E> selectList(String statement, Object parameter)
			<T> Cursor<T> selectCursor(String statement, Object parameter)
			<K,V> Map<K,V> selectMap(String statement, Object parameter, String mapKey)
			int insert(String statement, Object parameter)
			int update(String statement, Object parameter)
			int delete(String statement, Object parameter)
		log
			mybatis-config.xml 파일에 작성하면 stdout 콘솔로그 확인 가능, 변경은 불가능
				<setting name="logImpl" value="STDOUT_LOGGING"/>
			logback을 사용할려면 아래처럼 하면 가능하나 mybatis를 @Mapper interface사용할때만 가능
				<setting name="logImpl" value="SLF4J"/>
				logback 설정파일에 아래처럼 @Mapper interface 패키지를 작성해 줘야 함
					<logger name="com.baeldung.mybatis.mapper.AddressMapper" level="TRACE"/>
					전체 mapper, <logger name="com.baeldung.mybatis.mapper" level="TRACE"/>




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





