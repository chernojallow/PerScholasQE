package com.perscholas.casestudy.rms.repositories.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.perscholas.casestudy.rms.models.Category;
import com.perscholas.casestudy.rms.repositories.CategoryRepository;

@Repository("mariaDbCategoryRepository")
public class MariaDbCategoryRepository implements CategoryRepository {
	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;

	@Override
	public List<Category> getAllByAddressId(Integer addressId) {
		String selectById = "SELECT * FROM `category` WHERE `addressId` = " + addressId;
		List<Category> result = mariaDbJdbcTemplate.query(selectById, new CategoryMapper());
		return result;
	}

	@Override
	public Integer create(Category category) throws SQLException, ClassNotFoundException, IOException {
		Integer id = -1;
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("categoryName", category.getCategoryName());
		params.addValue("addressId", category.getAddressId());
		String insertSql = "INSERT INTO category (`categoryName`, `addressId`) VALUES (:categoryName, :addressId);";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer createResult = mariaDbJdbcTemplate.update(insertSql, params, keyHolder);

		if (createResult > 0)
			id = keyHolder.getKey().intValue();
		return id;
	}

	@Override
	public Category getById(Integer categoryId) throws ClassNotFoundException, IOException, SQLException {
		String selectById = "SELECT * FROM category WHERE `categoryId` = :categoryId;";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("categoryId", categoryId);
		Category category = null;

		try {
			category = (Category) mariaDbJdbcTemplate.queryForObject(selectById, params, new CategoryMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}

		return category;
	}

	@Override
	public Boolean update(Category category) throws SQLException, ClassNotFoundException, IOException {
		Integer updateResult;
		Map<String, Object> params = new HashMap<>();
		params.put("categoryName", category.getCategoryName());
		params.put("categoryId", category.getCategoryId());
		String updateSql = "UPDATE category SET `categoryName` = :categoryName WHERE `categoryId` = :categoryId;";
		updateResult = mariaDbJdbcTemplate.update(updateSql, params);

		if (updateResult > 0)
			return true;
		return false;
	}

	@Override
	public Boolean remove(Integer categoryId) throws IOException, SQLException {
		Integer removeResult = null;
		String deleteSql = "DELETE FROM category WHERE `categoryId` = :categoryId;";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("categoryId", categoryId);
		removeResult = mariaDbJdbcTemplate.update(deleteSql, params);

		if (removeResult > 0)
			return true;
		return false;
	}

	private final class CategoryMapper implements RowMapper<Category> {
		@Override
		public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
			Category category = new Category();
			category.setCategoryId(rs.getInt(1));
			category.setCategoryName(rs.getString(2));
			category.setAddressId(rs.getInt(3));
			return category;
		}
	}
}
