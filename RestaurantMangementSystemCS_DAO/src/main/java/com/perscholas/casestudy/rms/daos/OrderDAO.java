package com.perscholas.casestudy.rms.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.casestudy.rms.models.Order;

public class OrderDAO {
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
	public List<Order> getAll() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Order o = null;
		List<Order> orderList = null;

		// Assign query string to a string
		String qString = "SELECT * FROM `order`;";
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
			orderList = new ArrayList<Order>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new object
				o = new Order();
				// Assign columns/fields to related fields in the object
				// Represent column numbers/positions
				o.setOrderId(rs.getInt(1));
				o.setUserId(rs.getInt(2));
				o.setTime(rs.getTimestamp(3));

				// Add the user to the list
				orderList.add(o);
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
		return orderList;
	} // End of getAll() method

	// ****************create() method*****************
	public Integer create(Order order) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign insert statement string to variable
		String insertString = "INSERT INTO `order` (`userId`, `time`) VALUES (?, ?);";

		int ID = -1;
		String[] COL = { "`orderId`" };

		DBConnection dbConn = new DBConnection();

		try {
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(insertString, COL);

			stmt.setInt(1, order.getUserId());
			stmt.setTimestamp(2, order.getTime());

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
	} // End of create() method

	// ****************getById() method*****************
	public Order getById(Integer orderId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Order o = null;

		// Assign query string to variable
		String qString = "SELECT * FROM `order` WHERE `orderId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setInt(1, orderId); // ID if from String parameter passed to method

			// Run query and assign to ResultSet
			rs = stmt.executeQuery();

			// Retrieve ResultSet and assign to new object
			if (rs.next()) {
				o = new Order();
				o.setOrderId(rs.getInt(1));
				o.setUserId(rs.getInt(2));
				o.setTime(rs.getTimestamp(3));
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
		return o;
	} // End of getById() method

	// ****************update() method*****************
	public Boolean update(Order o) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign update string to variable
		String updateString = "UPDATE `order` SET `userId` = ?, `time` = ? WHERE `orderId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(updateString);

			// Set query parameters (?)
			stmt.setInt(1, o.getUserId());
			stmt.setTimestamp(2, o.getTime());
			stmt.setInt(3, o.getOrderId());
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
	public Boolean remove(Integer orderId) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign delete string to variable
		String deleteString = "DELETE FROM `order` WHERE `orderId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(deleteString);

			// Set query parameters (?)
			stmt.setInt(1, orderId);
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

	public static void DAOTesting() throws ClassNotFoundException, IOException, SQLException {
		OrderDAO o_dao = new OrderDAO();
		o_dao.testConnection();
		System.out.println();

		Order o = new Order();
		o.setUserId(1);
		o.setTime(new Timestamp(System.currentTimeMillis()));
		o.setOrderId(o_dao.create(o));
		System.out.println("create()\n" + o.toString());
		System.out.println();

		List<Order> oList = o_dao.getAll();
		System.out.println("getAll()");
		for (Order o1 : oList)
			System.out.println(o1.toString());
		System.out.println();

		o = new Order(1, 1, new Timestamp(System.currentTimeMillis()));
		if (o_dao.update(o))
			System.out.println("update()\n" + o.toString());
		else
			System.out.println("update() failed");
		System.out.println();

		o = o_dao.getById(1);
		System.out.println("getById()\n" + o.toString());
		System.out.println();

		o = o_dao.getById(2);
		if (o_dao.remove(2))
			System.out.println("remove()\n" + o.toString());
		else
			System.out.println("remove() failed");
	} // End of DAOTesting() method

//	// ****************main() method testing*****************
//	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
//		DAOTesting();
//	} // End of main() method
}
