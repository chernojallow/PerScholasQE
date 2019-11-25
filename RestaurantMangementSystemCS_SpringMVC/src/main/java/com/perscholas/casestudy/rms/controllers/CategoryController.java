package com.perscholas.casestudy.rms.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.perscholas.casestudy.rms.models.Category;
import com.perscholas.casestudy.rms.repositories.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository cRep;
	
	@GetMapping("/showAddCategory")
	public String showAddCategory(Model model) {
		model.addAttribute("category", new Category());
		return "AddCategory";
	}
	
	@PostMapping("addCategory")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		
		return null;
	}
	
}
