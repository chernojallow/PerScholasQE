package com.perscholas.casestudy.rms.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.perscholas.casestudy.rms.models.Table;
import com.perscholas.casestudy.rms.models.User;
import com.perscholas.casestudy.rms.repositories.OrderRepository;
import com.perscholas.casestudy.rms.repositories.TableRepository;



@Controller
public class TableController {
	@Autowired
	private TableRepository tRep;
	
	@Autowired
	private OrderRepository oRep;
	
	@GetMapping("/showTables")
	public String showTablesPage(Model model, HttpSession session) throws SQLException, ClassNotFoundException, IOException {
		User u = (User) session.getAttribute("currentUser");
		List<Table> tList = tRep.getById(u.getUserId());
		model.addAttribute("allTables", tList);
		return "Tables";
	}
	
	@GetMapping("/showEditTables")
	public String showEditTables() {
		
		return null;
	}
}
