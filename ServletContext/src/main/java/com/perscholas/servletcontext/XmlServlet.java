package com.perscholas.servletcontext;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String initParamExample;
	private String contextParamExample;
	private ServletContext context;

	@Override
	public void init(ServletConfig config) throws ServletException {
		initParamExample = config.getInitParameter("servlet_init_param");
		contextParamExample = config.getServletContext().getInitParameter("context_param_example");
		/*
		 * The context object needs to be read inside the init() method since the
		 * ServletConfig object is available only inside this method. The ServletContext
		 * context is declared as a class variable to make it available across other
		 * methods in the servlet.
		 */
		context = config.getServletContext();
		context.setAttribute("contextAttribute1",
				"<html><body><h2>Context Attribute 1</h2><p>This long string, "
						+ "including the title above, is a context attribute that was "
						+ "set in the init method, but could have also been set in any "
						+ "other method in the servlet. It is being accessed in the "
						+ "doGet method and printed out to the web browswer as part "
						+ "of the response. This attribute is also available to all "
						+ "other servlets in the context (i.e., web application)" + "</p></body></html>");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");

		response.getWriter().append("Served at: ").append(request.getContextPath()).append("</br>" + initParamExample)
				.append("</br>" + contextParamExample).append("</br>" + context.getAttribute("contextAttribute1"));
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		doGet(request, response);
	}
}