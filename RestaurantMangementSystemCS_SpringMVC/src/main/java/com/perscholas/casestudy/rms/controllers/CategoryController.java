package com.perscholas.casestudy.rms.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@PostMapping("/addCategory")
	public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model)
			throws ClassNotFoundException, SQLException, IOException {
		if (result.hasErrors()) {
			return "AddCategory";
		}

		category.setCategoryId(cRep.create(category));

		if (category.getCategoryId() == -1) {
			model.addAttribute("errorMessage", "Create category failed");
			return "AddCategory";
		}

		return "redirect:/showSetup";
	}

	@GetMapping("/showEditCategory")
	public String showEditCategory(@RequestParam Integer categoryId, Model model)
			throws ClassNotFoundException, IOException, SQLException {
		model.addAttribute("category", cRep.getById(categoryId));
		model.addAttribute("newCategory", new Category());
		return "EditCategory";
	}

	@GetMapping("/deleteCategory")
	public String deleteCategory(@RequestParam Integer categoryId) throws IOException, SQLException {
		cRep.remove(categoryId);
		return "redirect:/showSetup";
	}

	@PostMapping("/editCategory")
	public String editCategory(@Valid @ModelAttribute("newCategory") Category category, BindingResult result)
			throws ClassNotFoundException, SQLException, IOException {
		if (result.hasErrors()) {
			return "EditCategory";
		}

		cRep.update(category);
		return "redirect:/showSetup";
	}
}
