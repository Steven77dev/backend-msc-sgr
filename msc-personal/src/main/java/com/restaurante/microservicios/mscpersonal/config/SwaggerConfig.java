package com.restaurante.microservicios.mscpersonal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
//@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig  extends WebMvcConfigurationSupport {

    @Value("${app.api.swagger.version}")
    private String version;
    @Value("${app.api.swagger.titulo}")
    private String title;
    @Value("${app.api.swagger.descripcion}")
    private String description;
    @Value("${app.api.swagger.basePackage}")
    private String basePackage;
    @Value("${app.api.swagger.contacto-nombre}")
    private String contactName;
    @Value("${app.api.swagger.contacto-correo}")
    private String contactEmail;
    @Value("${app.api.swagger.path-pattern}")
    private String pathPattern;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build()
                .directModelSubstitute(LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(LocalDateTime.class, java.util.Date.class)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version(version)
                .contact(new Contact(contactName, null, contactEmail))
                .build();
    }

   @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(pathPattern)
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}