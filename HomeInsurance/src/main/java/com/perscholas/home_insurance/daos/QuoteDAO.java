package com.perscholas.home_insurance.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.perscholas.home_insurance.models.Quote;

public class QuoteDAO {
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
	public Integer register(Quote quote) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign insert statement string to variable
		String insertString = "INSERT INTO `quote` (`homeId`, `yearlyPremium`, `startDate`, "
				+ "`expiration`, `active`) VALUES (?, ?, ?, ?, ?);";

		int ID = -1;
		String[] COL = { "`quoteId`" };

		DBConnection dbConn = new DBConnection();

		try {
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(insertString, COL);

			stmt.setInt(1, quote.getHomeId());
			stmt.setDouble(2, quote.getYearlyPremium());
			stmt.setDate(3, quote.getStartDate());
			stmt.setDate(4, quote.getExpiration());
			stmt.setBoolean(5, quote.getActive());

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

	// ****************getByID() method*****************
	public Quote getByID(Integer quoteId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Quote q = null;

		// Assign query string to variable
		String qString = "SELECT * FROM `quote` WHERE `quoteId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setInt(1, quoteId);

			// Run query and assign to ResultSet
			rs = stmt.executeQuery();

			// Retrieve ResultSet and assign to new object
			if (rs.next()) {
				q = new Quote();
				q.setQuoteId(rs.getInt(1));
				q.setHomeId(rs.getInt(2));
				q.setYearlyPremium(rs.getDouble(3));
				q.setStartDate(rs.getDate(4));
				q.setExpiration(rs.getDate(5));
				q.setActive(rs.getBoolean(6));
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
		return q;
	} // End of getByID() method
	
	// ****************DAOTesting() method*****************
	public static void DAOTesting() throws ClassNotFoundException, IOException, SQLException {
		QuoteDAO q_dao = new QuoteDAO();
		q_dao.testConnection();

		System.out.println("getByID()");
		System.out.println(q_dao.getByID(1).toString());

		System.out.println("register()");
		Quote q = new Quote();
		
		q.setHomeId(1);
		q.setYearlyPremium(111.11);
		q.setStartDate(new Date(System.currentTimeMillis()));
		Calendar c = Calendar.getInstance();
		c.setTime(c.getTime());
		c.add(Calendar.YEAR, 1);
		q.setExpiration(new Date(c.getTimeInMillis()));
		q.setActive(true);

		System.out.println(q_dao.getByID(q_dao.register(q)));
	}

//	// ****************main() method testing*****************
//	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
//		DAOTesting();
//	} // End of main() method
}
