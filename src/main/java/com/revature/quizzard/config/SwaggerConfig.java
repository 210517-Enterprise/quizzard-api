package com.revature.quizzard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	/*
	 * Made possible by the SpringFox Dependency
	 * https://www.webdevelopmenthelp.net/2016/08/use-spring-fox-java-application-development.html
	 */
	
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.revature.quizzard.web.controllers"))
                .paths(PathSelectors.any())
                .build();
    }

}
