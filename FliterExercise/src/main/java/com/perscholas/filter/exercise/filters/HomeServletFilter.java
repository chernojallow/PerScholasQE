package com.perscholas.filter.exercise.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/HomeServlet/SecurePage")
public class HomeServletFilter implements Filter {
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		System.out.println("Key in filter: " + req.getParameter("key"));
		String key = req.getParameter("key");
		if (key != null && key.equals("querty"))
			chain.doFilter(request, response);
		else {
			response.setContentType("text/html");
			response.getWriter().append("<h1>Your link did not include correct key. Access Denied.</h1>" +
			"<a href='/Welcome.jsp'>Click to go back to Welcome Page</a>");
		}
	}
}
