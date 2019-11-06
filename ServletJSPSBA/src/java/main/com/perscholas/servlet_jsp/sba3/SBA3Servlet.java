package com.perscholas.servlet_jsp.sba3;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SBA3Servlet")
public class SBA3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/sba3.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDAO u_dao = new UserDAO();
		User user = null;

		try {
			user = u_dao.findUserByName(username);
			System.out.println("User:" + user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(user);

		if (user.getPassword().equals(password)) {
			request.getRequestDispatcher("WEB-INF/views/welcome3.jsp").forward(request, response);
		} else {
			doGet(request, response);
		}
	}
}
