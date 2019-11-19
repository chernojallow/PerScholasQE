package com.perscholas.spring_mvc_sba.rest_constroller.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perscholas.spring_mvc_sba.rest_constroller.models.Student;

@RestController
public class HomeRestController {
	private Map<Integer, Student> sMap;
	private ObjectMapper mapper;

	@Autowired
	public HomeRestController(Map<Integer, Student> s, ObjectMapper m) {
		sMap = s;
		mapper = m;
	}

	@GetMapping(value = "/", produces = "text/html")
	public String showWelcomeMessage() {
		return "<h1>Student REST API Example</h1> <br/> <p>/student/{id} and /allstudents";
	}

	@GetMapping("/student/{sid}")
	public String getStudent(@PathVariable Integer sid) throws JsonProcessingException {
		if (sMap.get(sid) != null) {
			Student s = sMap.get(sid);
			return mapper.writeValueAsString(s);
		}

		return "Student ID not found.";
	}

	@GetMapping("/allstudents")
	public String getAllStudents() throws JsonProcessingException {
		return mapper.writeValueAsString(sMap);
	}
}
