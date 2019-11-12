package com.perscholas.software_developer_club.controllers;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.perscholas.software_developer_club.dao.SignupDAO;

@Controller
public class SignupController {
	@GetMapping("/signupForEvent")
	public String signupForEvent(@RequestParam Integer memberId, @RequestParam Integer eventId)
			throws ClassNotFoundException, SQLException, IOException {
		SignupDAO s_dao = new SignupDAO();
		s_dao.signupForEvent(memberId, eventId);

		return "redirect:/showEventsPage";
	}

	@GetMapping("/cancelSignup")
	public String cancelSignup(@RequestParam Integer memberId, @RequestParam Integer eventId)
			throws IOException, SQLException {
		SignupDAO s_dao = new SignupDAO();
		s_dao.cancelSignup(memberId, eventId);

		return "redirect:/showEventsPage";
	}
}
