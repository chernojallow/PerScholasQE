package com.perscholas.springmvc_controllers.config;

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
import com.perscholas.springmvc_controllers.models.Student;

@Configuration
@ComponentScan("com.perscholas.springmvc_controllers")
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
	Map<Integer, Student> studentMap() {
		Map<Integer, Student> sMap = new HashMap<>();
		Student student;

		student = new Student(1, "Lin Xiao", "xiaolin996");
		student.getCourses().add("Application Developer");
		student.getCourses().add("Data Engineering");
		sMap.put(student.getStudentId(), student);

		student = new Student(2, "Chen Li", "chenli123");
		student.getCourses().add("Data Engineering");
		student.getCourses().add("Quality Engineering and Assurance");
		sMap.put(student.getStudentId(), student);

		student = new Student(3, "Cherno Jallow", "cherno123");
		student.getCourses().add("Application Developer");
		student.getCourses().add("Quality Engineering and Assurance");
		sMap.put(student.getStudentId(), student);
		return sMap;
	}
}
