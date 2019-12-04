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

import com.perscholas.casestudy.rms.models.Order;
import com.perscholas.casestudy.rms.repositories.OrderRepository;

@Repository("mariaDbOrderRepository")
public class MariaDbOrderRepository implements OrderRepository {
	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;

	@Override
	public Map<Integer, Order> getAllByOnTable(Integer addressId) {
		String selectGetAll = "SELECT o.orderId, o.addressId, o.`start`, o.`end` FROM `order` o JOIN `table` t ON o.orderId = t.orderId WHERE o.addressId = "
				+ addressId + " order BY t.tableId;";
		List<Order> oList = mariaDbJdbcTemplate.query(selectGetAll, new OrderMapper());
		Map<Integer, Order> result = new HashMap<Integer, Order>();

		for (Order o : oList)
			result.put(o.getOrderId(), o);

		return result;
	}

//	@Override
//	public List<Order> getAllByOnTable(Integer addressId) {
//		String selectGetAll = "SELECT o.orderId, o.addressId, o.`start`, o.`end` FROM `order` o JOIN `table` t ON o.orderId = t.orderId WHERE o.addressId = "
//				+ addressId + " order BY t.tableId;";
//		List<Order> result = mariaDbJdbcTemplate.query(selectGetAll, new OrderMapper());
//		return result;
//	}

	@Override
	public Integer create(Order order) throws SQLException, ClassNotFoundException, IOException {
		Integer id = -1;
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("addressId", order.getAddressId());
		params.addValue("start", order.getStart());
		params.addValue("end", order.getEnd());
		String createSql = "INSERT INTO `order` (`addressId`, `start`, `end`) VALUES (:addressId, :start, :end);";

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
		params.put("addressId", order.getAddressId());
		params.put("start", order.getStart());
		params.put("end", order.getEnd());
		params.put("orderId", order.getOrderId());

		String updateSql = "UPDATE `order` SET `addressId` = :addressId, `time` = :time WHERE `orderId` = :orderId;";
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
			order.setAddressId(rs.getInt(2));
			order.setStart(rs.getTimestamp(3));
			order.setEnd(rs.getTimestamp(4));
			return order;
		}
	}
}
