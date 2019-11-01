package com.platform.sessionManagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Product product = new Product();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		product.setProductId(1);
		product.setProductName("Phone");
		product.setProductDescription("New xPhone 50");

	}

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("productName");
		String description = request.getParameter("productDescription");
		String id = request.getParameter("productId");

		product.setProductName(name);
		product.setProductDescription(description);

		System.out.println("Product ID " + product.getProductId() + " updated to:" + "\nName: "
				+ product.getProductName() + "\nDescription: " + product.getProductDescription());

	}

}
