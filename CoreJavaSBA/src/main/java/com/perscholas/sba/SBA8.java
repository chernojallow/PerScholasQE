package com.perscholas.sba;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.perscholas.sba_dao.DBConnection;
import com.perscholas.sba_models.SBA8Event;

public class SBA8 {

	public static void addStudent(SBA8Event event) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// Assign insert statement string to variable
		String insertString = "INSERT INTO `event` VALUES\r\n" + 
				"('" + event.getId() + "','" + event.getName() + "','" + event.getDescription()
				+ "','" + event.converToSQLDate(event.getUtilDate()) + "');";
		
		DBConnection mariadb = new DBConnection();
	    
	    try
	    {
	        conn = mariadb.getConnection();
	        stmt = conn.prepareStatement(insertString);
	        stmt.executeUpdate();
	    
	        System.out.printf("\nAdded Event:\nEvent ID = %d\nEvent Name = %s\nEvent Description = %s\nEven Date = %s\n",
	        		event.getId(), event.getName(), event.getDescription(), event.getUtilDate());
	    }
	    catch (SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
		}
		finally
		{
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		
	}
	
	public static void testConnection() {
		DBConnection mariadbConnection = new DBConnection();
		try {
			mariadbConnection.getConnection();
			System.out.println("Main method test connection");
		} catch (Exception e){
			System.out.println("Database connection failed.");
		}
	}
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		// Test database connection
		testConnection();
		
		SBA8Event event = new SBA8Event();
		event.setId(0);
		event.setName("Friday");
		event.setDescription("Capital One Heart Empowers Event");
		event.setUtilDate(new java.util.Date());
		
		addStudent(event);
	}

}
