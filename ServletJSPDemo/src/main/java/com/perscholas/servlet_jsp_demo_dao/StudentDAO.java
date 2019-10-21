package com.perscholas.servlet_jsp_demo_dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.servlet_jsp_demo_models.Student;

public class StudentDAO {
	
	public List<Student> getAllStudents() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Student stud = null;
		List<Student> studentList = null;
		
		// Assign query string to variable
		String qString = "SELECT * FROM students;";
		
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
			studentList = new ArrayList<Student>();
			
			// Read the ResultSet
			while (rs.next()) {
				// Create new student instance in every loop
				stud = new Student();
				
				// Get info from database
				stud.setStudentId(rs.getInt(1));
				stud.setName(rs.getString(2));
				stud.setEmail(rs.getString(3));
				stud.setHometown(rs.getString(4));
				stud.setCourseSelected(rs.getString(5));
				
				// Add the student to the list
				studentList.add(stud);
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
		return studentList;
	}
	
	public static void addStudent(Student student) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// Assign insert statement string to variable
		String insertString = "INSERT INTO `students` VALUES\r\n" + 
				"('" + student.getStudentId() + "','" + student.getName() + "','" + student.getEmail()
				+ "','" + student.getHometown() + "','" + student.getCourseSelected() + "');";
		
		MariaDBConnection mariadb = new MariaDBConnection();
	    
	    try
	    {
	        conn = mariadb.getConnection();
	        stmt = conn.prepareStatement(insertString);
	        stmt.executeUpdate();
	    
	        System.out.printf("\nAdded student(s):\nStudent ID = %d\nStudent Name = %s\nStudent Email = %s\nStudent Hometown = %s\n"
					+ "Course Selected = %s\n", student.getStudentId(), student.getName(), student.getEmail()
					, student.getHometown(),student.getCourseSelected());
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
	
	public static boolean updateStudent(Student student) throws IOException, SQLException {
		// Declare variables
		boolean bool = true;
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
		
		// Assign update string to variable
		String updateString = "UPDATE students SET name = '" + student.getName() +
				"', email = '" + student.getEmail() + "', hometown = '" + student.getHometown() + "', courseSelected = '" +
				student.getCourseSelected() + "' WHERE studentID = '" + student.getStudentId() + "';";
		
		// Create MySqlConnection class instance
		MariaDBConnection mariadb = new MariaDBConnection();
		
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
	
	public static boolean deleteStudent(Student student) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
		boolean bool = true;
		
		// Assign delete string to variable
		String deleteString = "DELETE FROM students WHERE studentId = '" + student.getStudentId() + "';";
		
		// Create MariaDBConnection class instance
		MariaDBConnection mariadb = new MariaDBConnection();
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
	
	public void testConnection() {
		MariaDBConnection mariadbConnection = new MariaDBConnection();
		try {
			mariadbConnection.getConnection();
			System.out.println("Main method test connection");
		} catch (Exception e){
			System.out.println("Database connection failed.");
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		StudentDAO s_dao = new StudentDAO();
		List<Student> studentList = null;
		
		// Test database connection
		s_dao.testConnection();
		
		// Get data from database
		try {
			studentList = s_dao.getAllStudents();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Print studentList
		System.out.printf("\nCurrent student(s) in database: ");
		for (Student stud:studentList)
			System.out.printf("\nStudent ID = %d\nStudent Name = %s\nStudent Email = %s\nStudent Hometown = %s\n"
					+ "Course Selected = %s\n", stud.getStudentId(), stud.getName(), stud.getEmail(), stud.getHometown(),
					stud.getCourseSelected());
		
		// Add student
		Student stud3 = new Student();
		stud3.setStudentId(4);
		stud3.setName("Steven Buchanan");
		stud3.setEmail("stevenbuchanan@gmailcom");
		stud3.setHometown("London, UK");
		stud3.setCourseSelected("Science 1");
		addStudent(stud3);
		
		// Update student
		Student stud4 = new Student();
		stud4.setStudentId(4);
		stud4.setName("Margaret Peacock");
		stud4.setEmail("margaretpeacock@gmailcom");
		stud4.setHometown("Redmond, WA");
		stud4.setCourseSelected("Social Studies");
		
		if (updateStudent(stud4))
			System.out.printf("\nUpdated student(s):\nStudent ID = %d\nStudent Name = %s\nStudent Email = %s\nStudent Hometown = %s\n"
					+ "Course Selected = %s\n", stud4.getStudentId(), stud4.getName(), stud4.getEmail()
					, stud4.getHometown(), stud4.getCourseSelected());
		else System.out.println("Failed to update student information");
		
		// Delete stud4
		if (deleteStudent(stud4))
			System.out.printf("\nDeleted student(s):\nStudent ID = %d\nStudent Name = %s\nStudent Email = %s\nStudent Hometown = %s\n"
					+ "Course Selected = %s\n", stud4.getStudentId(), stud4.getName(), stud4.getEmail()
					, stud4.getHometown(), stud4.getCourseSelected());
		else System.out.println("Failed to update student information");
		
	}
	
}
