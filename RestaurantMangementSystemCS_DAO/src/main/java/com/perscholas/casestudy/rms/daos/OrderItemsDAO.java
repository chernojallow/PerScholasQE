package com.perscholas.casestudy.rms.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.casestudy.rms.models.OrderItems;

public class OrderItemsDAO {
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
	public List<OrderItems> getAll() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		OrderItems oi = null;
		List<OrderItems> orderItemsList = null;

		// Assign query string to a string
		String qString = "SELECT * FROM `order_items`;";
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
			orderItemsList = new ArrayList<OrderItems>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new object
				oi = new OrderItems();
				// Assign columns/fields to related fields in the object
				// Represent column numbers/positions
				oi.setOrderId(rs.getInt(1));
				oi.setItemId(rs.getInt(2));
				oi.setQuantity(rs.getInt(3));
				oi.setSubtotal(rs.getDouble(4));
				// Add the user to the list
				orderItemsList.add(oi);
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
		return orderItemsList;
	} // End of getAll() method

	// ****************create() method*****************
	public Boolean create(OrderItems orderItem) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer createResult = null;

		// Assign insert statement string to variable
		String insertString = "INSERT INTO `order_items` (`orderId`, `itemId`, `quantity`, `subtotal`) VALUES (?, ?, ?, "
				+ "ROUND((SELECT `price` FROM `item` WHERE `itemId` = " + orderItem.getItemId() + ") * "
				+ orderItem.getQuantity() + ", 2));";
		DBConnection dbConn = new DBConnection();

		try {
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(insertString);

			stmt.setInt(1, orderItem.getOrderId());
			stmt.setInt(2, orderItem.getItemId());
			stmt.setInt(3, orderItem.getQuantity());

			createResult = stmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		}
		if (createResult > 0)
			return true;
		return false;
	} // End of create() method

	// ****************getById() method*****************
	public OrderItems getById(Integer orderId, Integer itemId)
			throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		OrderItems oi = null;

		// Assign query string to variable
		String qString = "SELECT * FROM `order_items` WHERE `orderId` = ? && `itemId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setInt(1, orderId); // ID if from String parameter passed to method
			stmt.setInt(2, itemId); // ID if from String parameter passed to method

			// Run query and assign to ResultSet
			rs = stmt.executeQuery();

			// Retrieve ResultSet and assign to new object
			if (rs.next()) {
				oi = new OrderItems();
				oi.setOrderId(rs.getInt(1));
				oi.setItemId(rs.getInt(2));
				oi.setQuantity(rs.getInt(3));
				oi.setSubtotal(rs.getDouble(4));
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
		return oi;
	} // End of getById() method

	// ****************update() method*****************
	public Boolean update(OrderItems oi, Integer newItemId) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign update string to variable
		String updateString = "UPDATE `order_items` SET `itemId` = ?, `quantity` = ?, `subtotal` = (ROUND((SELECT `price` FROM `item` WHERE `itemId` = "
				+ oi.getItemId() + ") * " + oi.getQuantity() + ", 2)) WHERE `orderId` = ? && `itemId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(updateString);

			// Set query parameters (?)
			stmt.setInt(1, newItemId);
			stmt.setInt(2, oi.getQuantity());
			stmt.setInt(3, oi.getOrderId());
			stmt.setInt(4, oi.getItemId());

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
	public Boolean remove(Integer orderId, Integer itemId) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign delete string to variable
		String deleteString = "DELETE FROM `order_items` WHERE `orderId` = ? && `itemId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(deleteString);

			// Set query parameters (?)
			stmt.setInt(1, orderId);
			stmt.setInt(2, itemId);

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

	public static void DAOTesting() throws ClassNotFoundException, IOException, SQLException {
		OrderItemsDAO oi_dao = new OrderItemsDAO();
		oi_dao.testConnection();
		System.out.println();

		OrderItems oi = new OrderItems();
		oi.setOrderId(1);
		oi.setItemId(4);
		oi.setQuantity(1);

		if (oi_dao.create(oi))
			System.out.println("create() & getById()\n" + oi_dao.getById(oi.getOrderId(), oi.getItemId()).toString());
		else
			System.out.println("create() & getById() failed");
		System.out.println();

		List<OrderItems> oiList = oi_dao.getAll();
		System.out.println("getAll()");
		for (OrderItems oi1 : oiList)
			System.out.println(oi1.toString());
		System.out.println();

		oi = new OrderItems();
		oi.setOrderId(1);
		oi.setItemId(1);
		oi.setQuantity(2);
		if (oi_dao.update(oi, 5))
			System.out.println("update()\n" + oi_dao.getById(1, 4));
		else
			System.out.println("update() failed");
		System.out.println();

		oi = oi_dao.getById(2, 6);
		if (oi_dao.remove(2, 6))
			System.out.println("remove()\n" + oi.toString());
		else
			System.out.println("remove() failed");
	} // End of DAOTesting() method

//	// ****************main() method testing*****************
//	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
//		DAOTesting();
//	} // End of main() method
}
