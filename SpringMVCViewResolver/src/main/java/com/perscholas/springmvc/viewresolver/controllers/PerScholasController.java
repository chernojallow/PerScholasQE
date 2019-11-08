package com.perscholas.springmvc.viewresolver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/perScholas")
public class PerScholasController {
	private String course = "Welcome Per Scholas";
	private String displayPage = "PerScholasHome";

	@RequestMapping("/")
	public String defaultView(Model model) {
		model.addAttribute("heading", course);
		return displayPage;
	}
}