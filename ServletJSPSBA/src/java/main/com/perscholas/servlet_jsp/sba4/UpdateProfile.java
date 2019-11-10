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

@WebServlet("/UpdateProfile")
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("uid", request.getParameter("uid"));
		request.getRequestDispatcher("WEB-INF/views/UpdateProfile.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String uid = request.getParameter("uid");

		User user = new User(Integer.parseInt(uid), username, password);
		UserDAO udao = new UserDAO();

		try {
			udao.updateUser(user);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("WEB-INF/views/sba4.jsp").forward(request, response);
	}

}
