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

import com.perscholas.casestudy.rms.models.Order;
import com.perscholas.casestudy.rms.repositories.OrderRepository;

public class MariaDbOrderRepository implements OrderRepository {
	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;
	
	@Override
	public List<Order> getAll() throws SQLException {
		String selectGetAll = "SELECT * FROM `order`;";
		List<Order> result = mariaDbJdbcTemplate.query(selectGetAll, new OrderMapper());
		return result;
	}

	@Override
	public Integer create(Order order) throws SQLException, ClassNotFoundException, IOException {
		Integer id = -1;
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("userId", order.getUserId());
		params.addValue("time", order.getTime());
		String createSql = "INSERT INTO `order` (`userId`, `time`) VALUES (:userId, :time);";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer result = mariaDbJdbcTemplate.update(createSql, params, keyHolder);

		if (result > 0)
			id = keyHolder.getKey().intValue();
		return id;
	}

	@Override
	public Order getById(Integer orderId) throws ClassNotFoundException, IOException, SQLException {
		String selectById = "SELECT * FROM `order` WHERE `orderId` = :orderId;";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderId", orderId);
		Order order = null;
		
		try {
			order = (Order) mariaDbJdbcTemplate.queryForObject(selectById, params, new OrderMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}
		
		return order;
	}

	@Override
	public Boolean update(Order order) throws SQLException, ClassNotFoundException, IOException {
		Integer result = null;
		Map<String, Object> params = new HashMap<>();
		params.put("userId", order.getUserId());
		params.put("time", order.getTime());
		params.put("orderId", order.getOrderId());
		
		String updateSql = "UPDATE `order` SET `userId` = :userId, `time` = :time WHERE `orderId` = :orderId;";
		result = mariaDbJdbcTemplate.update(updateSql, params);

		if (result > 0)
			return true;
		return false;
	}

	@Override
	public Boolean remove(Integer orderId) throws IOException, SQLException {
		Integer result = null;
		String removeSql = "DELETE FROM `order` WHERE `orderId` = :orderId;";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderId", orderId);
		result = mariaDbJdbcTemplate.update(removeSql, params);

		if (result > 0)
			return true;
		return false;
	}

	private final class OrderMapper implements RowMapper<Order> {
		@Override
		public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			Order order = new Order();
			order.setOrderId(rs.getInt(1));
			order.setUserId(rs.getInt(2));
			order.setTime(rs.getTimestamp(3));
			return order;
		}
	}
}
