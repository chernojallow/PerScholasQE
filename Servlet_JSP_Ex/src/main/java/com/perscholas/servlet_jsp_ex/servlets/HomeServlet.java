package com.perscholas.servlet_jsp_ex.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("login") != null) {
			String loginUN = null, loginPass = null;
			boolean unt = false, passt = false;

			Cookie[] cookies = request.getCookies();
			for (Cookie c : cookies) {
				if (c.getName().equals("username")) {
					unt = true;
					loginUN = c.getValue();
					// System.out.println("if1");
				}
				if (c.getName().equals("password")) {
					passt = true;
					loginPass = c.getValue();
					// System.out.println("if2");
				}
			}

			if (unt && passt)
				request.getRequestDispatcher("WEB-INF/views/success.jsp").forward(request, response);
			else {
				// System.out.println("else");
				request.setAttribute("loginError", "Login unsuccessful.");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}

		if (request.getParameter("register") != null) {
			String fn = request.getParameter("regFirstName");
			String ln = request.getParameter("regLastName");
			String email = request.getParameter("regEmail");
			String dob = request.getParameter("regDOB");
			String un = request.getParameter("regUsername");
			String pass = request.getParameter("regPassword");
			String cpass = request.getParameter("regConfirmPassword");

			if (!pass.equals(cpass)) {
				request.setAttribute("regError", "Register unsuccessful.");
				request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request, response);
			} else {
				Cookie fnCookie = new Cookie("firstName", fn);
				Cookie lnCookie = new Cookie("lastName", ln);
				Cookie emailCookie = new Cookie("email", email);
				Cookie dobCookie = new Cookie("dob", dob);
				Cookie unCookie = new Cookie("username", un);
				Cookie passCookie = new Cookie("password", pass);

				fnCookie.setMaxAge(60 * 2);
				lnCookie.setMaxAge(60 * 2);
				emailCookie.setMaxAge(60 * 2);
				dobCookie.setMaxAge(60 * 2);
				unCookie.setMaxAge(60 * 2);
				passCookie.setMaxAge(60 * 2);

				response.addCookie(fnCookie);
				response.addCookie(lnCookie);
				response.addCookie(emailCookie);
				response.addCookie(dobCookie);
				response.addCookie(unCookie);
				response.addCookie(passCookie);

				request.setAttribute("regSuccess", "Register successful.");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		
//		if (request.getParameter("ahref") != null) {
//			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/register.jsp");
//			rd.forward(request, response);
//		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
