package com.perscholas.practice_sba.rest_controller.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.perscholas.practice_sba.rest_controller.models.Vehicle;

@RestController
public class RestControllerDemo {

	private Map<Integer, Vehicle> vehicleMap;
	private ObjectMapper mapper;

	@Autowired
	public RestControllerDemo(Map<Integer, Vehicle> vehicleMap, ObjectMapper mapper) {
		this.mapper = mapper;
		this.vehicleMap = vehicleMap;
	}

	@GetMapping(value = "/hello", produces = "text/html")
	public String showStringMessage() {
		return "<h1 style='color: red;'>Hello from @RestController!</h1>";
	}

	@GetMapping("/vehicle/{id}")
	public String getVehicle(@PathVariable Integer id) throws JsonProcessingException {

		if (vehicleMap.get(id) != null) {
			Vehicle vehicle = vehicleMap.get(id);
			return mapper.writeValueAsString(vehicle);
		}
		return "Student ID not found";
	}

	@GetMapping("/allVehicles")
	public String allVehicles() throws JsonProcessingException {
		return mapper.writeValueAsString(this.vehicleMap);
	}
}