package org.platform.loginassignment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		String cPassword = request.getParameter("ConfirmPassword");
		
		// Check if anything is empty or passwords didn't match
		if(name.isEmpty() || email.isEmpty() || gender.isEmpty() || username.isEmpty() || password.isEmpty() || 
				cPassword.isEmpty() || !password.contentEquals(cPassword)) {
			
			if(name.isEmpty())
				System.out.println("Name can't be empty");
			else if (email.isEmpty())
				System.out.println("Email can't be empty");
			else if (gender.isEmpty())
				System.out.println("Gender can't be empty");
			else if (username.isEmpty())
				System.out.println("Username can't be empty");
			else if (password.isEmpty() || cPassword.isEmpty())
				System.out.println("Password can't be empty");
			else System.out.println("Passwords didn't match");
			
			// Redirect to reg.jsp
			response.sendRedirect(request.getContextPath()+"/reg.jsp");
			
		}
		else {
			// Print data for passing
			System.out.println("RegServlet");
			System.out.println("Name = " + name);
			System.out.println("Email = " + email);
			System.out.println("Gender = " + gender);
			System.out.println("Username = " + username);
			System.out.println("Password = " + password);

			// Pass data to login.jsp
			request.setAttribute("regUsername", username);
			request.setAttribute("Password", password);
			request.setAttribute("Email", email);
			request.setAttribute("Gender", gender);
			request.setAttribute("Name", name);
			
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

		doGet(request, response);
	}

}
