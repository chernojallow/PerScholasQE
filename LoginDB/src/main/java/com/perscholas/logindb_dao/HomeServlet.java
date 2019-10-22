package com.perscholas.logindb_dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perscholas.logindb_models.Login;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get data from login.jsp
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		boolean redirect = true;
		
		// Test database connection
		LoginDAO l_dao = new LoginDAO();
		l_dao.testConnection();
		
		// Get data from database
		List<Login> loginList = null;
		try {
			loginList = l_dao.getAllLogins();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Compare credentials
		for (Login login:loginList) {
			// If credentials are in the database, redirect to welcome page
			if (username.equals(login.getUsername()) && password.equals(login.getPassword())) {
				response.sendRedirect(request.getContextPath()+"/welcome.jsp");
				redirect = true;
			}
			else redirect = false;
		}
		
		if (redirect == false)
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		
		doGet(request, response);
	}

}
