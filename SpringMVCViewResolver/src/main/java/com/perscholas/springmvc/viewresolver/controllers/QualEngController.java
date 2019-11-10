package com.perscholas.springmvc.viewresolver.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/qualEng")
public class QualEngController {
	private String course = "Quality Engineering & Assurance";
	private String displayPage = "PerScholasHome";

	// String return type
	@RequestMapping("/")
	public String defaultView(Model model) {
		model.addAttribute("heading", course);
		return displayPage;
	}

	// ModelAndView return type
	@RequestMapping("/courseId")
	public ModelAndView showCourseId() {
		ModelAndView mav = new ModelAndView(displayPage, "heading", course);
		mav.addObject("message", "2019-DAL-01");
		return mav;
	}

	// String return type
	@RequestMapping("/location")
	public String showLocation(Model model) {
		model.addAttribute("heading", course);
		model.addAttribute("message", "Dallas");
		return displayPage;
	}
}
