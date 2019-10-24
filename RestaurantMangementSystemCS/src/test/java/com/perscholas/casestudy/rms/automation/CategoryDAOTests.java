package com.perscholas.casestudy.rms.automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.perscholas.casestudy.rms.daos.CategoryDAO;
import com.perscholas.casestudy.rms_models.Category;

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

			assertThat((categoryList.get(0)).getCategoryID().toString(), is("1"));
			assertThat(categoryList.get(1).getCategoryID().toString(), is("2"));
			assertThat(categoryList.get(2).getCategoryID().toString(), is("3"));
			assertThat(categoryList.get(0).getCategoryName().toString(), equalTo("hello"));
			assertThat(categoryList.get(1).getCategoryName().toString(), equalTo("hey"));
			assertThat(categoryList.get(2).getCategoryName().toString(), equalTo("hi"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void CategoryRegisterTest() {
		assumeThat(c_dao.testConnection(), equalTo(true));
		Category c = new Category();
		c.setCategoryName("ayy");

		try {
			c.setCategoryID(c_dao.register(c));
			assertThat(4, equalTo(c.getCategoryID()));
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void CategoryGetByIDTest() {
		assumeThat(c_dao.testConnection(), equalTo(true));

		try {
			Category c = c_dao.getByID(1);
			assertThat(c.getCategoryID(), is(1));
			assertThat(c.getCategoryName(), is("hello"));
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void CategoryGetByNameTest() {
		assumeThat(c_dao.testConnection(), equalTo(true));

		try {
			Category c = c_dao.getByName("hey");
			assertThat(c.getCategoryID(), equalTo(2));
			assertThat(c.getCategoryName(), equalTo("hey"));
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void CategoryUpdateTest() {
		assumeThat(c_dao.testConnection(), equalTo(true));
		Category c = new Category(3, "ayyy");
		
		try {
			c_dao.update(c);
			assertThat(c.getCategoryID(), equalTo(3));
			assertThat(c.getCategoryName(), equalTo("ayyy"));
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
