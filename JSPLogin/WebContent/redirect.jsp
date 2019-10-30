<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Redirect</title>
</head>
<body>
	<%
		if (request.getParameter("login") != null) {
			String loginUN = null, loginPass = null;
			boolean unt = false, passt = false;

			Cookie[] cookies = request.getCookies();
			for (Cookie c : cookies) {
				if (c.getName().equals("username")) {
					unt = true;
					loginUN = c.getValue();
					//System.out.println("if1");
				}
				if (c.getName().equals("password")) {
					passt = true;
					loginPass = c.getValue();
					//System.out.println("if2");
				}
			}

			if (unt && passt)
				request.getRequestDispatcher("success.jsp").forward(request, response);
			else {
				//System.out.println("else");
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
				request.getRequestDispatcher("register.jsp").forward(request, response);
			} else {
				session.setAttribute("users", fn + " " + ln);
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
	%>
</body>
</html>