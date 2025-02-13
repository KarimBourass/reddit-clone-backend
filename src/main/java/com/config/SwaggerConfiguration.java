package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket redditCloneApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select() // get a docket builder object
                .apis(RequestHandlerSelectors.any()) // Api wich going to be be exposed
                .paths(PathSelectors.any()) // paths wich going to be  exposed
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Reddit Clone API")
                .version("1.0")
                .description("API for Reddit Clone Application")
                .contact(new Contact("Karim Bourass", "https://github.com/KarimBourass", "karimboura11@gmail.com"))
                .license("Apache License Version 2.0")
                .build();
    }
}
