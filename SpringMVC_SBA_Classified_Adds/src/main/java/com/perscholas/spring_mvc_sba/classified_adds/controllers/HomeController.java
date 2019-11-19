package com.perscholas.spring_mvc_sba.classified_adds.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.perscholas.spring_mvc_sba.classified_adds.models.Ad;
import com.perscholas.spring_mvc_sba.classified_adds.models.User;
import com.perscholas.spring_mvc_sba.classified_adds.repositories.AdRepository;
import com.perscholas.spring_mvc_sba.classified_adds.repositories.UserRepository;

@Controller
public class HomeController {
	@Autowired
	AdRepository adRepository;

	@Autowired
	UserRepository userRepository;

	@GetMapping("/")
	public String showLogin(Model model) {
		model.addAttribute("user2", new User());
		return "login";
	}

	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@GetMapping("/login")
	public String addUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		if (result.hasErrors())
			return "login";

		userRepository.addUser(user);
		System.out.println("User Added: " + user.getUsername());
		return "redirect:/";
	}

	@PostMapping("/checkLogin")
	public String validateLogin(@Valid @ModelAttribute("user2") User user, BindingResult result, Model model) {
		User u = null;
		if (result.hasErrors())
			return "login";

		u = userRepository.getUser(user.getUsername());

		if (u == null) {
			System.out.println("u == null");
			return "redirect:/";
		}

		if (!u.getPassword().equals(user.getPassword())) {
			System.out.println("u.pass != user.pass");
			return "redirect:/";
		}

		return "redirect:allAds";
	}

	@GetMapping("/allAds")
	public String showAds(Model model) throws SQLException {
		List<Ad> allAds = adRepository.showAds();
		model.addAttribute("allAds", allAds);
		model.addAttribute("ad", new Ad());
		return "Ads";
	}

	@PostMapping("/addAd")
	public String addAd(@Valid @ModelAttribute("ad") Ad ad, BindingResult result, Model model)
			throws ClassNotFoundException, SQLException, IOException {
		if (result.hasErrors()) {
			List<Ad> allAds = adRepository.showAds();
			model.addAttribute("allAds", allAds);
			return "Ads";
		}

		Integer adId = adRepository.addAd(ad);

		if (adId == -1) {
			List<Ad> allAds = adRepository.showAds();
			model.addAttribute("allAds", allAds);
			model.addAttribute("errorMessage", "Add Ad failed.");
			return "Ads";
		}

		return "redirect:/allAds";
	}

	@GetMapping("/orderAd/{adId}")
	public String placeOrder(@PathVariable Integer adId) throws IOException, SQLException {
		adRepository.orderAd(adId);
		return "forward:/allAds";
	}

	@GetMapping("/cancelAd/{adId}")
	public String cancelOrder(@PathVariable Integer adId) throws IOException, SQLException {
		adRepository.cancelAd(adId);
		return "forward:/allAds";
	}

	@GetMapping("/removeAd/{adId}")
	public String removeAd(@PathVariable Integer adId) throws IOException, SQLException {
		Boolean b = adRepository.removeAd(adId);
		System.out.println("removed: " + b);
		return "forward:/allAds";
	}
}