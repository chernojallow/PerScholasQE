package com.perscholas.casestudy.rms.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.perscholas.casestudy.rms.models.Order;

public interface OrderRepository {	
	Integer create(Order order) throws SQLException, ClassNotFoundException, IOException;
	
	Order getById(Integer orderId) throws ClassNotFoundException, IOException, SQLException;
	
	Boolean update(Order order) throws SQLException, ClassNotFoundException, IOException;
	
	Boolean remove(Integer orderId) throws IOException, SQLException;

	
	Map<Integer, Order> getAllByOnTable(Integer addressId);
	//List<Order> getAllByOnTable(Integer addressId);
}
