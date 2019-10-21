package com.perscholas.sba_dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.sba_models.SBA6Course;

public class SBA6CourseDAO {
	
	public void testConnection() {
		DBConnection mariadbConnection = new DBConnection();
		try {
			mariadbConnection.getConnection();
			System.out.println("Main method test connection");
		} catch (Exception e){
			System.out.println("Database connection failed.");
		}
	}
	
	public List<SBA6Course> getAllCourses() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		SBA6Course course = null;
		List<SBA6Course> courseList = null;
		
		// Assign query string to variable
		String qString = "SELECT * FROM course;";
		
		// Create MariaDB Connection class instance
		DBConnection mariadb = new DBConnection();
		
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
			courseList = new ArrayList<SBA6Course>();
			
			// Read the ResultSet
			while (rs.next()) {
				// Create new student instance in every loop
				course = new SBA6Course();
				
				// Get info from database
				course.setId(rs.getInt(1));
				course.setName(rs.getString(2));
				course.setDetails(rs.getString(3));
				
				// Add the student to the list
				courseList.add(course);
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
		return courseList;
	}
	
	public void addCourse(SBA6Course course) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		
		// Assign insert statement string to variable
		String insertString = "INSERT INTO `course` VALUES" + 
				"('" + course.getId() + "', '" + course.getName() + "', '" + course.getDetails() + "');";
		
		DBConnection mariadb = new DBConnection();
	    
	    try
	    {
	        conn = mariadb.getConnection();
	        stmt = conn.prepareStatement(insertString);
	        stmt.executeUpdate();
	    
	        System.out.printf("\nAdded course:\nCourse ID = %d\nCourse Name = %s\nCourse Details = %s\n",
	        		course.getId(), course.getName(), course.getDetails());
	    }
	    catch (SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		finally
		{
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		
	}
	
	public boolean deleteCourse(SBA6Course course) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
		boolean bool = true;
		
		// Assign delete string to variable
		String deleteString = "DELETE FROM course WHERE `id` = '" + course.getId() + "';";
		
		// Create MariaDBConnection class instance
		DBConnection mariadb = new DBConnection();
		// Begin try/catch block to query the database
		try
		{
			// Connect to database and assign query string to PreparedStatement object
			conn = mariadb.getConnection();
			stmt = conn.prepareStatement(deleteString);
					
			// Run query and assign to ResultSet
			updateResult = stmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e)	{
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		
		// No rows affected if updateResult = 0
		if (updateResult == 0)
			bool = false;
		
		return bool;
	}
	
	public boolean updateCourse(SBA6Course course) throws IOException, SQLException {
		// Declare variables
		boolean bool = true;
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
		
		// Assign update string to variable
		String updateString = "UPDATE course SET `name` = '" + course.getName() + "', details = '" + course.getDetails() +
				"' WHERE `id` = '1';";
		// Create MySqlConnection class instance
		DBConnection mariadb = new DBConnection();
		
		// Begin try/catch block to query the database
		try
		{
			// Connect to database and assign query string to PreparedStatement object
			conn = mariadb.getConnection();
			stmt = conn.prepareStatement(updateString);
					
			// Returns affected row to updateResult
			updateResult = stmt.executeUpdate();
			
		} catch (ClassNotFoundException | SQLException e)	{
			System.out.println("Error: " + e.getMessage());
			
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		
		// No rows affected if updateResult = 0
		if (updateResult == 0) 
			bool = false;

		return bool;
	}
}
