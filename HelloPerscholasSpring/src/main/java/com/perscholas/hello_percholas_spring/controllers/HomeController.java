package com.perscholas.hello_percholas_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String showHelloPage() {
		return "Hello";
	}
	
	@RequestMapping("/helloQE")
	public String helloQE() {
		return "HelloQE";
	}

}
