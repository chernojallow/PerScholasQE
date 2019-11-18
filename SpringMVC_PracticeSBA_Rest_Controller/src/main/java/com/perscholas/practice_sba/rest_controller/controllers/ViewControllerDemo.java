package com.perscholas.practice_sba.rest_controller.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.perscholas.practice_sba.rest_controller.models.Vehicle;

@Controller
public class ViewControllerDemo {

	private RestTemplate restTemplate;

	@Autowired
	public ViewControllerDemo(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@GetMapping("/")
	public String showControllerView() {
		return "ControllerView";
	}

	@GetMapping("/displayVehicle/{id}")
	public String displayVehicle(@PathVariable Integer id, Model model) {
		restTemplate = new RestTemplate();
		try {
			Vehicle vehicle = restTemplate.getForObject("http://localhost:8080/SpringMVC_PracticeSBA_Rest_Controller/vehicle/" + id,
					Vehicle.class);
			model.addAttribute("vehicle", vehicle);
			return "Vehicle";
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Student not found");
			return "Vehicle";
		}
	}

	@GetMapping("/displayVehicles")
	public String displayVehicles(Model model) {
		ResponseEntity<Map<Integer, Vehicle>> response = restTemplate.exchange(
				"http://localhost:8080/SpringMVC_PracticeSBA_Rest_Controller/allVehicles", HttpMethod.GET, null,
				new ParameterizedTypeReference<Map<Integer, Vehicle>>() {
				});
		model.addAttribute("allVehicles", response.getBody());
		return "AllVehicles";
	}
}