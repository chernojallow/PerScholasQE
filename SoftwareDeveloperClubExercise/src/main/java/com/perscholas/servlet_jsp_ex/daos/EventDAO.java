package com.perscholas.servlet_jsp_ex.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.servlet_jsp_ex.models.Event;

public class EventDAO {
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
	public List<Event> getAll() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Event eve = null;
		List<Event> eventList = null;

		// Assign query string to a string
		String qString = "SELECT * FROM `event`;";
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
			eventList = new ArrayList<Event>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new object
				eve = new Event();
				// Assign columns/fields to related fields in the object
				// Represent column numbers/positions
				eve.setEventId(rs.getInt(1));
				eve.setTitle(rs.getString(2));
				eve.setDescription(rs.getString(3));
				eve.setDateTime(rs.getTimestamp(4));
				// Add the user to the list
				eventList.add(eve);
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
		return eventList;
	} // End of getAll() method

	// ****************register() method*****************
	public Integer register(Event event) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign insert statement string to variable
		String insertString = "INSERT INTO `event` (`title`, `description`, `location`, `dateTime`, `memberId`) VALUES (?, ?, ?, ?, ?);";

		int ID = -1;
		String[] COL = { "`eventId`" };

		DBConnection dbConn = new DBConnection();

		try {
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(insertString, COL);

			stmt.setString(1, event.getTitle());
			stmt.setString(2, event.getDescription());
			stmt.setString(3, event.getLocation());
			stmt.setTimestamp(4, event.getDateTime());
			stmt.setInt(5, event.getMemberId());

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
	} // End of register() method

	// ****************getByID() method*****************
	public Event getByID(Integer eventId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Event eve = null;

		// Assign query string to variable
		String qString = "SELECT * FROM `event` WHERE `eventId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setInt(1, eventId); // ID if from String parameter passed to method

			// Run query and assign to ResultSet
			rs = stmt.executeQuery();

			// Retrieve ResultSet and assign to new object
			if (rs.next()) {
				eve = new Event();
				eve.setTitle(rs.getString(1));
				eve.setDescription(rs.getString(2));
				eve.setLocation(rs.getString(3));
				eve.setDateTime(rs.getTimestamp(4));
				eve.setMemberId(rs.getInt(5));
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
		return eve;
	} // End of getByID() method

	// ****************getByName or login method*****************
	public Event getByName(String title) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Event eve = null;

		// Assign query string to variable
		String qString = "SELECT * FROM `event` WHERE `title` = ?;";

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
				eve = new Event();
				eve.setEventId(rs.getInt(1));
				eve.setTitle(rs.getString(2));
				eve.setDescription(rs.getString(3));
				eve.setLocation(rs.getString(4));
				eve.setDateTime(rs.getTimestamp(5));
				eve.setMemberId(rs.getInt(6));
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
		return eve;
	} // End of getByName() method

	// ****************update() method*****************
	public Boolean update(Event eve) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign update string to variable
		String updateString = "UPDATE `event` SET `title` = ?, `description` = ?, `location` = ?, `dateTime` = ?, `memberId` = ? WHERE `eventId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(updateString);

			// Set query parameters (?)
			stmt.setString(1, eve.getTitle());
			stmt.setString(2, eve.getDescription());
			stmt.setString(3, eve.getLocation());
			stmt.setTimestamp(4, eve.getDateTime());
			stmt.setInt(5, eve.getMemberId());
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
	public Boolean remove(Integer memberId) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign delete string to variable
		String deleteString = "DELETE FROM `member` WHERE `memberId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(deleteString);

			// Set query parameters (?)
			stmt.setInt(1, memberId);
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
	
	public static void main(String[] args) {
		EventDAO e_dao = new EventDAO();
		e_dao.testConnection();
	}
}
