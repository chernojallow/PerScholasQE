package com.perscholas.junit.sba9.automation;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;
import static org.hamcrest.number.OrderingComparison.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.perscholas.junit.sba6.InvalidPasswordException;
import com.perscholas.junit.sba6.User;
import com.perscholas.junit.sba6.UserDAO;

@RunWith(Parameterized.class)
public class UserDAOParameterizedTest {
	// Declare attributes
	private static UserDAO u_dao;
	private Integer userId;
	private String name;
	private String password;
	private Double javaScore;
	private Double sqlScore;

	public UserDAOParameterizedTest(Integer userId, String name, String password, Double javaScore, Double sqlScore) {
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.javaScore = javaScore;
		this.sqlScore = sqlScore;
	}

	@Parameters()
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 1, "ChenLi", "chenmingli", 80.2, 80.9 },
				{ 2, "GouthamBuvanendiran", "adityagoutham", 85.4, 85.7 },
				{ 3, "ChernoJallow", "zikacherno", 60.1, 60.8 }, 
				{ 4, "LinXiao", "xiaolin996", 70.0, 70.6 } });
	}

	@BeforeClass
	public static void setUp() {
		u_dao = new UserDAO();
		u_dao.testConnection();
	}

	@AfterClass
	public static void cleanUp() throws SQLException {
		u_dao.cleanUp();
	}

	@Test
	public void registerTest() throws InvalidPasswordException {
		assumeThat(u_dao.testConnection(), is(true));
		User u = new User();
		u.setName(name);
		u.setPassword(password);
		u.setJavaScore(javaScore);
		u.setSqlScore(sqlScore);

		try {
			u.setUserId(u_dao.register(u));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}

		assertThat(u.getUserId(), allOf(greaterThan(0), lessThan(5)));

		System.out.println("Added User:");
		System.out.println(u.toString());

	}

	@Test
	public void getTests() {
		assumeThat(u_dao.testConnection(), is(true));
		List<User> userList = null;
		User u = null;

		try {
			userList = u_dao.getAll();
		} catch (SQLException | InvalidPasswordException e) {
			e.printStackTrace();
		}

		assertThat(userList.size(), is(not(0)));

		if (userList.size() == 2) {
			try {
				u = u_dao.getByID(userId);
				assertThat(u.getName(), equalTo("GouthamBuvanendiran"));

				System.out.println("\ngetByID Test");
				System.out.printf("User ID = %d\nUser Name = %s\nUser Password = %s\nUser Java Score"
						+ " = %.2f\nUser SQL Score = %.2f\n\n", u.getUserId(), u.getName(), 
						u.getPassword(), u.getJavaScore(), u.getSqlScore());
			} catch (ClassNotFoundException | IOException | SQLException | InvalidPasswordException e) {
				e.printStackTrace();
			}

		}

		if (userList.size() == 3) {
			try {
				u = u_dao.getByName("ChernoJallow");
				assertThat(u.getPassword(), allOf(startsWith("z"), containsString("cherno")));

				System.out.println("\ngetByName Test");
				System.out.printf("User ID = %d\nUser Name = %s\nUser Password = %s\nUser Java Score "
						+ "= %.2f\nUser SQL Score = %.2f\n\n", u.getUserId(), u.getName(), 
						u.getPassword(), u.getJavaScore(), u.getSqlScore());

			} catch (ClassNotFoundException | IOException | SQLException | InvalidPasswordException e) {
				e.printStackTrace();
			}

		}

		if (userList.size() == 4) {
			System.out.printf("\ngetAllTest");
			for (User n : userList)
				System.out.printf(
						"\nUser ID = %d\nUser Name = %s\nUser Password = %s\nUser Java Score = %.2f"
								+ "\nUser SQL Score = %.2f\n",
						n.getUserId(), n.getName(), n.getPassword(), n.getJavaScore(), n.getSqlScore());

			try {
				u = new User(3, "ChrisEjiofor", "christopher", 75.3, 75.5);
				if (u_dao.updateUser(u)) {
					userList = u_dao.getAll();
					assertThat(u, notNullValue());
					System.out.println("\nUpdated userID " + u.getUserId());
				}

				if (u_dao.removeUser(userId)) {
					userList = u_dao.getAll();
					assertThat(userList.size(), is(not(4)));
					System.out.println("Deleted userID " + userId);
				}

			} catch (InvalidPasswordException | ClassNotFoundException | SQLException | IOException e) {
				e.printStackTrace();
			}

			System.out.println("\ngetByID Test after update & delete");
			for (User n : userList)
				System.out.printf("\nUser ID = %d\nUser Name = %s\nUser Password = %s\nUser Java "
						+ "Score = %.2f\nUser SQL Score = %.2f\n", n.getUserId(), n.getName(), 
						n.getPassword(), n.getJavaScore(), n.getSqlScore());

//			try {
//				u_dao.removeUser(1);
//				u_dao.removeUser(2);
//				u_dao.removeUser(3);
//			} catch (IOException | SQLException e) {
//				e.printStackTrace();
//			}
		}

	}

}
