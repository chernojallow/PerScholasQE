package com.perscholas.springmvc_controllers.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perscholas.springmvc_controllers.models.Student;

@RestController
public class RestControllerDemo {

	private Map<Integer, Student> studentMap;
	private ObjectMapper mapper;

	@Autowired
	public RestControllerDemo(Map<Integer, Student> studentMap, ObjectMapper mapper) {
		this.mapper = mapper;
		this.studentMap = studentMap;
	}

	@GetMapping(value = "/hello", produces = "text/html")
	public String showStringMessage() {
		return "<h1 style='color: red;'>Hello from @RestController!</h1>";
	}

	@GetMapping("/student/{id}")
	public String getStudent(@PathVariable Integer id) throws JsonProcessingException {
		if (studentMap.get(id) != null) {
			Student student = studentMap.get(id);
			return mapper.writeValueAsString(student);
		}
		return "Student ID not found";
	}

	@GetMapping("/getAllStudents")
	public String getAllStudent() throws JsonProcessingException {
		return mapper.writeValueAsString(this.studentMap);
	}
}