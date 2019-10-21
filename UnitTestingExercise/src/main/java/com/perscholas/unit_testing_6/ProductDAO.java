package com.perscholas.unit_testing_6;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	//****************testConnection() method*****************
	public void testConnection() {
		DBConnection dbConn = new DBConnection();
		try {
			dbConn.getConnection();
			System.out.println("Main method test connection succeed");
		} catch (Exception e){
			System.out.println("Database connection failed.");
		}
	}
	
	//****************getAllUsers() method*****************
	public List<Product> getAllProducts() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Product u = null;
		List<Product> userList = null;
		
		// Assign query string to a string
		String qString = "SELECT * FROM product;";

		// Create MySqlConnection class instance
		DBConnection dbConn = new DBConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database
			conn = dbConn.getConnection();
			// If the connection fails the application won't make it to this point
			System.out.println("Connected to database.\n");
			// Create Statement instance/object
			stmt = conn.createStatement();
		
			// Run query and assign to the ResultSet instance
			rs = stmt.executeQuery(qString);
			//Create list to hold User objects
			userList = new ArrayList<Product>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new user
				u = new Product();
				// Assign columns/fields to related fields in the User object
				// 1,2 and 3 represent column numbers/positions
				u.setProductID(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPrice(rs.getDouble(3));
				// Add the user to the list
				userList.add(u);
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
		return userList;
	} // End of getAllUsers method	
	
	//****************registerUser() method*****************	
	public Integer registerProduct(Product product) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		// Assign insert statement string to variable
		String insertString = "INSERT INTO product (`name`, `price`) VALUES (?,?);";
		
	    int ID = -1;
	    String[] COL = {"`productID`"};
	    
	    DBConnection dbConn = new DBConnection();
	    
	    try {
	        conn = dbConn.getConnection();
	        stmt = conn.prepareStatement(insertString, COL);
	        
	        stmt.setString(1, product.getName());
	        stmt.setDouble(2, product.getPrice());
	        
	        stmt.executeUpdate();
	        
	        rs = stmt.getGeneratedKeys();
	        if(rs != null && rs.next()) {
	            ID = rs.getInt(1);
	        }
	        System.out.println(ID);
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
	} // End of registerUser() method
	
	//****************getUserById() method*****************
	public Product getUserByID(int productID) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Product p = null;
		
		// Assign query string to variable
		String qString = "SELECT * FROM product WHERE `productID` = ?;";
		
		// Create MySqlConnection class instance
		DBConnection dbConn = new DBConnection();
		
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(qString);
			
			// Set query parameters (?)
			stmt.setInt(1, productID); // user_id if from String parameter passed to method
			
			// Run query and assign to ResultSet
			rs = stmt.executeQuery();
			
			// Retrieve ResultSet and assign to new User
			if (rs.next()) {
				p = new Product();
				p.setProductID(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getDouble(3));
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
		return p;
	} // End of getUserById() method
	
	//****************getUserByName or login method*****************
	public Product getUserByName(String name) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Product p = null;
		
		// Assign query string to variable
		String qString = "SELECT * FROM product WHERE `name` = ?;";
		
		// Create MySqlConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(qString);
			
			// Set query parameters (?)
			stmt.setString(1, name); // ID if from String parameter passed to method
			// Run query and assign to ResultSet
			rs = stmt.executeQuery();
			// Retrieve ResultSet and assign to new User
			if (rs.next()) {
				p = new Product();
				p.setProductID(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setPrice(rs.getDouble(3));
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
		return p;
	}  // End of getUserByName() method
	
	//****************updateUser() method*****************
	public Boolean updateUser(Product p) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
		
		// Assign update string to variable
		String updateString = "update users "
				+ "set name = ?, password = ? "
				+ "where user_id = ?";
		
		// Create MySqlConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(updateString);
			
			// Set query parameters (?)
			stmt.setString(1, p.getName());
			stmt.setDouble(2, p.getPrice());
			stmt.setInt(3, p.getProductID());
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
	} // End of updateUser() method
	
	//****************removeUser() method (i.e., delete)*****************
	public Boolean removeUser(int productID) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;
		
		// Assign delete string to variable
		String deleteString = "delete from users where user_id = ?";
		
		// Create MySqlConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(deleteString);
			
			// Set query parameters (?)
			stmt.setInt(1, productID);
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
	}
	
	public List<Product> printData(List<Product> productList) {	
		System.out.print("Current course(s) in the database: ");
		for (Product p: productList)
			System.out.printf("\nProduct ID = %d\nProduct Name = %s\nProduct Price = $%.2f\n", 
					p.getProductID(), p.getName(), p.getPrice());
		
		return productList;
	}
	
	
	//Main
	public static void main(String[] args) {
		ProductDAO p_dao = new ProductDAO();
		p_dao.testConnection();
		List<Product> productList = null;
		
		// Get data from database
		try {
			productList = p_dao.getAllProducts();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		p_dao.printData(productList);
		
		// Insert data to database
		Product p = new Product();
		p.setName("coffee");
		p.setPrice(.95);
		
		try {
			p_dao.registerProduct(p);
		} catch (ClassNotFoundException | SQLException| IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Added Product:");
		System.out.printf("\nProduct ID = %d\nProduct Name = %s\nProduct Price = $%.2f\n", 
				p.getProductID(), p.getName(), p.getPrice());
		
	}
}