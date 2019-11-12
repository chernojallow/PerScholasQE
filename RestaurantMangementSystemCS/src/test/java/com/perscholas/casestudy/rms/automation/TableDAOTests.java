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
import com.perscholas.casestudy.rms.models.Table;

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
			assertThat(tableList.get(0).getTableId().toString(), is("1"));
			assertThat(tableList.get(2).getTableId().toString(), is("1"));
			assertThat(tableList.get(4).getTableId().toString(), is("2"));
			assertThat(tableList.get(6).getUserId().toString(), is("1"));
			assertThat(tableList.get(8).getUserId().toString(), is("3"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void TableRegisterTest() {
		assumeThat(t_dao.testConnection(), equalTo(true));

		try {
			assertThat(t_dao.create(1, 6), equalTo(true));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void TableGetByIDTest() {
		assumeThat(t_dao.testConnection(), equalTo(true));

		try {
			Table t = t_dao.getById(3, 2);
			assertThat(t.getTableId(), is(3));
			assertThat(t.getUserId(), is(2));
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
			t = t_dao.getById(t.getTableId(), t.getUserId());
			assertThat(t.getTableId(), is(3));
			assertThat(t.getUserId(), is(3));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void TableRemoveTest() {
		assumeThat(t_dao.testConnection(), equalTo(true));

		try {
			assertThat(t_dao.remove(1, 1), is(true));
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
}
