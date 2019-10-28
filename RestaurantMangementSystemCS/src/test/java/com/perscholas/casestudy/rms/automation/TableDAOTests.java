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

import com.perscholas.casestudy.rms.daos.TableDAO;
import com.perscholas.casestudy.rms_models.Table;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TableDAOTests {
	private static TableDAO t_dao;

	@BeforeClass
	public static void setUp() {
		t_dao = new TableDAO();
		t_dao.testConnection();
	}

	@Test
	public void TableGetAllTest() {
		assumeThat(t_dao.testConnection(), equalTo(true));

		try {
			List<Table> tableList = t_dao.getAll();
			assertThat(tableList.get(0).getTableID().toString(), is("1"));
			assertThat(tableList.get(2).getTableID().toString(), is("3"));
			assertThat(tableList.get(4).getTableID().toString(), is("5"));
			assertThat(tableList.get(6).getUserID().toString(), is("3"));
			assertThat(tableList.get(8).getUserID().toString(), is("3"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void TableRegisterTest() {
		assumeThat(t_dao.testConnection(), equalTo(true));
		Table t = new Table();
		t.setUserID(2);

		try {
			t.setTableID(t_dao.register(t));
			assertThat(10, equalTo(t.getTableID()));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void TableGetByIDTest() {
		assumeThat(t_dao.testConnection(), equalTo(true));

		try {
			Table t = t_dao.getByID(5, 2);
			assertThat(t.getTableID(), is(5));
			assertThat(t.getUserID(), is(2));
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void TableUpdateTest() {
		assumeThat(t_dao.testConnection(), equalTo(true));
		Table t = new Table(3, 3);

		try {
			t_dao.update(t, 1);
			t = t_dao.getByID(t.getTableID(), t.getUserID());
			assertThat(t.getTableID(), is(3));
			assertThat(t.getUserID(), is(3));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void TableRemoveTest() {
		assumeThat(t_dao.testConnection(), equalTo(true));

		try {
			Boolean result = t_dao.remove(9);
			assertThat(result, is(true));
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
}
