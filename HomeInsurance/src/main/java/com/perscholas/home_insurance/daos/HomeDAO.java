package com.perscholas.home_insurance.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.perscholas.home_insurance.models.Home;

public class HomeDAO {
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
	public List<Home> getAll() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Home h = null;
		List<Home> homeList = null;

		// Assign query string to a string
		String qString = "SELECT * FROM `home`;";
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
			homeList = new ArrayList<Home>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new object
				h = new Home();
				// Assign columns/fields to related fields in the object
				// Represent column numbers/positions
				h.setHomeId(rs.getInt(1));
				h.setUserId(rs.getInt(2));
				h.setAddress1(rs.getString(3));
				h.setAddress2(rs.getString(4));
				h.setCity(rs.getString(5));
				h.setState(rs.getString(6));
				h.setZip(rs.getInt(7));
				h.setYearBuilt(rs.getInt(8));
				h.setHomeValue(rs.getDouble(9));
				// Add the user to the list
				homeList.add(h);
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
		return homeList;
	} // End of getAll() method

	// ****************create() method*****************
	public Integer create(Home home) throws SQLException, IOException, ClassNotFoundException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign insert statement string to variable
		String insertString = "INSERT INTO `home` (`userId`, `address1`, `address2`, `city`, `state`,"
				+ " `zip`, `yearBuilt`, `homeValue`) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

		int ID = -1;
		String[] COL = { "`homeId`" };

		DBConnection dbConn = new DBConnection();

		try {
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(insertString, COL);

			stmt.setInt(1, home.getUserId());
			stmt.setString(2, home.getAddress1());
			stmt.setString(3, home.getAddress2());
			stmt.setString(4, home.getCity());
			stmt.setString(5, home.getState());
			stmt.setInt(6, home.getZip());
			stmt.setInt(7, home.getYearBuilt());
			stmt.setDouble(8, home.getHomeValue());

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
	} // End of create() method

	// ****************remove() method (i.e., delete)*****************
	public Boolean remove(Integer homeId) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign delete string to variable
		String deleteString = "DELETE FROM `home` WHERE `homeId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(deleteString);

			// Set query parameters (?)
			stmt.setInt(1, homeId);
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
	public static void DAOTesting() throws IOException, SQLException, ClassNotFoundException {
		HomeDAO h_dao = new HomeDAO();
		h_dao.testConnection();

		System.out.println("create() & getAll()");
		Home h = new Home();
		h.setUserId(1);
		h.setAddress1("addr11e");
		h.setAddress2("addr21e");
		h.setCity("c1e");
		h.setState("e1");
		h.setZip(12345);
		h.setYearBuilt(2000);
		h.setHomeValue(10000.11);

		h_dao.create(h);

		List<Home> hlist = h_dao.getAll();
		for (Home h1 : hlist) {
			System.out.println(h1.toString());
		}

		System.out.println("remove()");
		if (h_dao.remove(1))
			System.out.println("remove sucess");
		else
			System.out.println("remove failed");
	}

//	// ****************main() method testing*****************
//	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
//		DAOTesting();
//	} // End of main() method
}
