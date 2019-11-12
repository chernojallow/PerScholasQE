package com.perscholas.casestudy.rms.controllers;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.perscholas.casestudy.rms.daos.AddressDAO;
import com.perscholas.casestudy.rms.daos.UserDAO;
import com.perscholas.casestudy.rms.models.Address;
import com.perscholas.casestudy.rms.models.User;

@Controller
public class HomeController {

	@GetMapping("/")
	public String showDefaultPage() {
		return "Login";
	}

	@GetMapping("/login")
	public String showLoginPage() {
		return "Login";
	}

	@PostMapping("/loginUser")
	public String loginUser(@RequestParam String username, @RequestParam String password, Model model)
			throws ClassNotFoundException, IOException, SQLException {
		UserDAO u_dao = new UserDAO();
		User u = u_dao.getByName(username);
		u_dao.testConnection();

		if (u == null) {
			model.addAttribute("errorMessage", "Invalid username");
			return "Login";
		} else if (u.getUsername().equals(username)) {
			if (u.getPassword().equals(password)) {
				model.addAttribute("username", username);
				model.addAttribute("password", password);
			} else {
				model.addAttribute("errorMessage", "Invalid password");
				return "Login";
			}
		}
		return "Welcome";
	}

	@GetMapping("/welcome")
	public String showWelcomePage() {
		return "Welcome";
	}

	@GetMapping("/register")
	public String showRegistrationPage() {
		return "Registration";
	}

	@PostMapping("/registerUser")
	public String registerUser(@RequestParam String username, @RequestParam String password,
			@RequestParam String address1, @RequestParam String address2, @RequestParam String city,
			@RequestParam String state, @RequestParam Integer postalCode, Model model)
			throws ClassNotFoundException, SQLException, IOException {
		System.out.println("username:" + username);
		System.out.println("password:" + password);
		System.out.println("address1:" + address1);
		System.out.println("address2:" + address2);
		System.out.println("city:" + city);
		System.out.println("state:" + state);
		System.out.println("postalCode:" + postalCode);

		AddressDAO a_dao = new AddressDAO();
		a_dao.testConnection();
		Address a = new Address(-1, address1, address2, city, state, postalCode);
		a.setAddressId(a_dao.create(a));
		System.out.println(a.toString());
		
		if (a.getAddressId() != -1)
			model.addAttribute("successMeesage", "Register Successful");
		else {
			model.addAttribute("errorMessage", "Register Failed: Incorrect Address");
			return "Registration";
		}
		
		UserDAO u_dao = new UserDAO();
		u_dao.testConnection();
		User u = new User(-1, username, password, a.getAddressId(), 1);
		u.setUserId(u_dao.create(u));
		System.out.println(u.toString());
		
		if (u.getUserId() != -1)
			model.addAttribute("successMeesage", "Register Successful");
		else {
			model.addAttribute("errorMessage", "Register Failed: Incorrect Username and/or Password");
			a_dao.remove(a.getAddressId());
			return "Registration";
		}
		
		return "Login";
	}
}
