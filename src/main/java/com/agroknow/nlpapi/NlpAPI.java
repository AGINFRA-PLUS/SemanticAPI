package com.agroknow.nlpapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class NlpAPI extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(NlpAPI.class, args);
    }

    @Bean
    public Docket nlpApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Agroknow Semantic API")
                .description("The Agroknow Semantic API is responsible for delivering textual analysis and semantic link suggestions in response to user input. If chained correctly, NLP services can be used in conjunction with the Search API to produce links to semantic resources (i.e. SKOS vocabularies) harvested by Agroknow’s Data Platform. Otherwise, users may invoke the “annotate” service directly to produce links to any or a specific vocabulary harvested by the platform.")
                .termsOfServiceUrl("")
                .license("")
                .licenseUrl("")
                .version("1.0")
                .build();
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(NlpAPI.class);
    }

}