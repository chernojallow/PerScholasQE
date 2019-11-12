package com.perscholas.casestudy.rms.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.casestudy.rms.models.Item;

public class ItemDAO {
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
	public List<Item> getAll() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Item i = null;
		List<Item> itemList = null;

		// Assign query string to a string
		String qString = "SELECT * FROM item;";
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
			itemList = new ArrayList<Item>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new object
				i = new Item();
				// Assign columns/fields to related fields in the object
				// Represent column numbers/positions
				i.setItemId(rs.getInt(1));
				i.setItemName(rs.getString(2));
				i.setCategoryId(rs.getInt(3));
				i.setPrice(rs.getDouble(4));
				// Add the user to the list
				itemList.add(i);
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
		return itemList;
	} // End of getAll() method

	// ****************create() method*****************
	public Integer create(Item item) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign insert statement string to variable
		String insertString = "INSERT INTO item (`itemName`, `price`, `categoryId`) VALUES (?, ?, ?);";

		int ID = -1;
		String[] COL = { "`itemId`" };

		DBConnection dbConn = new DBConnection();

		try {
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(insertString, COL);

			stmt.setString(1, item.getItemName());
			stmt.setDouble(2, item.getPrice());
			stmt.setInt(3, item.getCategoryId());

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
	public Item getById(Integer itemId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Item i = null;

		// Assign query string to variable
		String qString = "SELECT * FROM item WHERE `itemId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setInt(1, itemId); // ID if from String parameter passed to method

			// Run query and assign to ResultSet
			rs = stmt.executeQuery();

			// Retrieve ResultSet and assign to new object
			if (rs.next()) {
				i = new Item();
				i.setItemId(rs.getInt(1));
				i.setItemName(rs.getString(2));
				i.setCategoryId(rs.getInt(3));
				i.setPrice(rs.getDouble(4));
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
		return i;
	} // End of getById() method

	// ****************update() method*****************
	public Boolean update(Item i) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign update string to variable
		String updateString = "UPDATE item SET `itemName` = ?, `categoryId` = ?, `price` = ? WHERE `itemId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(updateString);

			// Set query parameters (?)
			stmt.setString(1, i.getItemName());
			stmt.setInt(2, i.getCategoryId());
			stmt.setDouble(3, i.getPrice());
			stmt.setInt(4, i.getItemId());
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
	public Boolean remove(Integer itemId) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign delete string to variable
		String deleteString = "DELETE FROM item WHERE `itemId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(deleteString);

			// Set query parameters (?)
			stmt.setInt(1, itemId);
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
		ItemDAO i_dao = new ItemDAO();
		i_dao.testConnection();
		System.out.println();

		Item i = new Item();
		i.setItemName("itemNameE");
		i.setCategoryId(1);
		i.setPrice(15.50);
		i.setItemId(i_dao.create(i));
		System.out.println("create()\n" + i.toString());
		System.out.println();

		List<Item> iList = i_dao.getAll();
		System.out.println("getAll()");
		for (Item i1 : iList)
			System.out.println(i1.toString());
		System.out.println();

		i = new Item(1, "itemNameEU", 1, 15.25);
		if (i_dao.update(i))
			System.out.println("update()\n" + i.toString());
		else
			System.out.println("update() failed");
		System.out.println();

		i = i_dao.getById(1);
		System.out.println("getById()\n" + i.toString());
		System.out.println();

		i = i_dao.getById(2);
		if (i_dao.remove(2))
			System.out.println("remove()\n" + i.toString());
		else
			System.out.println("remove() failed");
	} // End of DAOTesting() method

//	// ****************main() method testing*****************
//	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
//		DAOTesting();
//	} // End of main() method
}
