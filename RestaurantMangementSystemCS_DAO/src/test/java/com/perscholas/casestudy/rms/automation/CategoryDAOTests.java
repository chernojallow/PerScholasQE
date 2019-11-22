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

import com.perscholas.casestudy.rms.daos.CategoryDAO;
import com.perscholas.casestudy.rms.models.Category;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategoryDAOTests {
	private static CategoryDAO c_dao;

	@BeforeClass
	public static void setUp() {
		c_dao = new CategoryDAO();
		c_dao.testConnection();
	}

	@Test
	public void CateogryGetAllTest() {
		assumeThat(c_dao.testConnection(), equalTo(true));

		try {
			List<Category> categoryList = c_dao.getAll();

			assertThat((categoryList.get(0)).getCategoryId().toString(), is("1"));
			assertThat(categoryList.get(1).getCategoryId().toString(), is("2"));
			assertThat(categoryList.get(2).getCategoryId().toString(), is("3"));
			assertThat(categoryList.get(0).getCategoryName().toString(), equalTo("category1"));
			assertThat(categoryList.get(1).getCategoryName().toString(), equalTo("category2"));
			assertThat(categoryList.get(2).getCategoryName().toString(), equalTo("category3"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void CategoryRegisterTest() {
		assumeThat(c_dao.testConnection(), equalTo(true));
		Category c = new Category();
		c.setCategoryName("category4");

		try {
			c.setCategoryId(c_dao.create(c));
			assertThat(4, equalTo(c.getCategoryId()));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void CategoryGetByIDTest() {
		assumeThat(c_dao.testConnection(), equalTo(true));

		try {
			Category c = c_dao.getById(1);
			assertThat(c.getCategoryId(), is(1));
			assertThat(c.getCategoryName(), is("category1"));
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void CategoryUpdateTest() {
		assumeThat(c_dao.testConnection(), equalTo(true));
		Category c = new Category(4, "categoryET");

		try {
			c_dao.update(c);
			assertThat(c.getCategoryId(), equalTo(4));
			assertThat(c.getCategoryName(), equalTo("categoryET"));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void CategoryRemoveTest() {
		assumeThat(c_dao.testConnection(), equalTo(true));

		try {
			Boolean result = c_dao.remove(4);
			assertThat(result, is(true));
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
	}

}
