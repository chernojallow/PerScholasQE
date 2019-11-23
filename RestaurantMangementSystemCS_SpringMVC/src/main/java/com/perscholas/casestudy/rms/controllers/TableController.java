package com.perscholas.casestudy.rms.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.perscholas.casestudy.rms.models.Order;
import com.perscholas.casestudy.rms.models.OrderItems;
import com.perscholas.casestudy.rms.models.Table;
import com.perscholas.casestudy.rms.models.User;
import com.perscholas.casestudy.rms.repositories.OrderItemsRepository;
import com.perscholas.casestudy.rms.repositories.OrderRepository;
import com.perscholas.casestudy.rms.repositories.TableRepository;

@Controller
public class TableController {
	@Autowired
	private TableRepository tRep;

	@Autowired
	private OrderRepository oRep;

	@Autowired
	private OrderItemsRepository oiRep;

	@GetMapping("/showTables")
	public String showTablesPage(Model model, HttpSession session)
			throws SQLException, ClassNotFoundException, IOException {
		User u = (User) session.getAttribute("currentUser");

		List<Table> tList = tRep.getAllByAddressId(u.getAddressId());
		model.addAttribute("allTables", tList);

		List<Order> oList = oRep.getAllByAddressId(u.getAddressId());
		model.addAttribute("allOrders", oList);

		List<OrderItems> oiList = oiRep.getAllByAddressIdOnTable(u.getAddressId());
		model.addAttribute("allOrderItems", oiList);

		return "Tables";
	}

	@PostMapping("/editTables")
	public String editTables(@RequestParam Integer tables, HttpSession session)
			throws ClassNotFoundException, SQLException, IOException {

		User u = (User) session.getAttribute("currentUser");
		Integer currentTableNbr = tRep.getNbrOfTablesByAddressId(u.getAddressId());

		if (tables > currentTableNbr) {
			for (int i = currentTableNbr + 1; i <= tables; i++)
				tRep.create(i, u.getAddressId());
		} else if (tables < currentTableNbr) {
			for (int i = currentTableNbr; i > tables; i--)
				tRep.remove(i, u.getAddressId());
		}
		return "redirect:/showSetup";
	}
}
