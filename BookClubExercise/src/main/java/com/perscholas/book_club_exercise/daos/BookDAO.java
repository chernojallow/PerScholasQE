package com.perscholas.book_club_exercise.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.book_club_exercise.models.Book;

public class BookDAO {
	// ****************testConnection() method*****************
	public Boolean testConnection() {
		DBConnection dbConn = new DBConnection();
		try {
			dbConn.getConnection();
			System.out.println("testConnection() succeed");
		} catch (Exception e) {
			System.out.println("testConnection() failed");
			return false;
		}
		return true;
	}

	// ****************getAll() method*****************
	public List<Book> getAll() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Book b = null;
		List<Book> bookList = null;

		// Assign query string to a string
		String qString = "SELECT * FROM book;";
		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database
			conn = dbConn.getConnection();
			// If the connection fails the application won't make it to this point
			// Create Statement instance/object
			stmt = conn.createStatement();

			// Run query and assign to the ResultSet instance
			rs = stmt.executeQuery(qString);
			// Create list to hold objects
			bookList = new ArrayList<Book>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new object
				b = new Book();
				// Assign columns/fields to related fields in the object
				// Represent column numbers/positions
				b.setBookID(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setSynopsis(rs.getString(3));
				b.setAuthor(rs.getString(4));
				b.setpDate(rs.getDate(5));
				b.setMemberID(rs.getInt(6));
				// Add the user to the list
				bookList.add(b);
				// Repeat until rs.next() returns false (i.e., end of ResultSet)
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return bookList;
	} // End of getAll() method

	// ****************register() method*****************
	public Integer register(Book book) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign insert statement string to variable
		String insertString = "INSERT INTO book (`title`, `synopsis`, `author`, `pDate`, `memberID`) VALUES (?, ?, ?, ?, ?);";

		int ID = -1;
		String[] COL = { "`bookID`" };

		DBConnection dbConn = new DBConnection();

		try {
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(insertString, COL);

			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getSynopsis());
			stmt.setString(3, book.getAuthor());
			stmt.setDate(4, book.getpDate());
			stmt.setInt(5, book.getMemberID());

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next())
				ID = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return ID;
	} // End of register() method

	// ****************getByID() method*****************
	public Book getByID(Integer bookID) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Book b = null;

		// Assign query string to variable
		String qString = "SELECT * FROM book WHERE `bookID` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setInt(1, bookID);

			// Run query and assign to ResultSet
			rs = stmt.executeQuery();

			// Retrieve ResultSet and assign to new object
			if (rs.next()) {
				b = new Book();
				b.setBookID(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setSynopsis(rs.getString(3));
				b.setAuthor(rs.getString(4));
				b.setpDate(rs.getDate(5));
				b.setMemberID(rs.getInt(6));
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return b;
	} // End of getByID() method

	// ****************getByName or login method*****************
	public Book getByName(String title) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Book b = null;

		// Assign query string to variable
		String qString = "SELECT * FROM book WHERE `title` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setString(1, title); // ID if from String parameter passed to method
			// Run query and assign to ResultSet
			rs = stmt.executeQuery();
			// Retrieve ResultSet and assign to new object
			if (rs.next()) {
				b = new Book();
				b.setBookID(rs.getInt(1));
				b.setTitle(rs.getString(2));
				b.setSynopsis(rs.getString(3));
				b.setAuthor(rs.getString(4));
				b.setpDate(rs.getDate(5));
				b.setMemberID(rs.getInt(6));
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println(e.getStackTrace());
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		return b;
	} // End of getByName() method

	// ****************update() method*****************
	public Boolean update(Book b) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign update string to variable
		String updateString = "UPDATE book SET `title` = ?, `synopsis` = ?, `author` = ?, `pDate` = ?, `memberID` = ? WHERE `bookID` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(updateString);

			// Set query parameters (?)
			stmt.setString(1, b.getTitle());
			stmt.setString(2, b.getSynopsis());
			stmt.setString(3, b.getAuthor());
			stmt.setDate(4, b.getpDate());
			stmt.setInt(5, b.getMemberID());
			stmt.setInt(6, b.getBookID());
			// Run query and assign to ResultSet
			updateResult = stmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		if (updateResult > 0)
			return true;
		return false;
	} // End of update() method

	// ****************remove() method (i.e., delete)*****************
	public Boolean remove(Integer bookID) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign delete string to variable
		String deleteString = "DELETE FROM book WHERE `bookID` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(deleteString);

			// Set query parameters (?)
			stmt.setInt(1, bookID);
			// Run query and assign to ResultSet
			updateResult = stmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		if (updateResult > 0)
			return true;
		return false;
	}// End of remove() method

	// ****************DAOTesting() method*****************
	public static void DAOTesting() {
		BookDAO b_dao = new BookDAO();
		b_dao.testConnection();

		System.out.println("getByID()");
		try {
			System.out.println(b_dao.getByID(1).toString());
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}

		System.out.println("getByName()");
		try {
			System.out.println(b_dao.getByName("title2").toString());
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}

		System.out.println("register()");
		Book b = new Book();
		b.setTitle("titlemr");
		b.setSynopsis("synopsismr");
		b.setAuthor("authormr");
		b.setpDate(new Date(System.currentTimeMillis()));
		b.setMemberID(1);
		b.setBookID(1);

		try {
			System.out.println(b_dao.getByID(b_dao.register(b)));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("update()");
		b = new Book(1, "titlemu", "synopsismu", "authormu", new Date(System.currentTimeMillis()), 1);

		try {
			if (b_dao.update(b))
				System.out.println(b_dao.getByID(b.getBookID()));
			else
				System.out.println("update failed");
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("remove()");
		try {
			b = b_dao.getByID(3);
			if (b_dao.remove(3))
				System.out.println(b.toString());
			else
				System.out.println("remove failed");
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}

		System.out.println("getAll()");
		try {
			List<Book> blist = b_dao.getAll();
			for (Book b1 : blist)
				System.out.println(b1.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	// ****************main() method testing*****************
//	public static void main(String[] args) {
//		DAOTesting();
//	} // End of main() method

}
