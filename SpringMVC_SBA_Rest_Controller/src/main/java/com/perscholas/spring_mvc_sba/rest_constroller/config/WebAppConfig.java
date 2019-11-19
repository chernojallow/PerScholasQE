package com.perscholas.spring_mvc_sba.rest_constroller.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.perscholas.spring_mvc_sba.rest_constroller.models.Student;

@Configuration
@ComponentScan("com.perscholas.spring_mvc_sba.rest_constroller")
public class WebAppConfig implements WebMvcConfigurer {
	@Bean
	InternalResourceViewResolver viewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}

	@Bean
	ObjectMapper objectMapper() {
		return new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
	}

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	Map<Integer, Student> vehicleMap() {
		Map<Integer, Student> vMap = new HashMap<>();
		Student s;

		s = new Student(1, "Lin Xiao", "xiaolin996@gmail.com",
				new String[] { "Application Developer", " Data Engineering" });
		vMap.put(s.getStudentId(), s);

		s = new Student(2, "Chen Li", "chenli123@gmail.com",
				new String[] { "Quality Engineering", "Quality Assurance" });
		vMap.put(s.getStudentId(), s);

		// Entry 3
		s = new Student(3, "Cherno Jallow", "chernojallow123@gmail.com",
				new String[] { "Application Developer", "Red" });
		vMap.put(s.getStudentId(), s);

		return vMap;
	}
}
