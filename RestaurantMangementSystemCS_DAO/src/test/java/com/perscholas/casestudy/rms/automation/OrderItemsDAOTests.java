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
import com.perscholas.casestudy.rms.models.OrderItems;

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

			assertThat(orderItemsList.get(1).getOrderId().toString(), is("2"));
			assertThat(orderItemsList.get(6).getQuantity().toString(), equalTo("1"));
			assertThat(orderItemsList.get(7).getQuantity().toString(), equalTo("2"));
			assertThat(orderItemsList.get(8).getQuantity().toString(), equalTo("3"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void OrderItemsRegisterTest() {
		assumeThat(oi_dao.testConnection(), equalTo(true));
		OrderItems oi = new OrderItems();
		oi.setOrderId(9);
		oi.setItemId(7);
		oi.setQuantity(4);

		try {
			if (oi_dao.create(oi))
				oi_dao.getById(oi.getOrderId(), oi.getItemId());
			assertThat(4, equalTo(oi.getQuantity()));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void OrderItemsGetByIDTest() {
		assumeThat(oi_dao.testConnection(), equalTo(true));

		try {
			OrderItems oi = oi_dao.getById(3, 3);
			assertThat(oi.getOrderId(), is(3));
			assertThat(oi.getQuantity(), is(3));
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
			assertThat(oi.getOrderId(), is(2));
			assertThat(oi.getItemId(), is(2));
			assertThat(oi.getQuantity(), is(11));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void OrderItemsRemoveTest() {
		assumeThat(oi_dao.testConnection(), equalTo(true));

		try {
			Boolean result = oi_dao.remove(7, 7);
			assertThat(result, is(true));
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

}
