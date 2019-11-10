package com.perscholas.spring_mvc_ex4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@GetMapping("/")
	public String showHelloPage(Model model) {
		return "Login";
	}

	@GetMapping("/Registration")
	public String showRegistrationPage(Model model) {
		return "Registration";
	}

	@PostMapping("/LoginInformation")
	public String showLoginInformation(@RequestParam String name, @RequestParam String password, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("password", password);
		return "LoginInfo";
	}

	@PostMapping("/RegInformation")
	public String showRegInformation(@RequestParam String name, @RequestParam String email,
			@RequestParam String password, @RequestParam String fGenre, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("password", password);
		model.addAttribute("fGenre", fGenre);
		return "RegInfo";
	}
}