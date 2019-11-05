package com.perscholas.software_developer_club.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.software_developer_club.models.Event;
import com.perscholas.software_developer_club.models.Member;

public class EventDAO {
	
	//****************getAllEvents() method*****************

	public List<Event> getAllEvents() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Event event = null;
		List<Event> eventList = null;

		String qString = "select * from events";

		DatabaseConnection databaseConnection = new DatabaseConnection();

		try
		{
			// Connect to database
			conn = databaseConnection.getConnection();
			// If the connection fails the application won't make it to this point
			System.out.println("Connected to database.");

			stmt = conn.createStatement();

			rs = stmt.executeQuery(qString);
			eventList = new ArrayList<>();
			// Outer loop creates the event objects and add them to a list of events
			while (rs.next()) {
				event = new Event();
				
				event.setEventId(rs.getInt(1));
				event.setTitle(rs.getString(2));
				event.setDescription(rs.getString(3));
				event.setLocation(rs.getString(4));
				event.setDateTime(rs.getTimestamp(5).toLocalDateTime());
				event.setMemberId(rs.getInt(6));			
				event.setEventAttenders(getAttendersByEventId(event.getEventId()));
				eventList.add(event);
			}
		}
		catch (ClassNotFoundException | IOException | SQLException e)
		{
			System.out.println("Error: " + e.getMessage());
			e.getStackTrace();
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
		return eventList;
	} // End of getAllEvents method	
	
	private List<Member> getAttendersByEventId(Integer eventId) 
			throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		List<Member> eventAttenders = null;
		
		String qString = "select members.member_id, members.name, members.email, members.password, "
				+ "members.favorite_language from members join signups on members.member_id = "
				+ "signups.members_member_id where signups.events_event_id = ?";
		
		DatabaseConnection databaseConnection = new DatabaseConnection();
		try {
			conn = databaseConnection.getConnection();
			pstmt = conn.prepareStatement(qString);
			pstmt.setInt(1, eventId);
			rs = pstmt.executeQuery();
			eventAttenders = new ArrayList<>();
			while (rs.next()) {
				member = new Member();
				member.setMemberId(rs.getInt(1));
				member.setName(rs.getString(2));
				member.setEmail(rs.getString(3));
				member.setPassword(rs.getString(4));
				member.setFavoriteLanguage(rs.getString(5));
				eventAttenders.add(member);
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.getMessage();
		}
		finally
		{
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return eventAttenders;
	}
	//****************createEvent() method*****************
	
	public Integer createEvent(Event event) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// Assign insert statement string to variable
		String insertString = "insert into events (title, description, location, date_time, members_member_id) values (?,?,?,?,?)";
		
	    int ID = -1;
	    String[] COL = {"event_id"};
	    
	    DatabaseConnection databaseConnection = new DatabaseConnection();
	    
	    try
	    {
	        conn = databaseConnection.getConnection();
	        stmt = conn.prepareStatement(insertString, COL);
	        
	        stmt.setString(1, event.getTitle());
	        stmt.setString(2, event.getDescription());
	        stmt.setString(3, event.getLocation());
	        stmt.setTimestamp(4, Timestamp.from(event.getDateTime().toInstant(ZoneOffset.ofHours(-4))));
	        stmt.setInt(5, event.getMemberId());
	        
	        stmt.executeUpdate();
	        
	        rs = stmt.getGeneratedKeys();
	        if(rs != null && rs.next()) {
	            ID = rs.getInt(1);
	        }
	        System.out.println(ID);
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
	    
		return ID;
	} // End of createEvent() method
	
//	//****************getUserById() method*****************
//
//	public User getUserById(int userId) throws ClassNotFoundException, IOException, SQLException {
//		// Declare variables
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		User u = null;
//		
//		// Assign query string to variable
//		String qString = "select * from users where user_id = ?";
//		
//		// Create MySqlConnection class instance
//		MySqlConnection mysql = new MySqlConnection();
//		
//		// Begin try/catch block to query the database
//		try
//		{
//			// Connect to database and assign query string to PreparedStatement object
//			conn = mysql.getConnection();
//			stmt = conn.prepareStatement(qString);
//			
//			// Set query parameters (?)
//			stmt.setInt(1, userId); // user_id if from String parameter passed to method
//			
//			// Run query and assign to ResultSet
//			rs = stmt.executeQuery();
//			
//			// Retrieve ResultSet and assign to new User
//			if (rs.next()) {
//				u = new User();
//				u.setUserId(rs.getInt(1));
//				u.setName(rs.getString(2));
//				u.setEmail(rs.getString(3));
//			}
//		}
//		catch (ClassNotFoundException | IOException | SQLException e)
//		{
//			System.out.println("Error: " + e.getMessage());
//			e.getStackTrace();
//		}
//		finally
//		{
//			if (rs != null) {
//				rs.close();
//			}
//			if (stmt != null) {
//				stmt.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		return u;
//	} // End of getUserById() method
//	
//	//****************getUserByName or login method*****************
//
//	public User getUserByName(String name) throws ClassNotFoundException, IOException, SQLException {
//		// Declare variables
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//		User u = null;
//		
//		// Assign query string to variable
//		String qString = "select * from users where name = ?";
//		
//		// Create MySqlConnection class instance
//		MySqlConnection mysql = new MySqlConnection();
//		// Begin try/catch block to query the database
//		try
//		{
//			// Connect to database and assign query string to PreparedStatement object
//			conn = mysql.getConnection();
//			stmt = conn.prepareStatement(qString);
//			
//			// Set query parameters (?)
//			stmt.setString(1, name); // user_id if from String parameter passed to method
//			// Run query and assign to ResultSet
//			rs = stmt.executeQuery();
//			// Retrieve ResultSet and assign to new User
//			if (rs.next()) {
//				u = new User();
//				u.setUserId(rs.getInt(1));
//				u.setName(rs.getString(2));
//				u.setEmail(rs.getString(3));
//			}
//		}
//		catch (ClassNotFoundException | IOException | SQLException e)
//		{
//			System.out.println("Error: " + e.getMessage());
//			System.out.println(e.getStackTrace());
//		}
//		finally
//		{
//			if (rs != null) {
//				rs.close();
//			}
//			if (stmt != null) {
//				stmt.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		return u;
//	}  // End of getUserByName() method
//	
//	//****************updateUser() method*****************
//	
//	public Boolean updateUser(User u) throws SQLException, ClassNotFoundException, IOException {
//		// Declare variables
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		Integer updateResult = null;
//		
//		// Assign update string to variable
//		String updateString = "update users "
//				+ "set name = ?, password = ? "
//				+ "where user_id = ?";
//		
//		// Create MySqlConnection class instance
//		MySqlConnection mysql = new MySqlConnection();
//		// Begin try/catch block to query the database
//		try
//		{
//			// Connect to database and assign query string to PreparedStatement object
//			conn = mysql.getConnection();
//			stmt = conn.prepareStatement(updateString);
//			
//			// Set query parameters (?)
//			stmt.setString(1, u.getName());
//			stmt.setString(2, u.getEmail());
//			stmt.setInt(3, u.getUserId());
//			// Run query and assign to ResultSet
//			updateResult = stmt.executeUpdate();
//		}
//		catch (ClassNotFoundException | SQLException e)
//		{
//			System.out.println("Error: " + e.getMessage());
//		}
//		finally
//		{
//			if (stmt != null) {
//				stmt.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//		}
//		if (updateResult > 0) {
//			return true;
//		}
//		return false;
//	} // End of updateUser() method
//	
	//****************removeEvent() method (i.e., delete)*****************
	
	public Boolean removeEvent(Integer eventId) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
		
		// Assign delete string to variable
		String deleteString = "delete from events where event_id = ?";
		
		// Create MySqlConnection class instance
		DatabaseConnection databaseConnection = new DatabaseConnection();
		// Begin try/catch block to query the database
		try
		{
			// Connect to database and assign query string to PreparedStatement object
			conn = databaseConnection.getConnection();
			stmt = conn.prepareStatement(deleteString);
			
			// Set query parameters (?)
			stmt.setInt(1, eventId);
			// Run query and assign to ResultSet
			updateResult = stmt.executeUpdate();
		}
		catch (ClassNotFoundException | SQLException e)
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
		if (updateResult > 0) {
			return true;
		}
		return false;
	} // End of removeEvent() method
	
} // End of EventDAO class