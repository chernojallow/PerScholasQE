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
import org.springframework.web.bind.annotation.RequestParam;

import com.perscholas.casestudy.rms.models.Address;
import com.perscholas.casestudy.rms.models.Registration;
import com.perscholas.casestudy.rms.models.User;
import com.perscholas.casestudy.rms.repositories.AddressRepository;
import com.perscholas.casestudy.rms.repositories.CategoryRepository;
import com.perscholas.casestudy.rms.repositories.ItemRepository;
import com.perscholas.casestudy.rms.repositories.TableRepository;
import com.perscholas.casestudy.rms.repositories.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository uRep;

	@Autowired
	private AddressRepository aRep;
	
	@Autowired
	private TableRepository tRep;
	
	@Autowired
	private CategoryRepository cRep;
	
	@Autowired
	private ItemRepository iRep;

	@GetMapping(value = { "/", "/login" })
	public String showLoginPage(Model model) {
		model.addAttribute("login", new User());
		return "Login";
	}

	@PostMapping("/loginUser")
	public String loginUser(@Valid @ModelAttribute("login") User login, BindingResult result, Model model,
			HttpSession session) throws ClassNotFoundException, IOException, SQLException {
		if (result.hasErrors()) {
			model.addAttribute("errorMessage", "haserrors()");
			return "Login";
		}

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
		
		Integer addressId = aRep.create(
				new Address(reg.getAddress1(), reg.getAddress2(), reg.getCity(), reg.getState(), reg.getPostalCode()));
		if (addressId == -1) {
			model.addAttribute("errorMessage", "Create address failed");
			return "Registration";
		}

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

		model.addAttribute("successMessage", "Successfully registered");

		return "redirect:/login";
	}

	@GetMapping("/showProfile")
	public String showProfile(HttpSession session, Model model)
			throws ClassNotFoundException, IOException, SQLException {
		User u = (User) session.getAttribute("currentUser");
		model.addAttribute("subusers", uRep.getAllByAddressId(u.getAddressId()));
		return "Profile";
	}

	@GetMapping("/showChangePassword")
	public String showUpdate(Model model) {
		model.addAttribute("user", new User());
		return "ChangePassword";
	}

	@PostMapping("/changePassword")
	public String changePassword(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session)
			throws ClassNotFoundException, SQLException, IOException {
		if (result.hasErrors()) {
			return "ChangePassword";
		}

		User u = (User) session.getAttribute("currentUser");
		u.setPassword(user.getPassword());

		uRep.update(u);
		session.removeAttribute("currentUser");
		session.setAttribute("currentUser", u);

		return "redirect:/showProfile";
	}

	@GetMapping("/deleteSubuser")
	public String deleteSubuser(@RequestParam Integer userId) throws IOException, SQLException {
		uRep.remove(userId);
		return "redirect:/showProfile";
	}

	@GetMapping("/showAddSubuser")
	public String showAddSubuser(Model model) {
		model.addAttribute("subuser", new User());
		return "AddSubuser";
	}

	@PostMapping("/registerSubuser")
	public String registerSubuser(@Valid @ModelAttribute("subuser") User subuser, BindingResult result,
			HttpSession session) throws ClassNotFoundException, SQLException, IOException {
		if (result.hasErrors()) {
			return "ChangePassword";
		}
		
		uRep.create(subuser);
		
		return "redirect:/showProfile";
	}

	@GetMapping("/showSetup")
	public String showSetup(HttpSession session, Model model) throws ClassNotFoundException, IOException, SQLException {		
		User u = (User) session.getAttribute("currentUser");
		model.addAttribute("tables", Integer.class);
		model.addAttribute("nbrOfTables", tRep.getNbrOfTablesByAddressId(u.getAddressId()));
		model.addAttribute("allCategories", cRep.getAllByAddressId(u.getAddressId()));
		model.addAttribute("allItems", iRep.getAllByAddressId(u.getAddressId()));
		
		return "Setup";
	}
	
	@PostMapping("/setup")
	public String setup() {
		
		return null;
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
