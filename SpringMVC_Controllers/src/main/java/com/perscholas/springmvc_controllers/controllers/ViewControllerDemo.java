package com.perscholas.springmvc_controllers.controllers;

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

import com.perscholas.springmvc_controllers.models.Student;

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

	@GetMapping("/displayStudent/{id}")
	public String getStudent(@PathVariable Integer id, Model model) {
		restTemplate = new RestTemplate();
		try {
			System.out.println("id:" + id);
			Student student = restTemplate.getForObject("http://localhost:8080/SpringMVC_Controllers/student/" + id,
					Student.class);
			System.out.println("student:" + student.toString());
			model.addAttribute("student", student);
			return "Student";
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Student not found");
			return "Student";
		}
	}

	@GetMapping("/displayStudents")
	public String displayStudent(Model model) {
		ResponseEntity<Map<Integer, Student>> response = restTemplate.exchange(
				"http://localhost:8080/SpringMVC_Controllers/getAllStudents", HttpMethod.GET, null,
				new ParameterizedTypeReference<Map<Integer, Student>>() {
				});
		model.addAttribute("allStudents", response.getBody());
		return "AllStudents";
	}
}