package com.perscholas.casestudy.rms.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.perscholas.casestudy.rms.models.Address;
import com.perscholas.casestudy.rms.models.Registration;
import com.perscholas.casestudy.rms.models.User;
import com.perscholas.casestudy.rms.repositories.AddressRepository;
import com.perscholas.casestudy.rms.repositories.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository uRep;

	@Autowired
	private AddressRepository aRep;

	@GetMapping(value = { "/", "/login" })
	public String showLoginPage(Model model) {
		model.addAttribute("login", new User());
		return "Login";
	}

	@PostMapping("/loginUser")
	public String loginUser(@Valid @ModelAttribute("login") User login, BindingResult result, Model model, HttpSession session)
			throws ClassNotFoundException, IOException, SQLException {
		User u = uRep.getByName(login.getUsername());

		if (u == null) {
			model.addAttribute("errorMessage", "Invalid username");
			return "Login";
		} else if (u.getUsername().equals(login.getUsername())) {
			if (u.getPassword().equals(login.getPassword())) {
				session.setAttribute("currentUser", u);
				session.setAttribute("currentUserAddress", aRep.getById(u.getAddressId()));
			} else {
				model.addAttribute("errorMessage", "Invalid password");
				return "Login";
			}
		}

		return "redirect:/welcome";
	}

	@GetMapping("/welcome")
	public String showWelcomePage() {
		return "Welcome";
	}

	@GetMapping("/register")
	public String showRegistrationPage(Model model) {
		model.addAttribute("registration", new Registration());
		return "Registration";
	}

	@PostMapping("/registerUser")
	public String registerUser(@Valid @ModelAttribute("registration") Registration reg, BindingResult result,
			Model model) throws ClassNotFoundException, SQLException, IOException {
		if (result.hasErrors()) {
			return "Registration";
		}

		System.out.println(reg.toString());

		Integer addressId = aRep.create(
				new Address(reg.getAddress1(), reg.getAddress2(), reg.getCity(), reg.getState(), reg.getPostalCode()));
		if (addressId == -1) {
			model.addAttribute("errorMessage", "Create address failed");
			return "Registration";
		}

		System.out.println("Address ID: " + addressId);
		User u = uRep.getByName(reg.getUsername());

		if (u != null) {
			model.addAttribute("errorMessage", "Username is taken. Try another");
			aRep.remove(addressId);
			return "Registration";
		}

		Integer userId = uRep.create(new User(reg.getUsername(), reg.getPassword(), addressId, 1));
		if (userId == -1) {
			model.addAttribute("errorMessage", "Create user failed");
			aRep.remove(addressId);
			return "Registration";
		}

		System.out.println("User ID: " + userId);
		model.addAttribute("successMessage", "Successfully registered");

		return "redirect:/login";
	}
	
	@GetMapping("/showProfile")
	public String showProfile() throws ClassNotFoundException, IOException, SQLException {
		return "Profile";
	}
	
	@GetMapping("/showUpdate")
	public String showUpdate() {
		return "Update";
	}
	
	@PostMapping("/updateProfile")
	public String updateProfile() {
		
		return null;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
