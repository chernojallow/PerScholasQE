<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Redirect</title>
</head>
<body>
	<%	String fn = request.getParameter("regFirstName");
		String ln = request.getParameter("regLastName");
		String email = request.getParameter("regEmail");
		String dob = request.getParameter("regDOB");
		String un = request.getParameter("regUsername");
		String pass = request.getParameter("regPassword");
		String cpass = request.getParameter("regConfirmPassword"); 
		
		if (fn == null || ln == null || email == null || dob == null || un == null || pass == null || cpass == null) {
			request.setAttribute("regError", "Register unsuccessful.");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else if (pass != cpass) {
			request.setAttribute("regError", "Register unsuccessful.");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		else {
			request.setAttribute("regSuccess", "Register successful.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		
		//if (pass.equals(cpass) || !pass.equals(null)) {
		//	session.setAttribute("sessionVar", fn + " " + ln + " " + "User");
		//}
		
		%>
</body>
</html>