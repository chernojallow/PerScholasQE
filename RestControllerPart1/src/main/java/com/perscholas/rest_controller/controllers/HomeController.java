package com.perscholas.rest_controller.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	@GetMapping(value = "/", produces = "text/html")
	public String sendText() {
		return "<h1>Hello World!</h1>";
	}
}
