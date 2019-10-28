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

import com.perscholas.casestudy.rms.daos.OrderItemsDAO;
import com.perscholas.casestudy.rms_models.OrderItems;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderItemsDAOTests {
	private static OrderItemsDAO oi_dao;

	@BeforeClass
	public static void setUp() {
		oi_dao = new OrderItemsDAO();
		oi_dao.testConnection();
	}

	@Test
	public void OrderItemsGetAllTest() {
		assumeThat(oi_dao.testConnection(), equalTo(true));

		try {
			List<OrderItems> orderItemsList = oi_dao.getAll();

			assertThat(orderItemsList.get(1).getOrderID().toString(), is("1"));
			assertThat(orderItemsList.get(3).getCategoryID().toString(), is("1"));
			assertThat(orderItemsList.get(4).getCategoryID().toString(), is("2"));
			assertThat(orderItemsList.get(5).getCategoryID().toString(), is("3"));
			assertThat(orderItemsList.get(6).getQuantity().toString(), equalTo("7"));
			assertThat(orderItemsList.get(7).getQuantity().toString(), equalTo("8"));
			assertThat(orderItemsList.get(8).getQuantity().toString(), equalTo("9"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void OrderItemsRegisterTest() {
		assumeThat(oi_dao.testConnection(), equalTo(true));
		OrderItems oi = new OrderItems();
		oi.setOrderID(9);
		oi.setCategoryID(3);
		oi.setQuantity(10);

		try {
			oi.setOrderID(oi_dao.register(oi));
			assertThat(10, equalTo(oi.getQuantity()));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void OrderItemsGetByIDTest() {
		assumeThat(oi_dao.testConnection(), equalTo(true));

		try {
			OrderItems oi = oi_dao.getByID(3, 2);
			assertThat(oi.getOrderID(), is(3));
			assertThat(oi.getCategoryID(), is(2));
			assertThat(oi.getQuantity(), is(8));
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void OrderItemsUpdateTest() {
		assumeThat(oi_dao.testConnection(), equalTo(true));
		OrderItems oi = new OrderItems(2, 2, 11);

		try {
			oi_dao.update(oi, 2);
			assertThat(oi.getOrderID(), is(2));
			assertThat(oi.getCategoryID(), is(2));
			assertThat(oi.getQuantity(), is(11));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void OrderItemsRemoveTest() {
		assumeThat(oi_dao.testConnection(), equalTo(true));

		try {
			Boolean result = oi_dao.remove(1, 3);
			assertThat(result, is(true));
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

}
