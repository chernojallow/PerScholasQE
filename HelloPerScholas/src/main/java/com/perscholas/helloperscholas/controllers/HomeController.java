package com.perscholas.helloperscholas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showHelloPage() {
		return "Hello";
	}
	
}