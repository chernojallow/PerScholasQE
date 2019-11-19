package com.perscholas.rest_controller.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perscholas.rest_controller.models.Member;

@RestController
public class HomeController {
	
	private Map<Integer, Member> memberMap;
	private ObjectMapper  mapper;
	
	@Autowired
	public HomeController(Map<Integer, Member> memberMap, 
			ObjectMapper mapper) {
		this.mapper = mapper;
		this.memberMap = memberMap;
	}
	
	@GetMapping(value = "/", produces = "text/html")
	public String showStringMessage() {
		return "<h1 style='color: red;'>Hello from @RestController!</h1>";
	}
	@GetMapping("/member/{id}")
	public String getStudent(@PathVariable Integer id) throws JsonProcessingException {
		/* The ObjectMapper class is part of the Jackson library which 
		 * provides the ability to read and write JSON either to or from 
		 * POJOs or to or from a JSON Tree Model. In this case we will write a 
		 * JSON string from a Student object and return it as part of the HTTP 
		 * response. You can read more about ObjectMapper at the following 
		 * website: https://fasterxml.github.io/jackson-databind/javadoc/2.7/com
                 * /fasterxml/jackson/databind/ObjectMapper.html */
		
		if (memberMap.get(id) != null) {
			Member member = memberMap.get(id);
			/* The student properties are returned to the client (e.g., browser) 
			 * as a JSON string. */
			return mapper.writeValueAsString(member);
		} 
		// The error String is returned to the web client
		return "Member ID not found";
	}
	
//	@GetMapping("/getAllMember")
//	public String getAllMembers() throws JsonProcessingException {
//		return mapper.writeValueAsString(this.memberMap);
//	}
}
