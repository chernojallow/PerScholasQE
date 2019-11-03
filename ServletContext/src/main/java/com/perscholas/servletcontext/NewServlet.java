package com.perscholas.servletcontext;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NewServlet")
public class NewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;

	public void init(ServletConfig config) throws ServletException {
		context = config.getServletContext();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.getWriter().append("\n" + context.getAttribute("contextAttribute1"));

		/* This method removes the context attribute from the context */
		context.removeAttribute("contextAttribute1");
	}
}