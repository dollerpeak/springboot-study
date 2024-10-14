
lombok
	@Getter : get 자동생성
	@Setter : set 자동생성
	@ToString : toString() 자동생성
		@ToString(exclude = "password") : 특정 필드는 출력을 안함
	생성자
		@NoArgsConstructor : 파라메터가 없는 기본 생성자
		@AllArgsConstructor : 모든 파라메터가 있는 생성자
		@RequiredArgsConstructor : final, NonNull인 값만 파라메터로 받는 생성자


Controller
	@Controller
	@RequestMapping("/v1") : 반복되는 url에 사용
	@ResponseBody
		사용하면 데이터가 반환됨
		사용하지 않으면 페이지가 반환됨


mybatis
	mapper-locations: classpath:mybatis/mariadb/**/*.xml : 실제 경로에 맞게 작성
	config-location: classpath:mybatis-config.xml : 설정값을을 별도의 xml에 적용
		configuration.map-underscore-to-camel-case: true 아니면 이런식으로 별도로 작성








======================================================================

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





