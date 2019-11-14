package com.perscholas.software_developer_club.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.perscholas.software_developer_club.dao.EventDAO;
import com.perscholas.software_developer_club.models.Event;
import com.perscholas.software_developer_club.models.Member;

@Controller
public class EventController {
	@GetMapping("/showEventsPage")
	public String showEventsPage(Model model) throws SQLException {
		EventDAO e_dao = new EventDAO();
		List<Event> allEvents = e_dao.getAllEvents();
		model.addAttribute("allEvents", allEvents);
		return "EventsPage";
	}

	@PostMapping("/createEvent")
	public String createEvent(@RequestParam String title, @RequestParam String description,
			@RequestParam String location, @RequestParam String dateTimeString, HttpSession session)
			throws ClassNotFoundException, SQLException, IOException {
		LocalDateTime dateTime = (LocalDateTime.parse(dateTimeString));
		Event event = new Event();
		event.setTitle(title);
		event.setDescription(description);
		event.setLocation(location);
		event.setDateTime(dateTime);
		Member currentMember = (Member) session.getAttribute("currentMember");
		event.setMemberId(currentMember.getMemberId());

		EventDAO e_dao = new EventDAO();
		event.setEventId(e_dao.createEvent(event));
		System.out.println(event.toString());

		return "redirect:/showEventsPage";
	}

	@GetMapping("/deleteEvent")
	public String deleteEvent(@RequestParam Integer eventId) throws IOException, SQLException {
		EventDAO e_dao = new EventDAO();
		e_dao.removeEvent(eventId);

		return "redirect:/showEventsPage";
	}
}
