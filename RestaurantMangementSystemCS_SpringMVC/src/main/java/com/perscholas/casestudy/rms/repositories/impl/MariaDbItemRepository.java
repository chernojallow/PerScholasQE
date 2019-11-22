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

import com.perscholas.casestudy.rms.models.Item;
import com.perscholas.casestudy.rms.repositories.ItemRepository;

@Repository("mariaDbItemRepository")
public class MariaDbItemRepository implements ItemRepository {
	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;

	@Override
	public List<Item> getAll() throws SQLException {
		String selectGetAll = "SELECT * FROM item;";
		List<Item> result = mariaDbJdbcTemplate.query(selectGetAll, new ItemMapper());
		return result;
	}

	@Override
	public Integer create(Item item) throws SQLException, ClassNotFoundException, IOException {
		Integer id = -1;
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("itemName", item.getItemName());
		params.addValue("price", item.getPrice());
		params.addValue("categoryId", item.getCategoryId());
		String createSql = "INSERT INTO item (`itemName`, `price`, `categoryId`) VALUES (:itemName, :price, :categoryId);";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer createResult = mariaDbJdbcTemplate.update(createSql, params, keyHolder);

		if (createResult > 0)
			id = keyHolder.getKey().intValue();
		return id;
	}

	@Override
	public Item getById(Integer itemId) throws ClassNotFoundException, IOException, SQLException {
		String selectById = "SELECT * FROM item WHERE `itemId` = :itemId;";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("itemId", itemId);
		Item item = null;
		
		try {
			item = (Item) mariaDbJdbcTemplate.queryForObject(selectById, params, new ItemMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}
		
		return item;
	}

	@Override
	public Boolean update(Item item) throws SQLException, ClassNotFoundException, IOException {
		Integer result = null;
		Map<String, Object> params = new HashMap<>();
		params.put("itemName", item.getItemName());
		params.put("categoryId", item.getCategoryId());
		params.put("price", item.getPrice());
		params.put("itemId", item.getItemId());
		
		String updateSql = "UPDATE item SET `itemName` = :itemName, `categoryId` = :categoryId, `price` = :price WHERE `itemId` = :itemId;";
		result = mariaDbJdbcTemplate.update(updateSql, params);

		if (result > 0)
			return true;
		return false;
	}

	@Override
	public Boolean remove(Integer itemId) throws IOException, SQLException {
		Integer result;
		String removeSql = "DELETE FROM item WHERE `itemId` = :itemId;";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("itemId", itemId);
		result = mariaDbJdbcTemplate.update(removeSql, params);

		if (result > 0)
			return true;
		return false;
	}

	private final class ItemMapper implements RowMapper<Item> {
		@Override
		public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
			Item item = new Item();
			item.setItemId(rs.getInt(1));
			item.setItemName(rs.getString(2));
			item.setCategoryId(rs.getInt(3));
			item.setPrice(rs.getDouble(4));
			return item;
		}
	}
}
