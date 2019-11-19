package com.perscholas.rest_controller.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.perscholas.rest_controller.models.Member;

@Configuration
@EnableWebMvc
@ComponentScan("com.perscholas.rest_controller")
public class WebAppConfig implements WebMvcConfigurer {
	@Bean
	InternalResourceViewResolver viewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
	
	@Bean
	ObjectMapper objectMapper() {
		// INDENT_OUTPUT allows for "pretty printing" of JSON data
		return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	}
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	// This bean creates a map which will emulate database records.
	@Bean
	Map<Integer, Member> memberMap() {
		Map<Integer, Member> sMap = new HashMap<>();
		Member member;
		// Create first student record
		member = new Member(1, "John", "john@doe.com", "john1234", "Java");
		sMap.put(member.getMemberId(), member);
		// Create second student record
		member = new Member(2, "Jane", "jane@doe.com", "jane1234", "Python");
		sMap.put(member.getMemberId(), member);
		return sMap;
	}
}