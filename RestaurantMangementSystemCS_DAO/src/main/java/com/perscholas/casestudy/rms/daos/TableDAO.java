package com.perscholas.casestudy.rms.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.casestudy.rms.models.Table;

public class TableDAO {
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
	public List<Table> getAll() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Table t = null;
		List<Table> tableList = null;

		// Assign query string to a string
		String qString = "SELECT * FROM `table`;";
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
			tableList = new ArrayList<Table>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new object
				t = new Table();
				// Assign columns/fields to related fields in the object
				// Represent column numbers/positions
				t.setTableId(rs.getInt(1));
				t.setUserId(rs.getInt(2));
				t.setOrderId(rs.getInt(3));
				// Add the user to the list
				tableList.add(t);
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
		return tableList;
	} // End of getAll() method

	// ****************create() method*****************
	public Boolean create(Integer userId, Integer tableId) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer createResult = null;

		// Assign insert statement string to variable
		String insertString = "INSERT INTO `table` (`userId`, `tableId`) VALUES (?, ?);";

		DBConnection dbConn = new DBConnection();

		try {
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(insertString);

			stmt.setInt(1, userId);
			stmt.setInt(2, tableId);

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
	public Table getById(Integer tableId, Integer userId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Table t = null;

		// Assign query string to variable
		String qString = "SELECT * FROM `table` WHERE `tableId` = ? && `userId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setInt(1, tableId); // ID if from String parameter passed to method
			stmt.setInt(2, userId); // ID if from String parameter passed to method

			// Run query and assign to ResultSet
			rs = stmt.executeQuery();

			// Retrieve ResultSet and assign to new object
			if (rs.next()) {
				t = new Table();
				t.setTableId(rs.getInt(1));
				t.setUserId(rs.getInt(2));
				t.setOrderId(rs.getInt(3));
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
		return t;
	} // End of getById() method

	// ****************update() method*****************
	public Boolean update(Table t, Integer newOrderId) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign update string to variable
		String updateString = "UPDATE `table` SET `orderId` = ? WHERE `tableId` = ? && `userId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(updateString);

			// Set query parameters (?)
			stmt.setInt(1, newOrderId);
			stmt.setInt(2, t.getTableId());
			stmt.setInt(3, t.getUserId());

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
	public Boolean remove(Integer tableId, Integer userId) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign delete string to variable
		String deleteString = "DELETE FROM `table` WHERE `tableId` = ? && `userId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(deleteString);

			// Set query parameters (?)
			stmt.setInt(1, tableId);
			stmt.setInt(2, userId);
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
		TableDAO t_dao = new TableDAO();
		t_dao.testConnection();
		System.out.println();

		Table t = new Table();
		if (t_dao.create(1, 4))
			System.out.println("create() & getById()\n" + t_dao.getById(4, 1).toString());
		else
			System.out.println("create() & getById() failed");
		System.out.println();

		List<Table> tList = t_dao.getAll();
		System.out.println("getAll()");
		for (Table t1 : tList)
			System.out.println(t1.toString());
		System.out.println();

		t = new Table();
		t.setTableId(1);
		t.setUserId(1);
		t.setOrderId(1);

		if (t_dao.update(t, t.getOrderId()))
			System.out.println("update()\n" + t.toString());
		else
			System.out.println("update() failed");
		System.out.println();

		t = t_dao.getById(2, 1);
		if (t_dao.remove(2, 1))
			System.out.println("remove()\n" + t.toString());
		else
			System.out.println("remove() failed");
	} // End of DAOTesting() method

//	// ****************main() method testing*****************
//	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
//		DAOTesting();
//	} // End of main() method
}
