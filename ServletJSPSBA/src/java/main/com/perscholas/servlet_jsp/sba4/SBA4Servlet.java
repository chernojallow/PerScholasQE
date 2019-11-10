package com.perscholas.servlet_jsp.sba4;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.perscholas.servlet_jsp.sba3.User;
import com.perscholas.servlet_jsp.sba3.UserDAO;

@WebServlet("/SBA4Servlet")
public class SBA4Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/sba4.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDAO udao = new UserDAO();
		User user = null;

		try {
			user = udao.findUserByName(username);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (user.getPassword().equals(password)) {
			request.setAttribute("uid", user.getUserId());
			request.setAttribute("username", user.getUserName());
			request.setAttribute("password", user.getPassword());
			request.getRequestDispatcher("WEB-INF/views/UserProfile.jsp").forward(request, response);
		} else {
			doGet(request, response);
		}
	}
}
