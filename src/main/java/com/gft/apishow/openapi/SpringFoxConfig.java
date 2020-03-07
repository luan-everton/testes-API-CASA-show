package com.gft.apishow.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoxConfig implements WebMvcConfigurer {
	
	@Bean
	public Docket apiDocket () {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
					.apis(RequestHandlerSelectors.basePackage("com.gft.apishow"))
					.build()
					.apiInfo(apiInfo())
					.tags(new Tag("Casas", "Gerencia as casas"),
							new Tag("Eventos","Gerencia os eventos"),
							new Tag("Usuario"," Gerencia os usuarios"),
							new Tag("Vendas","Gerencia as vendas "));
		      
	}
	
	
	public ApiInfo apiInfo () {	
		return new ApiInfoBuilder()
				.title("Texas Club")
				.description("API aberta para Gerenciamneto de eventos ")
				.version("1")
				.contact(new Contact("Texas Club", "www.texasclub.com","contato.texasclub@hotmail.com"))
				.build();
		
	}
	
	
	
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
			.addResourceLocations("classpath:/META-INF/resources/");
		
		registry.addResourceHandler("/webjars/**")
			.addResourceLocations("classpath:/META-INF/resources/webjars/");

	}
	
	}


