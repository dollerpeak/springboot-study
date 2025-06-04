package com.study.config.swagger;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(title = "Swagger 제목", description = "Swagger 설명", version = "Swagger 버전"))
public class SwaggerConfig {
	// option 이 상당히 많은걸로 아는데 우선은 패스
	// - https://springdoc.org/
	// - https://springdoc.org/#properties
	// - https://swagger.io/docs/open-source-tools/swagger-ui/usage/configuration/
	// - URL : ~/swagger-ui/index.html (ex) http://localhost:8081/swagger-ui/index.html
}
