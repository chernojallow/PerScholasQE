package com.perscholas.casestudy.rms.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.perscholas.casestudy.rms.models.Order;

public interface OrderRepository {	
	Integer create(Order order) throws SQLException, ClassNotFoundException, IOException;
	
	Order getById(Integer orderId) throws ClassNotFoundException, IOException, SQLException;
	
	Boolean update(Order order) throws SQLException, ClassNotFoundException, IOException;
	
	Boolean remove(Integer orderId) throws IOException, SQLException;

	List<Order> getAllByAddressId(Integer addressId) throws SQLException;
}
