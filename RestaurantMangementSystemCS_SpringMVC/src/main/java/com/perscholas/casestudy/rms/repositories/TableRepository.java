package com.perscholas.casestudy.rms.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.perscholas.casestudy.rms.models.Table;

public interface TableRepository {
	List<Table> getAllByAddressId(Integer addressId) throws ClassNotFoundException, IOException, SQLException;
	
	Integer getNbrOfTablesByAddressId(Integer addressId);
	
	Boolean create(Integer tableId, Integer addressId) throws SQLException, ClassNotFoundException, IOException;

	Boolean update(Table table, Integer newOrderId) throws SQLException, ClassNotFoundException, IOException;

	Boolean remove(Integer tableId, Integer addressId) throws IOException, SQLException;
}
