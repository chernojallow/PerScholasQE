package com.perscholas.casestudy.rms.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.perscholas.casestudy.rms.models.Table;

public interface TableRepository {
	Boolean testConnection();
	
	List<Table> getAll() throws SQLException;
	
	Boolean create(Integer userId, Integer tableId) throws SQLException, ClassNotFoundException, IOException;
	
	Table getById(Integer tableId, Integer userId) throws ClassNotFoundException, IOException, SQLException;
	
	Boolean update(Table t, Integer newOrderId) throws SQLException, ClassNotFoundException, IOException;
	
	Boolean remove(Integer tableId, Integer userId) throws IOException, SQLException;
	
	void DAOTesting() throws ClassNotFoundException, IOException, SQLException;
}
