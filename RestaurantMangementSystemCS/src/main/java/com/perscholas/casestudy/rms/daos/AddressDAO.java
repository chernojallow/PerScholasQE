package com.perscholas.casestudy.rms.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.perscholas.casestudy.rms.models.Address;

public class AddressDAO {
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

	// ****************create() method*****************
	public Integer create(Address address) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign insert statement string to variable
		String insertString = "INSERT INTO `address` (`address1`, `address2`, `city`, `state`, `postalCode`) VALUES (?, ?, ?, ?, ?);";

		int ID = -1;
		String[] COL = { "`addressId`" };

		DBConnection dbConn = new DBConnection();

		try {
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(insertString, COL);

			stmt.setString(1, address.getAddress1());
			stmt.setString(2, address.getAddress2());
			stmt.setString(3, address.getCity());
			stmt.setString(4, address.getState());
			stmt.setInt(5, address.getPostalCode());

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
	public Address getById(Integer addressId) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Address a = null;

		// Assign query string to variable
		String qString = "SELECT * FROM `address` WHERE `addressId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setInt(1, addressId); // ID if from String parameter passed to method

			// Run query and assign to ResultSet
			rs = stmt.executeQuery();

			// Retrieve ResultSet and assign to new object
			if (rs.next()) {
				a = new Address();
				a.setAddressId(rs.getInt(1));
				a.setAddress1(rs.getString(2));
				a.setAddress2(rs.getString(3));
				a.setCity(rs.getString(4));
				a.setState(rs.getString(5));
				a.setPostalCode(rs.getInt(6));
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
		return a;
	} // End of getById() method

	// ****************update() method*****************
	public Boolean update(Address a) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign update string to variable
		String updateString = "UPDATE `address` SET `address1` = ?, `address2` = ?, `city` = ?, `state` = ?, `postalCode` = ? WHERE `addressId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(updateString);

			// Set query parameters (?)
			stmt.setString(1, a.getAddress1());
			stmt.setString(2, a.getAddress2());
			stmt.setString(3, a.getCity());
			stmt.setString(4, a.getState());
			stmt.setInt(5, a.getPostalCode());
			stmt.setInt(6, a.getAddressId());
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
	public Boolean remove(Integer addressId) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign delete string to variable
		String deleteString = "DELETE FROM `address` WHERE `addressId` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(deleteString);

			// Set query parameters (?)
			stmt.setInt(1, addressId);
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
		AddressDAO a_dao = new AddressDAO();
		a_dao.testConnection();
		System.out.println();

		Address a = new Address();
		a.setAddress1("address1E");
		a.setAddress2("address2E");
		a.setCity("city1E");
		a.setState("SE");
		a.setPostalCode(12345);
		a.setAddressId(a_dao.create(a));
		System.out.println("create()\n" + a.toString());
		System.out.println();

		a = new Address(1, "address1EU", "", "city1EU", "EU", 00000);
		if (a_dao.update(a))
			System.out.println("update()\n" + a.toString());
		else
			System.out.println("update() failed");
		System.out.println();

		a = a_dao.getById(1);
		System.out.println("getById()\n" + a.toString());
		System.out.println();

		a = a_dao.getById(2);
		if (a_dao.remove(2))
			System.out.println("remove()\n" + a.toString());
		else
			System.out.println("remove() failed");
	} // End of DAOTesting() method

//	// ****************main() method testing*****************
//	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
//		DAOTesting();
//	} // End of main() method
}
