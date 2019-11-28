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

import com.perscholas.casestudy.rms.models.Item;
import com.perscholas.casestudy.rms.repositories.ItemRepository;

@Controller
public class ItemController {
	@Autowired
	private ItemRepository iRep;

	@GetMapping("/showEditItem")
	public String showEditItem(@RequestParam Integer itemId, Model model)
			throws ClassNotFoundException, IOException, SQLException {
		model.addAttribute("item", iRep.getById(itemId));
		model.addAttribute("newItem", new Item());

		return "EditItem";
	}

	@GetMapping("/deleteItem")
	public String deleteItem(@RequestParam Integer itemId) throws IOException, SQLException {
		iRep.remove(itemId);
		return "redirect:/showSetup";
	}
	
	@PostMapping("/editItem")
	public String editCategory(@Valid @ModelAttribute("newItem") Item item, BindingResult result)
			throws ClassNotFoundException, SQLException, IOException {
		if (result.hasErrors()) {
			return "EditItem";
		}

		iRep.update(item);
		return "redirect:/showSetup";
	}
}
