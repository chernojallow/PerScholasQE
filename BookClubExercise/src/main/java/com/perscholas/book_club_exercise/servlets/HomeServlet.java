package com.perscholas.book_club_exercise.servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.perscholas.book_club_exercise.daos.BookDAO;
import com.perscholas.book_club_exercise.daos.MemberDAO;
import com.perscholas.book_club_exercise.models.Book;
import com.perscholas.book_club_exercise.models.Member;

@WebServlet({ "/HomeServlet", "/HomeServlet/*" })
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
				showLogin(request, response);
				break;
			case "/HomeServlet/loginMember":
				loginMember(request, response);
				break;
			case "/HomeServlet/showWelcomePage":
				showWelcomePage(request, response);
				break;
			case "/HomeServlet/showRegistration":
				showRegistration(request, response);
				break;
			case "/HomeServlet/registerMember":
				registerMember(request, response);
				break;
			case "/HomeServlet/showBooksPage":
				showBooksPage(request, response);
				break;
			case "/HomeServlet/createBook":
				createBook(request, response);
				break;
			case "/HomeServlet/logout":
				logout(request, response);
				break;
			default:
				showLogin(request, response);
				break;
			}
		} catch (IOException | ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void showLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
	}

	private void loginMember(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, ClassNotFoundException, SQLException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		MemberDAO m_dao = new MemberDAO();
		Member m = m_dao.getByName(name);

		if (m != null) {
			if (password.equals(m.getPassword())) {
				session.setAttribute("currentMember", m);
				request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp").forward(request, response);
			} else {
				request.setAttribute("errorMessage", "Invalid password");
				request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
			}
		} else {
			request.setAttribute("errorMessage", "Invalid name");
			request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
		}
	}

	private void showWelcomePage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/Welcome.jsp").forward(request, response);
	}

	private void showRegistration(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Registration.jsp");
		rd.forward(request, response);
	}

	private void registerMember(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException, ServletException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String fGenre = request.getParameter("fGenre");

		Member m = new Member();
		m.setName(name);
		m.setEmail(email);
		m.setPassword(password);
		m.setfGenre(fGenre);

		MemberDAO m_dao = new MemberDAO();
		System.out.println(m_dao.register(m));

		request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
	}

	private void showBooksPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		BookDAO b_dao = new BookDAO();
		List<Book> bookList = b_dao.getAll();
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("/WEB-INF/views/BooksPage.jsp").forward(request, response);
	}

	private void createBook(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, IOException, ServletException {
		HttpSession session = request.getSession();

		String title = request.getParameter("title");
		String synopsis = request.getParameter("synopsis");
		String author = request.getParameter("author");
		String pDateString = request.getParameter("pDate");
		Date pDate = (Date.valueOf(pDateString));

		Book book = new Book();
		book.setTitle(title);
		book.setSynopsis(synopsis);
		book.setAuthor(author);
		book.setpDate(pDate);
		Member currentMember = (Member) session.getAttribute("currentMember");
		book.setMemberID(currentMember.getMemberID());
		
		BookDAO b_dao = new BookDAO();
		b_dao.register(book);

		request.getRequestDispatcher("/HomeServlet/showBooksPage").forward(request, response);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("/HomeServlet").forward(request, response);
	}
}