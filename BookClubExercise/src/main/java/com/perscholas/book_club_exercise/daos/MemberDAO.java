package com.perscholas.book_club_exercise.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.perscholas.book_club_exercise.models.Member;

public class MemberDAO {
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
	public List<Member> getAll() throws SQLException {
		// Declare variables
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Member m = null;
		List<Member> memberList = null;

		// Assign query string to a string
		String qString = "SELECT * FROM member;";
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
			memberList = new ArrayList<Member>();
			// Read the ResultSet instance
			while (rs.next()) {
				// Each iteration creates a new object
				m = new Member();
				// Assign columns/fields to related fields in the object
				// Represent column numbers/positions
				m.setMemberID(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setEmail(rs.getString(3));
				m.setPassword(rs.getString(4));
				m.setfGenre(rs.getString(5));
				// Add the user to the list
				memberList.add(m);
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
		return memberList;
	} // End of getAll() method

	// ****************register() method*****************
	public Integer register(Member member) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		// Assign insert statement string to variable
		String insertString = "INSERT INTO member (`name`, `email`, `password`, `fGenre`) VALUES (?, ?, ?, ?);";

		int ID = -1;
		String[] COL = { "`memberID`" };

		DBConnection dbConn = new DBConnection();

		try {
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(insertString, COL);

			stmt.setString(1, member.getName());
			stmt.setString(2, member.getEmail());
			stmt.setString(3, member.getPassword());
			stmt.setString(4, member.getfGenre());

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
	public Member getByID(Integer memberID) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Member m = null;

		// Assign query string to variable
		String qString = "SELECT * FROM member WHERE `memberID` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();

		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(qString);

			// Set query parameters (?)
			stmt.setInt(1, memberID);

			// Run query and assign to ResultSet
			rs = stmt.executeQuery();

			// Retrieve ResultSet and assign to new object
			if (rs.next()) {
				m = new Member();
				m.setMemberID(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setEmail(rs.getString(3));
				m.setPassword(rs.getString(4));
				m.setfGenre(rs.getString(5));
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
		return m;
	} // End of getByID() method

	// ****************getByName or login method*****************
	public Member getByName(String name) throws ClassNotFoundException, IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Member m = null;

		// Assign query string to variable
		String qString = "SELECT * FROM member WHERE `name` = ?;";

		// Create DBConnection class instance
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
			// Retrieve ResultSet and assign to new object
			if (rs.next()) {
				m = new Member();
				m.setMemberID(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setEmail(rs.getString(3));
				m.setPassword(rs.getString(4));
				m.setfGenre(rs.getString(5));
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
		return m;
	} // End of getByName() method

	// ****************update() method*****************
	public Boolean update(Member m) throws SQLException, ClassNotFoundException, IOException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign update string to variable
		String updateString = "UPDATE member SET `name` = ?, `email` = ?, `password` = ?, `fGenre` = ? WHERE `memberID` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(updateString);

			// Set query parameters (?)
			stmt.setString(1, m.getName());
			stmt.setString(2, m.getEmail());
			stmt.setString(3, m.getPassword());
			stmt.setString(4, m.getfGenre());
			stmt.setInt(5, m.getMemberID());
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
	public Boolean remove(Integer memberID) throws IOException, SQLException {
		// Declare variables
		Connection conn = null;
		PreparedStatement stmt = null;
		Integer updateResult = null;

		// Assign delete string to variable
		String deleteString = "DELETE FROM member WHERE `memberID` = ?;";

		// Create DBConnection class instance
		DBConnection dbConn = new DBConnection();
		// Begin try/catch block to query the database
		try {
			// Connect to database and assign query string to PreparedStatement object
			conn = dbConn.getConnection();
			stmt = conn.prepareStatement(deleteString);

			// Set query parameters (?)
			stmt.setInt(1, memberID);
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
	} // End of remove() method

	// ****************DAOTesting() method*****************
	public static void DAOTesting() {
		MemberDAO m_dao = new MemberDAO();
		m_dao.testConnection();

		System.out.println("getByID()");
		try {
			System.out.println(m_dao.getByID(1).toString());
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}

		System.out.println("getByName()");
		try {
			System.out.println(m_dao.getByName("Chen Li").toString());
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}

		System.out.println("register()");
		Member m = new Member();
		m.setName("Lin Xiao");
		m.setEmail("xiaolin996@gmail.com");
		m.setPassword("xiaolin996");
		m.setfGenre("Science Fiction");

		try {
			System.out.println(m_dao.getByID(m_dao.register(m)));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("update()");
		m = new Member(1, "Goutham Buvan", "gouthambuvan123@gmail.com", "goutham123", "Action");

		try {
			if (m_dao.update(m))
				System.out.println(m_dao.getByID(m.getMemberID()));
			else
				System.out.println("update failed");
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}

		System.out.println("remove()");
		try {
			m = m_dao.getByID(3);
			if (m_dao.remove(3))
				System.out.println(m.toString());
			else
				System.out.println("remove failed");
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}

		System.out.println("getAll()");
		try {
			List<Member> mlist = m_dao.getAll();
			for (Member m1 : mlist)
				System.out.println(m1.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//	// ****************main() method testing*****************
//	public static void main(String[] args) {
//		DAOTesting();
//	} // End of main() method
	
}
