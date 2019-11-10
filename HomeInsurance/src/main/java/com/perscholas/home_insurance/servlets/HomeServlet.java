package com.perscholas.home_insurance.servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perscholas.home_insurance.daos.HomeDAO;
import com.perscholas.home_insurance.daos.QuoteDAO;
import com.perscholas.home_insurance.daos.UserDAO;
import com.perscholas.home_insurance.models.Home;
import com.perscholas.home_insurance.models.Quote;
import com.perscholas.home_insurance.models.User;

@WebServlet({ "/HomeServlet", "/HomeServlet/*" })
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = null;
		String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();

		if (pathInfo == null || pathInfo.equals("/")) {
			action = servletPath;
		} else {
			action = servletPath + pathInfo;
		}
		// Verify the action string by printing to the console
		System.out.println(action);

		try {
			switch (action) {
			case "/HomeServlet":
				showLogin(request, response);
				break;
			case "/HomeServlet/loginUser":
				loginUser(request, response);
				break;
			case "/HomeServlet/showWelcomePage":
				showWelcomePage(request, response);
				break;
			case "/HomeServlet/showRegistration":
				showRegistration(request, response);
				break;
			case "/HomeServlet/registerUser":
				registerUser(request, response);
				break;
			case "/HomeServlet/showCreateQuote":
				showCreateQuote(request, response);
				break;
			case "/HomeServlet/createHome":
				createHome(request, response);
			case "/HomeServlet/showYearlyPremium":
				showYearlyPremium(request, response);
			case "/HomeServlet/createQuote":
				createQuote(request, response);
			case "/HomeServlet/showConfirmation":
				showConfirmation(request, response);
			case "/HomeServlet/logout":
				logout(request, response);
				break;
			default:
				showLogin(request, response);
				break;
			}
		} catch (IOException | ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void showLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
	}

	private void loginUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		UserDAO u_dao = new UserDAO();
		User u = u_dao.getByUsername(username);

		if (u != null) {
			if (password.equals(u.getPassword())) {
				session.setAttribute("currentUser", u);
				request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp").forward(request, response);
			} else {
				request.setAttribute("errorMessage", "Invalid password");
				request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("errorMessage", "Invalid username");
			request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
		}
	}

	private void showWelcomePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp").forward(request, response);
	}

	private void showRegistration(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/Registration.jsp").forward(request, response);
	}

	private void registerUser(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException, ServletException {
		String fName = request.getParameter("firstName");
		String lName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String dobStr = request.getParameter("dob");
		Date dob = Date.valueOf(dobStr);

		User u = new User();
		u.setFirstName(fName);
		u.setLastName(lName);
		u.setEmail(email);
		u.setUsername(username);
		u.setPassword(password);
		u.setDob(dob);

		UserDAO u_dao = new UserDAO();
		u_dao.register(u);
		request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
	}

	private void showCreateQuote(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/CreateQuote.jsp").forward(request, response);
	}

	private void createHome(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipCode = request.getParameter("zipCode");
		String yearBuilt = request.getParameter("yearBuilt");
		String homeValue = request.getParameter("homeValue");

		Home h = new Home();
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("currentUser");

		h.setUserId(u.getUserId());
		h.setAddress1(addr1);
		h.setAddress2(addr2);
		h.setCity(city);
		h.setState(state);
		h.setZip(Integer.valueOf(zipCode));
		h.setYearBuilt(Integer.valueOf(yearBuilt));
		h.setHomeValue(Double.valueOf(homeValue));

		HomeDAO h_dao = new HomeDAO();
		h.setHomeId(h_dao.create(h));
		session.setAttribute("home", h);
		request.getRequestDispatcher("/HomeServlet/showYearlyPremium").forward(request, response);
	}

	private void showYearlyPremium(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/YearlyPremium.jsp").forward(request, response);
	}

	private void createQuote(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException, ServletException {
		HttpSession session = request.getSession();
		Home h = (Home) session.getAttribute("home");
		Quote q = new Quote();

		q.setHomeId(h.getHomeId());
		q.setYearlyPremium(h.getHomeValue() * .05);
		q.setStartDate(new Date(System.currentTimeMillis()));
		Calendar c = Calendar.getInstance();
		c.setTime(c.getTime());
		c.add(Calendar.YEAR, 1);
		q.setExpiration(new Date(c.getTimeInMillis()));
		q.setActive(true);

		QuoteDAO q_dao = new QuoteDAO();
		q_dao.register(q);
		request.getRequestDispatcher("/HomeServlet/showConfirmation").forward(request, response);
	}

	private void showConfirmation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/Confirmation.jsp").forward(request, response);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("/HomeServlet").forward(request, response);
	}
}