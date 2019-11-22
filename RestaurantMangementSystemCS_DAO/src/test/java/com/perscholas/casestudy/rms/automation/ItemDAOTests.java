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

import com.perscholas.casestudy.rms.daos.ItemDAO;
import com.perscholas.casestudy.rms.models.Item;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ItemDAOTests {
	private static ItemDAO i_dao;

	@BeforeClass
	public static void setUp() {
		i_dao = new ItemDAO();
		i_dao.testConnection();
	}

	@Test
	public void ItemGetAllTest() {
		assumeThat(i_dao.testConnection(), equalTo(true));

		try {
			List<Item> itemList = i_dao.getAll();
			assertThat(itemList.get(0).getItemId().toString(), is("1"));
			assertThat(itemList.get(1).getItemId().toString(), is("2"));
			assertThat(itemList.get(2).getItemId().toString(), is("3"));
			assertThat(itemList.get(3).getItemName().toString(), equalTo("item4"));
			assertThat(itemList.get(4).getItemName().toString(), equalTo("item5"));
			assertThat(itemList.get(5).getItemName().toString(), equalTo("item6"));
			assertThat(itemList.get(6).getPrice().toString(), is("7.77"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void ItemRegisterTest() {
		assumeThat(i_dao.testConnection(), equalTo(true));
		Item i = new Item();
		i.setItemName("ayy");
		i.setCategoryId(1);
		i.setPrice(54.23);

		try {
			i.setItemId(i_dao.create(i));
			assertThat(10, equalTo(i.getItemId()));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void ItemGetByIDTest() {
		assumeThat(i_dao.testConnection(), equalTo(true));

		try {
			Item i = i_dao.getById(5);
			assertThat(i.getItemId(), is(5));
			assertThat(i.getItemName(), equalTo("item5"));
			assertThat(i.getCategoryId(), is(2));
			assertThat(i.getPrice(), is(55.55));
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void ItemUpdateTest() {
		assumeThat(i_dao.testConnection(), equalTo(true));
		Item i = new Item(3, "itemET", 1, 54.23);

		try {
			i_dao.update(i);
			i = i_dao.getById(i.getItemId());
			assertThat(i.getItemId(), is(3));
			assertThat(i.getItemName(), equalTo("itemET"));
			assertThat(i.getCategoryId(), is(1));
			assertThat(i.getPrice(), is(54.23));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void ItemRemoveTest() {
		assumeThat(i_dao.testConnection(), equalTo(true));

		try {
			Boolean result = i_dao.remove(9);
			assertThat(result, is(true));
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}
}
