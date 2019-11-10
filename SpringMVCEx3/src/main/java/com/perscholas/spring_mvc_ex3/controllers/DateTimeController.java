package com.perscholas.spring_mvc_ex3.controllers;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DateTimeController {
	@GetMapping("/")
	public String showHelloPage(Model model) {
		model.addAttribute("datetime", Timestamp.valueOf(LocalDateTime.now()));
		return "Welcome";
	}
}