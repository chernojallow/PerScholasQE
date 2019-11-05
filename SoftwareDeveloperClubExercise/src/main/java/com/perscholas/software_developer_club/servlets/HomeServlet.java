package com.perscholas.software_developer_club.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perscholas.software_developer_club.dao.EventDAO;
import com.perscholas.software_developer_club.dao.MemberDAO;
import com.perscholas.software_developer_club.dao.SignupDAO;
import com.perscholas.software_developer_club.models.Event;
import com.perscholas.software_developer_club.models.Member;

@WebServlet({"/HomeServlet", "/HomeServlet/*"})
public class HomeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		/* The action string will be assigned the URL route and determine which 
		 * servlet method gets called by using a switch block. */
		String action = null;
		String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();
		
		/* If there are no characters after the servlet path (pathInfo will be 
		 * null) or if the servlet path is followed by a single "/" then the action 
		 * string will be assigned only the servlet path. If there is a slash 
		 * followed by any characters, then the action string will be assigned the 
		 * servlet path plus the additional path information. */
		if (pathInfo == null || pathInfo.equals("/")) {
			action = servletPath;
		} else {
			action = servletPath + pathInfo;
		}
		// Verify the action string by printing to the console
		System.out.println(action);
		
		try
		{
			switch(action) {
				case "/HomeServlet":
					showLogin(request, response);
					break;
				case "/HomeServlet/loginMember":
					loginMember(request, response);
					break;
				case "/HomeServlet/showWelcomePage":
					showWelcomePage(request, response);
					break;
				case "/HomeServlet/showRegistration":
					showRegistration(request, response);
					break;
				case "/HomeServlet/registerMember":
					registerMember(request, response);
					break;
				case "/HomeServlet/showEventsPage":
					showEventsPage(request, response);
					break;
				case "/HomeServlet/createEvent":
					createEvent(request, response);
					break;
				case "/HomeServlet/signupForEvent":
					signupForEvent(request, response);
					break;
				case "/HomeServlet/cancelSignup":
					cancelSignup(request, response);
					break;
				case "/HomeServlet/deleteEvent":
					deleteEvent(request, response);
					break;
				case "/HomeServlet/showProfile":
					showProfile(request, response);
					break;
				case "/HomeServlet/showUpdatePage":
					showUpdatePage(request, response);
					break;
				case "/HomeServlet/logout":
					logout(request, response);
					break;
				default:
					showLogin(request, response);
					break;
			}
		}
		catch(IOException | SQLException | ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
	private void showLogin(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/LoginPage.jsp");
		rd.forward(request, response);
	}
	private void loginMember(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		
		MemberDAO m_dao = new MemberDAO();
		Member m = m_dao.getMemberByName(name);
		
		if (m != null ) {
			if (password.equals(m.getPassword())) {
				session.setAttribute("currentMember", m);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("errorMessage", "Invalid login-password");
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/LoginPage.jsp");
				rd.forward(request, response);
			}
		} else {
			request.setAttribute("errorMessage", "Invalid login-user name");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/LoginPage.jsp");
			rd.forward(request, response);
		}
	}
	private void showWelcomePage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp");
		rd.forward(request, response);
	}
	private void showRegistration(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/RegistrationPage.jsp");
		rd.forward(request, response);
	}
	private void registerMember(HttpServletRequest request, HttpServletResponse response) 
			throws ClassNotFoundException, SQLException, IOException, ServletException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String favoriteLanguage = request.getParameter("favoriteLanguage");
		
		Member m = new Member();
		m.setName(name);
		m.setEmail(email);
		m.setPassword(password);
		m.setFavoriteLanguage(favoriteLanguage);
		
		MemberDAO m_dao = new MemberDAO();
		Integer i = m_dao.registerMember(m);
		System.out.println(i);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/LoginPage.jsp");
		rd.forward(request, response);
	}
	private void showEventsPage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException {
		
		EventDAO e_dao = new EventDAO();
		List<Event> allEvents = e_dao.getAllEvents();
		request.setAttribute("allEvents", allEvents);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/EventsPage.jsp");
		rd.forward(request, response);
	}
	private void createEvent(HttpServletRequest request, HttpServletResponse response) 
			throws ClassNotFoundException, SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String location = request.getParameter("location");
		String dateTimeString = request.getParameter("dateTime");
		LocalDateTime ldt = (LocalDateTime.parse(dateTimeString));
		
		Event event = new Event();
		event.setTitle(title);
		event.setDescription(description);
		event.setLocation(location);
		event.setDateTime(ldt);
		Member currentMember = (Member)session.getAttribute("currentMember");
		event.setMemberId(currentMember.getMemberId());
		
		EventDAO e_dao = new EventDAO();
		e_dao.createEvent(event);
		
		RequestDispatcher rd = request.getRequestDispatcher("/HomeServlet/showEventsPage");
		rd.forward(request, response);
	}
	private void signupForEvent(HttpServletRequest request, HttpServletResponse response) 
			throws ClassNotFoundException, SQLException, IOException, ServletException {
		Integer memberId = Integer.parseInt(request.getParameter("memberId"));
		Integer eventId = Integer.parseInt(request.getParameter("eventId"));
		System.out.println(memberId + ", " + eventId);
		
		SignupDAO s_dao = new SignupDAO();
		s_dao.signupForEvent(memberId, eventId);
		
		RequestDispatcher rd = request.getRequestDispatcher("/HomeServlet/showEventsPage");
		rd.forward(request, response);
	}
	private void cancelSignup(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException {
		Integer memberId = Integer.parseInt(request.getParameter("memberId"));
		Integer eventId = Integer.parseInt(request.getParameter("eventId"));
		System.out.println(memberId + ", " + eventId);
		
		SignupDAO s_dao = new SignupDAO();
		s_dao.cancelSignup(memberId, eventId);
		
		RequestDispatcher rd = request.getRequestDispatcher("/HomeServlet/showEventsPage");
		rd.forward(request, response);
	}
	private void deleteEvent(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, SQLException, ServletException {
		Integer eventId = Integer.parseInt(request.getParameter("eventId"));
		EventDAO e_dao = new EventDAO();
		e_dao.removeEvent(eventId);
		RequestDispatcher rd = request.getRequestDispatcher("/HomeServlet/showEventsPage");
		rd.forward(request, response);
	}
	private void showProfile(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/MemberProfile.jsp");
		rd.forward(request, response);
	}
	
	private void showUpdatePage(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/MemberUpdate.jsp");
		rd.forward(request, response);
	}
	private void logout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("/HomeServlet");
		rd.forward(request, response);
	}
}