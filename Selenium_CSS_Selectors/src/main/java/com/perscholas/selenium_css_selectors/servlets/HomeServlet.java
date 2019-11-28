package com.perscholas.selenium_css_selectors.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/HomeServlet", "/HomeServlet/*"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Testing Servlet");
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
				showSeleniumCSS(request, response);
				break;
			case "/HomeServlet/showSeleniumCSS2":
				showSeleniumCSS2(request, response);
				break;
			case "/HomeServlet/showSeleniumCSS":
				showSeleniumCSS(request, response);
				break;
			default:
				showSeleniumCSS(request, response);
				break;
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void showSeleniumCSS(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/SeleniumCSS.jsp").forward(request, response);
	}

	private void showSeleniumCSS2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/SeleniumCSS2.jsp").forward(request, response);
	}

}
