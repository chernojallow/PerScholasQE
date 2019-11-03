package com.perscholas.casestudy.rms.automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.perscholas.casestudy.rms.daos.OrderDAO;
import com.perscholas.casestudy.rms_models.Order;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderDAOTests {
	private static OrderDAO o_dao;

	@BeforeClass
	public static void setUp() {
		o_dao = new OrderDAO();
		o_dao.testConnection();
	}

	@Test
	public void OrderGetAllTest() {
		assumeThat(o_dao.testConnection(), equalTo(true));

		try {
			List<Order> orderList = o_dao.getAll();

			assertThat(orderList.get(0).getOrderID().toString(), is("1"));
			assertThat(orderList.get(1).getOrderID().toString(), is("2"));
			assertThat(orderList.get(2).getOrderID().toString(), is("3"));
			assertThat(orderList.get(3).getUserID().toString(), equalTo("2"));
			assertThat(orderList.get(6).getTableID().toString(), equalTo("7"));
			assertThat(orderList.get(7).getTableID().toString(), equalTo("8"));
			assertThat(orderList.get(8).getTableID().toString(), equalTo("9"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void OrderRegisterTest() {
		assumeThat(o_dao.testConnection(), equalTo(true));
		Order o = new Order();
		o.setUserID(2);
		o.setTableID(5);
		o.setTime(new Timestamp(System.currentTimeMillis()));

		try {
			o.setOrderID(o_dao.register(o));
			assertThat(10, equalTo(o.getOrderID()));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void OrderGetByIDTest() {
		assumeThat(o_dao.testConnection(), equalTo(true));

		try {
			Order o = o_dao.getByID(6);
			assertThat(o.getOrderID(), is(6));
			assertThat(o.getUserID(), is(2));
			assertThat(o.getTableID(), is(6));
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void OrderUpdateTest() {
		assumeThat(o_dao.testConnection(), equalTo(true));
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		Order o = new Order(9, 3, 9, ts);

		try {
			o_dao.update(o);
			assertThat(o.getOrderID(), is(9));
			assertThat(o.getUserID(), is(3));
			assertThat(o.getTableID(), is(9));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void OrderRemoveTest() {
		assumeThat(o_dao.testConnection(), equalTo(true));

		try {
			Boolean result = o_dao.remove(9);
			assertThat(result, is(true));
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

}
