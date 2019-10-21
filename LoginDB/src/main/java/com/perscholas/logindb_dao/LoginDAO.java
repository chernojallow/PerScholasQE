package com.perscholas.logindb_dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.perscholas.logindb_models.Login;

public class LoginDAO {
	
	public List<Login> getAllLogins() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Login login = null;
		List<Login> loginList = null;
		
		// Assign query string to variable
		String qString = "SELECT * FROM logins;";
		
		// Create MariaDB Connection class instance
		MariaDBConnection mariadb = new MariaDBConnection();
		
		try {
			// Connect database
			conn = mariadb.getConnection();
			
			// If the connection fails the application won't make it to this point
			System.out.println("Connected to database.");
			
			// Create Statement instance/object
			stmt = conn.createStatement();
			// Run query and assign to ResultSet
			rs = stmt.executeQuery(qString);
			//Create list to hold User objects
			loginList = new ArrayList<Login>();
			
			// Read the ResultSet
			while (rs.next()) {
				// Create new login instance in every loop
				login = new Login();
				
				// Get info from database
				login.setUsername(rs.getString(1));
				login.setPassword(rs.getString(2));
				
				// Add the login to the list
				loginList.add(login);
			}
			
		} catch (ClassNotFoundException | IOException | SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
		} finally {
			// Close everything
			if (rs != null)
				rs.close();
			
			if (stmt != null)
				stmt.close();
		
			if (conn != null)
				conn.close();
			
		}
		
		return loginList;
	}
	
	public void testConnection() {
		MariaDBConnection mariadbConnection = new MariaDBConnection();
		try {
			mariadbConnection.getConnection();
		} catch (Exception e){
			System.out.println("Test database connection failed.");
		}
	}
	
	/* Main Method for testing
	public static void main(String[] args) {
		LoginDAO l_dao = new LoginDAO();
		List<Login> loginList = null;
		
		// Test database connection
		l_dao.testConnection();
		
		// Get data from database
		try {
			loginList = l_dao.getAllLogins();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// Print loginList
		for (Login login:loginList)
			System.out.printf("\n\tUsername = %s\n\tPassword = %s\n", login.getUsername(), login.getPassword());
	}
	*/

}
