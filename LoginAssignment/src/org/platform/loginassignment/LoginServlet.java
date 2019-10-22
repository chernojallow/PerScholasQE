package org.platform.loginassignment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// Get data from reg.jsp
		String name = request.getParameter("Name");
		String email = request.getParameter("Email");
		String gender = request.getParameter("Gender");
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		String regUsername = request.getParameter("regUsername");
				
		// New window on browser displaying welcoming page
		PrintWriter writer = response.getWriter();
		String fpage = "<!DOCTYPE html><html>";
		fpage += "<head><meta charset='ISO-8859-1'>";
		fpage += "<title>Weclome Page</title></head>";
		fpage += "<body>";
		fpage += "<header><h1>Welcome!</h1></header>";
		fpage += "<h2>" + username + "</h2>";
		fpage += "<h2>Name = " + name + "</h2>";
		fpage += "<h2>Email = " + email + "</h2>";
		fpage += "<h2>Gender = " + gender + "</h2>";
		fpage += "<h2>Username = " + regUsername + "</h2>";
		fpage += "<h2>Password = " + password + "</h2>";
		fpage += "</body>";
		fpage += "</html>";
		writer.println(fpage);
				
		writer.close();

		doGet(request, response);
	}

}
