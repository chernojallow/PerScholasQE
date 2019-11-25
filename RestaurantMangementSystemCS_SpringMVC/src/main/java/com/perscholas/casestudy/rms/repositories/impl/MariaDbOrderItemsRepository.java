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

import com.perscholas.casestudy.rms.models.OrderItems;
import com.perscholas.casestudy.rms.repositories.OrderItemsRepository;

@Repository("mariaDbOrderItemsRepository")
public class MariaDbOrderItemsRepository implements OrderItemsRepository {
	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;

	@Override
	public List<OrderItems> getAllByAddressIdOnTable(Integer tableId) throws SQLException {
		String selectGetAll = "SELECT order_items.orderId, order_items.itemId, order_items.quantity, order_items.subtotal FROM order_items JOIN `order` ON order_items.orderId = `order`.orderId JOIN `table` ON `order`.orderId = `table`.orderId JOIN address ON `table`.addressId = address.addressId WHERE address.addressId = "
				+ tableId;
		List<OrderItems> result = mariaDbJdbcTemplate.query(selectGetAll, new OrderItemsMapper());
		return result;
	}

	@Override
	public List<OrderItems> getAllByAddressId(Integer addressId) throws SQLException {
		String selectGetAll = "SELECT order_items.orderId, order_items.itemId, order_items.quantity, order_items.subtotal FROM order_items JOIN `order` ON order_items.orderId = `order`.orderId JOIN address ON `order`.addressId = address.addressId WHERE address.addressId = "
				+ addressId;
		List<OrderItems> result = mariaDbJdbcTemplate.query(selectGetAll, new OrderItemsMapper());
		return result;
	}

	@Override
	public Boolean create(OrderItems orderItem) throws SQLException, ClassNotFoundException, IOException {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("orderId", orderItem.getOrderId());
		params.addValue("itemId", orderItem.getItemId());
		params.addValue("quantity", orderItem.getQuantity());
		String createSql = "INSERT INTO `order_items` (`orderId`, `itemId`, `quantity`, `subtotal`) "
				+ "VALUES (:orderId, :itemId, :quantity, ROUND((SELECT `price` FROM `item` WHERE `itemId` = "
				+ orderItem.getItemId() + ") * " + orderItem.getQuantity() + ", 2));";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer createResult = mariaDbJdbcTemplate.update(createSql, params, keyHolder);

		if (createResult > 0)
			return true;
		return false;
	}

	@Override
	public OrderItems getById(Integer orderId, Integer itemId)
			throws ClassNotFoundException, IOException, SQLException {
		String selectById = "SELECT * FROM `order_items` WHERE `orderId` = :orderId AND `itemId` = :itemId;";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderId", orderId);
		params.put("itemId", itemId);
		OrderItems orderItem = null;

		try {
			orderItem = (OrderItems) mariaDbJdbcTemplate.queryForObject(selectById, params, new OrderItemsMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}

		return orderItem;
	}

	@Override
	public Boolean update(OrderItems orderItem, Integer newItemId)
			throws SQLException, ClassNotFoundException, IOException {
		Integer result = null;
		Map<String, Object> params = new HashMap<>();
		params.put("itemId", orderItem.getItemId());
		params.put("quantity", orderItem.getQuantity());
		params.put("orderId", orderItem.getOrderId());
		params.put("newItemId", newItemId);

		String updateSql = "UPDATE `order_items` SET `itemId` = :itemId, `quantity` = :quantity, `subtotal` = "
				+ "(ROUND((SELECT `price` FROM `item` WHERE `itemId` = " + orderItem.getItemId() + ") * "
				+ orderItem.getQuantity() + ", 2)) WHERE `orderId` = :orderId && `itemId` = :newItemId;";
		result = mariaDbJdbcTemplate.update(updateSql, params);

		if (result > 0)
			return true;
		return false;
	}

	@Override
	public Boolean remove(Integer orderId, Integer itemId) throws IOException, SQLException {
		Integer result = null;
		String deleteSql = "DELETE FROM `order_items` WHERE `orderId` = :orderId && `itemId` = :itemId;";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("orderId", orderId);
		params.put("itemId", itemId);
		result = mariaDbJdbcTemplate.update(deleteSql, params);

		if (result > 0)
			return true;
		return false;
	}

	private final class OrderItemsMapper implements RowMapper<OrderItems> {
		@Override
		public OrderItems mapRow(ResultSet rs, int rowNum) throws SQLException {
			OrderItems orderItem = new OrderItems();
			orderItem.setOrderId(rs.getInt(1));
			orderItem.setItemId(rs.getInt(2));
			orderItem.setQuantity(rs.getInt(3));
			orderItem.setSubtotal(rs.getDouble(4));
			return orderItem;
		}
	}
}
