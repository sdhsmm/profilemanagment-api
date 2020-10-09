package com.swarg.profilemanagment.docsconfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final Contact profilemngt = new Contact("Sudhanshu Mishra", "sudhanshu.com", "email@sudhanhu.com");
	static ApiInfo apiinfo = new ApiInfo("Profile managment api.", "To be used to serve profile.", "1.0", "url:noterms", profilemngt, "APACHE lICANSE", "url:No Url", new ArrayList<VendorExtension>());

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiinfo).produces(DEFAULTS_PRODUCES_AND_CONSUMES).consumes(DEFAULTS_PRODUCES_AND_CONSUMES).select()
				.apis(RequestHandlerSelectors.basePackage("com.swarg.profilemanagment.controller")).build()
				.securityContexts(Collections.singletonList(securityContext()));
	}
	
	

	Set<String> DEFAULTS_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json"));

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/.*")).build();
	}

	private List<SecurityReference> defaultAuth() {
		final AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		final AuthorizationScope[] authorizationScopes = new AuthorizationScope[] { authorizationScope };
		return Collections.singletonList(new SecurityReference("Bearer", authorizationScopes));
	}


}
