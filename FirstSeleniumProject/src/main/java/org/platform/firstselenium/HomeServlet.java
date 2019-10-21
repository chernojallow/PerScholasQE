package org.platform.firstselenium;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append(
				"<!DOCTYPE html/>"
				+ "<html>"
				+ "<head><title>Hello Selenium</title></head>"
				+ "<body><h1>Hello Selenium!</h1></body>"
				+ "</html>");
	}

}
