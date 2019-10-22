package com.perscholas.junit.sba6;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	// Global variables
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	//****************cleanUp() method*****************
	public void cleanUp() throws SQLException {
		if (conn != null)
			conn.close();
		if (stmt != null)
			stmt.close();
		if (rs != null)
			rs.close();
	} // End of cleanUp() method
	
	// ****************testConnection() method*****************
	public Boolean testConnection() {
		DBConnection dbConn = new DBConnection();
		try {
			dbConn.getConnection();
			System.out.println("testConnection succeed");
		} catch (Exception e) {
			System.out.println("testConnection failed.");
		}
		return true;
	} // End of testConnection() method

	// ****************getAll() method*****************
	public List<User> getAll() throws SQLException, InvalidPasswordException {
		// Declare variables
		Statement stmt = null;
		User u = null;
		List<User> userList = null;

		// Assign query string to a string
		String qString = "SELECT * FROM user;";

		// Create MySqlConnection class instance
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
			// Create list to hold User objects
			userList = new ArrayList<User>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new user
				u = new User();
				// Assign columns/fields to related fields in the User object
				// 1,2 and 3 represent column numbers/positions
				u.setUserId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setJavaScore(rs.getDouble(4));
				u.setSqlScore(rs.getDouble(5));

				// Add the user to the list
				userList.add(u);
				// Repeat until rs.next() returns false (i.e., end of ResultSet)
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		} finally {
			if (stmt != null)
				stmt.close();
		}
		return userList;
	} // End of getAll() method

	// ****************register() method*****************
	public Integer register(User user) throws SQLException, ClassNotFoundException, IOException {
		// Assign insert statement string to variable
		String insertString = "INSERT INTO `user` (`name`, `password`, `javaScore`, `sqlScore`) VALUES (?, ?, ?, ?);";

		int ID = -1;
		String[] COL = { "`userId`" };

		DBConnection dbConn = new DBConnection();

		try {
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(insertString, COL);

			stmt.setString(1, user.getName());
			stmt.setString(2, user.getPassword());
			stmt.setDouble(3, user.getJavaScore());
			stmt.setDouble(4, user.getSqlScore());

			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				ID = rs.getInt(1);
			}
			System.out.println(ID);
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}

		return ID;
	} // End of register() method

	// ****************getById() method*****************
	public User getByID(int userId) throws ClassNotFoundException, IOException, SQLException, InvalidPasswordException {
		// Declare variables
		User u = null;

		// Assign query string to variable
		String qString = "SELECT * FROM `user` WHERE `userId` = ?;";

		// Create MySqlConnection class instance
		DBConnection dbConn = new DBConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setInt(1, userId); // user_id if from String parameter passed to method

			// Run query and assign to ResultSet
			rs = stmt.executeQuery();

			// Retrieve ResultSet and assign to new User
			if (rs.next()) {
				u = new User();
				u.setUserId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setJavaScore(rs.getDouble(4));
				u.setSqlScore(rs.getDouble(5));
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		}
		return u;
	} // End of getById() method

	// ****************getByName or login method*****************
	public User getByName(String name)
			throws ClassNotFoundException, IOException, SQLException, InvalidPasswordException {
		// Declare variables
		User u = null;

		// Assign query string to variable
		String qString = "SELECT * FROM `user` WHERE `name` = ?;";

		// Create MySqlConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setString(1, name); // ID if from String parameter passed to method
			// Run query and assign to ResultSet
			rs = stmt.executeQuery();
			// Retrieve ResultSet and assign to new User
			if (rs.next()) {
				u = new User();
				u.setUserId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setJavaScore(rs.getDouble(4));
				u.setSqlScore(rs.getDouble(5));
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
			System.out.println(e.getStackTrace());
		}
		return u;
	} // End of getByName() method

	// ****************update() method*****************
	public Boolean updateUser(User u) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Integer updateResult = null;

		// Assign update string to variable
		String updateString = "UPDATE `user` SET `name` = ?, `password` = ?,"
				+ " `javaScore` = ?, `sqlScore` = ? WHERE `userId` = ?;";

		// Create MySqlConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(updateString);

			// Set query parameters (?)
			stmt.setString(1, u.getName());
			stmt.setString(2, u.getPassword());
			stmt.setDouble(3, u.getJavaScore());
			stmt.setDouble(4, u.getSqlScore());
			stmt.setInt(5, u.getUserId());
			// Run query and assign to ResultSet
			updateResult = stmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		if (updateResult > 0)
			return true;
		return false;
	} // End of update() method

	// ****************remove() method (i.e., delete)*****************
	public Boolean removeUser(int userId) throws IOException, SQLException {
		// Declare variables
		Integer updateResult = null;

		// Assign delete string to variable
		String deleteString = "DELETE FROM `user` WHERE userId = ?;";

		// Create MySqlConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(deleteString);

			// Set query parameters (?)
			stmt.setInt(1, userId);
			// Run query and assign to ResultSet
			updateResult = stmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error: " + e.getMessage());
		}
		if (updateResult > 0)
			return true;
		return false;
	}

}
