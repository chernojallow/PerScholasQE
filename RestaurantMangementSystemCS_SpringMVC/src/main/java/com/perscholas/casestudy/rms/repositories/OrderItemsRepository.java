package com.perscholas.casestudy.rms.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.perscholas.casestudy.rms.models.OrderItems;

public interface OrderItemsRepository {
	List<OrderItems> getAll() throws SQLException;

	Boolean create(OrderItems orderItem) throws SQLException, ClassNotFoundException, IOException;

	OrderItems getById(Integer orderId, Integer itemId) throws ClassNotFoundException, IOException, SQLException;

	Boolean update(OrderItems orderItem, Integer newItemId) throws SQLException, ClassNotFoundException, IOException;

	Boolean remove(Integer orderId, Integer itemId) throws IOException, SQLException;
}
