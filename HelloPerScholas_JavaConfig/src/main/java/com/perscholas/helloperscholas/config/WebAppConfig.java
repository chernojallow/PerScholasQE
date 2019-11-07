package com.perscholas.helloperscholas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.perscholas.helloperscholas")
public class WebAppConfig implements WebMvcConfigurer {
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

//	@Bean
//	public ApplicationService applicationService() {
//		return new ApplicationService();
//	}
//
//	@Bean
//	public RegistrationService registrationService() {
//		return new RegistrationService();
//	}
}