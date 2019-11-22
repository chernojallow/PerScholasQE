package com.perscholas.casestudy.rms.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.perscholas.casestudy.rms.models.Order;

public interface OrderRepository {
	List<Order> getAll() throws SQLException;
	
	Integer create(Order order) throws SQLException, ClassNotFoundException, IOException;
	
	Order getById(Integer orderId) throws ClassNotFoundException, IOException, SQLException;
	
	Boolean update(Order order) throws SQLException, ClassNotFoundException, IOException;
	
	Boolean remove(Integer orderId) throws IOException, SQLException;
}
