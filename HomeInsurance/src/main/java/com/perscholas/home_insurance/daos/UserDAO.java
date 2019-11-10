package com.perscholas.home_insurance.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.perscholas.home_insurance.models.User;

public class UserDAO {
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

	// ****************register() method*****************
	public Integer register(User user) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign insert statement string to variable
		String insertString = "INSERT INTO `users` (`firstName`, `lastName`, `email`, `username`, "
				+ "`password`, `dob`) VALUES (?, ?, ?, ?, ?, ?);";

		int ID = -1;
		String[] COL = { "`userId`" };

		DBConnection dbConn = new DBConnection();

		try {
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(insertString, COL);

			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getUsername());
			stmt.setString(5, user.getPassword());
			stmt.setDate(6, user.getDob());

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

	// ****************getByUsername or login method*****************
	public User getByUsername(String username) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		User u = null;

		// Assign query string to variable
		String qString = "SELECT * FROM `users` WHERE `username` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setString(1, username); // ID if from String parameter passed to method
			// Run query and assign to ResultSet
			rs = stmt.executeQuery();
			// Retrieve ResultSet and assign to new object
			if (rs.next()) {
				u = new User();
				u.setUserId(rs.getInt(1));
				u.setFirstName(rs.getString(2));
				u.setLastName(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setUsername(rs.getString(5));
				u.setPassword(rs.getString(6));
				u.setDob(rs.getDate(7));
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
		return u;
	} // End of getByName() method

	// ****************DAOTesting() method*****************
	public static void DAOTesting() throws ClassNotFoundException, IOException, SQLException {
		UserDAO u_dao = new UserDAO();
		u_dao.testConnection();

		System.out.println("getByUsername()");
		System.out.println(u_dao.getByUsername("xiaolin").toString());

		System.out.println("register()");
		User u = new User();

		u.setFirstName("Chen");
		u.setLastName("Li");
		u.setEmail("chenli@gmail.com");
		u.setUsername("chenli123");
		u.setPassword("chenlipass");
		u.setDob(new Date(System.currentTimeMillis()));

		System.out.println(u_dao.register(u));

	}

//	// ****************main() method testing*****************
//	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
//		DAOTesting();
//	} // End of main() method
}
