package com.perscholas.software_developer_club.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.perscholas.software_developer_club.dao.MemberDAO;
import com.perscholas.software_developer_club.models.Member;

@Controller
@SessionAttributes
public class MemberController {
	@GetMapping("/")
	public String showDefault() {
		return "LoginPage";
	}

	@GetMapping("/login")
	public String showLogin() {
		return "LoginPage";
	}

	@PostMapping("/loginMember")
	public String loginMember(@RequestParam String name, @RequestParam String password, HttpSession session,
			Model model) throws ClassNotFoundException, IOException, SQLException {
		MemberDAO m_dao = new MemberDAO();
		Member m = m_dao.getMemberByName(name);

		if (m != null) {
			if (password.equals(m.getPassword())) {
				session.setAttribute("currentMember", m);
				return "redirect:/showWelcomePage";
			} else {
				model.addAttribute("errorMessage", "Invalid login-password");
				return "LoginPage";
			}
		} else {
			model.addAttribute("errorMessage", "Invalid login-user name");
			return "LoginPage";
		}
	}

	@GetMapping("/showRegistration")
	public String showRegister() {
		return "RegistrationPage";
	}

	@PostMapping("/registerMember")
	public String registerMember(@RequestParam String name, @RequestParam String password, @RequestParam String email,
			@RequestParam String favoriteLanguage, Model model)
			throws ClassNotFoundException, SQLException, IOException {
		MemberDAO m_dao = new MemberDAO();
		Member m = new Member(-1, name, email, password, favoriteLanguage);
		m.setMemberId(m_dao.registerMember(m));
		System.out.println(m.toString());

		return "redirect:/";
	}

	@GetMapping("/showWelcomePage")
	public String showWelcome() {
		return "Welcome";
	}

	@GetMapping("/showProfile")
	public String showProfile() {
		return "MemberProfile";
	}

	@GetMapping("/showUpdatePage")
	public String showUpdatePage() {
		return "MemberUpdate";
	}

	@PostMapping("/updateMember")
	public String updateMember(@RequestParam String name, @RequestParam String password, @RequestParam String email,
			@RequestParam String favoriteLanguage, HttpSession session)
			throws ClassNotFoundException, SQLException, IOException {
		MemberDAO m_dao = new MemberDAO();
		Member m = (Member) session.getAttribute("currentMember");
		m.setName(name);
		m.setPassword(password);
		m.setEmail(email);
		m.setFavoriteLanguage(favoriteLanguage);

		m_dao.updateMember(m);
		session.removeAttribute("currentMember");
		session.setAttribute("currentMember", m);

		return "redirect:/showProfile";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
