package com.perscholas.casestudy.rms.automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.perscholas.casestudy.rms.daos.UserDAO;
import com.perscholas.casestudy.rms_models.User;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserDAOTests {
	private static UserDAO u_dao;

	@BeforeClass
	public static void setUp() {
		u_dao = new UserDAO();
		u_dao.testConnection();
	}

	@Test
	public void UserGetAllTest() {
		assumeThat(u_dao.testConnection(), equalTo(true));

		try {
			List<User> userList = u_dao.getAll();
			assertThat(userList.get(0).getUserID().toString(), is("1"));
			assertThat(userList.get(1).getUserID().toString(), is("2"));
			assertThat(userList.get(2).getUserID().toString(), is("3"));
			assertThat(userList.get(0).getUsername().toString(), equalTo("xiaolin996"));
			assertThat(userList.get(1).getUsername().toString(), equalTo("chenli996"));
			assertThat(userList.get(2).getUsername().toString(), equalTo("zikacherno996"));
			assertThat(userList.get(0).getPassword().toString(), equalTo("xiaolin996."));
			assertThat(userList.get(1).getPassword().toString(), equalTo("chenli996."));
			assertThat(userList.get(2).getPassword().toString(), equalTo("zikacherno996."));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void UserRegisterTest() {
		assumeThat(u_dao.testConnection(), equalTo(true));
		User u = new User();
		u.setUsername("goutham996");
		u.setPassword("goutham996.");
		u.setRole(1);

		try {
			u.setUserID(u_dao.register(u));
			assertThat(4, equalTo(u.getUserID()));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void UserGetByIDTest() {
		assumeThat(u_dao.testConnection(), equalTo(true));

		try {
			User u = u_dao.getByID(1);
			assertThat(u.getUserID(), is(1));
			assertThat(u.getUsername(), equalTo("xiaolin996"));
			assertThat(u.getPassword(), equalTo("xiaolin996."));
			assertThat(u.getRole(), is(1));
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void UserGetByNameTest() {
		assumeThat(u_dao.testConnection(), equalTo(true));

		try {
			User u = u_dao.getByName("chenli996");
			assertThat(u.getUserID(), is(2));
			assertThat(u.getRole(), is(1));
			assertThat(u.getUsername(), equalTo("chenli996"));
			assertThat(u.getPassword(), equalTo("chenli996."));
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void UserUpdateTest() {
		assumeThat(u_dao.testConnection(), equalTo(true));
		User u = new User(3, "ivellromas996", "ivellromas996.", 2);

		try {
			u_dao.update(u);
			u = u_dao.getByID(u.getUserID());
			assertThat(u.getUserID(), is(3));
			assertThat(u.getUsername(), equalTo("ivellromas996"));
			assertThat(u.getPassword(), equalTo("ivellromas996."));
			assertThat(u.getRole(), is(2));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void UserRemoveTest() {
		assumeThat(u_dao.testConnection(), equalTo(true));

		try {
			Boolean result = u_dao.remove(1);
			assertThat(result, is(true));
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
}
