package com.perscholas.casestudy.rms.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.casestudy.rms.models.Category;

public class CategoryDAO {
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
	public List<Category> getAll() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Category c = null;
		List<Category> categoryList = null;

		// Assign query string to a string
		String qString = "SELECT * FROM category;";
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
			categoryList = new ArrayList<Category>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new object
				c = new Category();
				// Assign columns/fields to related fields in the object
				// Represent column numbers/positions
				c.setCategoryId(rs.getInt(1));
				c.setCategoryName(rs.getString(2));
				// Add the user to the list
				categoryList.add(c);
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
		return categoryList;
	} // End of getAll() method

	// ****************create() method*****************
	public Integer create(Category category) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign insert statement string to variable
		String insertString = "INSERT INTO category (`categoryName`) VALUES (?);";

		int ID = -1;
		String[] COL = { "`categoryId`" };

		DBConnection dbConn = new DBConnection();

		try {
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(insertString, COL);

			stmt.setString(1, category.getCategoryName());

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				ID = rs.getInt(1);
			}
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
	} // End of create() method

	// ****************getById() method*****************
	public Category getById(Integer categoryId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Category c = null;

		// Assign query string to variable
		String qString = "SELECT * FROM category WHERE `categoryId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setInt(1, categoryId); // ID if from String parameter passed to method

			// Run query and assign to ResultSet
			rs = stmt.executeQuery();

			// Retrieve ResultSet and assign to new object
			if (rs.next()) {
				c = new Category();
				c.setCategoryId(rs.getInt(1));
				c.setCategoryName(rs.getString(2));
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
		return c;
	} // End of getById() method

	// ****************update() method*****************
	public Boolean update(Category c) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign update string to variable
		String updateString = "UPDATE category SET `categoryName` = ? WHERE `categoryId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(updateString);

			// Set query parameters (?)
			stmt.setString(1, c.getCategoryName());
			stmt.setInt(2, c.getCategoryId());
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
	public Boolean remove(Integer categoryId) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign delete string to variable
		String deleteString = "DELETE FROM category WHERE `categoryId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(deleteString);

			// Set query parameters (?)
			stmt.setInt(1, categoryId);
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
	public static void DAOTesting() throws ClassNotFoundException, IOException, SQLException {
		CategoryDAO c_dao = new CategoryDAO();
		c_dao.testConnection();
		System.out.println();

		Category c = new Category();
		c.setCategoryName("categoryE");
		c.setCategoryId(c_dao.create(c));
		System.out.println("create()\n" + c.toString());
		System.out.println();

		List<Category> cList = c_dao.getAll();
		System.out.println("getAll()");
		for (Category c1 : cList)
			System.out.println(c1.toString());
		System.out.println();

		c = new Category(1, "categoryNameEU");
		if (c_dao.update(c))
			System.out.println("update()\n" + c.toString());
		else
			System.out.println("update() failed");
		System.out.println();

		c = c_dao.getById(1);
		System.out.println("getById()\n" + c.toString());
		System.out.println();

		c = c_dao.getById(2);
		if (c_dao.remove(2))
			System.out.println("remove()\n" + c.toString());
		else
			System.out.println("remove() failed");
	} // End of DAOTesting() method

//	// ****************main() method testing*****************
//	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
//		DAOTesting();
//	} // End of main() method
}
