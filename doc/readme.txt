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
	# 주요 Annotation
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
	
	# application.properties/yml, 설정값 가져오기
		* @PropertySource, @Value 상하 관계가 아니다.
			@PropertySource 사용할 경우 Environment class 사용할 수 있어 용이하다
			@Value는 @PropertySource관계없이 @Bean에 등록되어 있는 경로만 있다면 무조건 값을 가져오고
				겹치는 경로를 가지는 설정파일이 있다면 디폴트값인 application 값을 가져오고 없다면 에러가 발생한다.
			특정 properties를 사용할려면 @PropertySource경로를 명시하고 @Value 키가 있는 값을 가져올 수 있다.
				없으면 물론 에러가 발생한다.
		@Controller, @RestController, @Service, @Repository 등.. 내부에 @Component 존재하기에
			@Value("${test.property.1}") 형식으로 바로 적용할 수 있음		
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
				@Autowired 생략 가능    
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


================================================================================
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


================================================================================
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
				그런데 color적용하면 파일에 로그작성 시 관련 문자가 들어가서 별로임, 사용하지 않음		


================================================================================
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
		[사용]적용_1
			DB와 매핑되는 Entity로만 데이터를 주고 받음
			mapper.xml에 
				namespace를 패키지.Entity로 사용하고
				@Repository에서 sqlSessionTemplate.insert(namespace.id, nParam)형식으로 사용
		적용_2
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
	[사용] spring.datasource.hikari에 필요한 만큼만 설정
		maximum-pool-size 운영상의 이유
		connection-timeout=30000 운영상의 이유로 비율에 맞게 적용
		idle-timeout=600000


================================================================================
======================================================================================

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


==================================================================
tomcat, 필터(web.xml)
spring컨테이너, 필터(인터셉터)
messageconverter, client에서 json으로 보내도 class로 받을 수 있음

client -> tomcat(서블릿 컨테이너)


아파치 : URL, 정적자원 파일, 이미지, 동영상등의 리소스
톰캣 : URI, 식별자, jsp같은 자바를 컴파일해서 아파치에 리턴

client -> apach -> tomcat -> apach -> client

springdms URL을 모두 막아 줌, jsp같은 URI를 통한 자바형식이 요청만 받아 들임

=======================================================
DispatcherServlet
	클라이언트에서 http프로토콜로 들어오는 모든 요청을 제일 앞에서 중앙집중식으로 처리해 주는 front controller
		오래전에는 controller 마다 servlet 설정이 필요했는데 spring이 DispatcherServlet 정의
		spring도 예전에는 DispatcherServlet 설정이 필요했지만
		지금은 특별한 경우가 아니라면 설정하는 경우가 없는 것 같음
	
ViewResolver
	controller에서 어노테이션에 따라 뷰인지 데이터인지를 구분하고 뷰일때 적절한 페이지를 반환
		예전에는 이것도 설정이 있었다는데 지금은 특별한 경우가 아니라면 설정하는 경우가 없는 것 같음



web.xml
servlet context 초기 파라미터
세션 유효시간 설정
servlet/jsp 정의
servlet/jsp 매핑
mine type 매핑
welcome file list
error page처리
리스너/필터 설정
보안









