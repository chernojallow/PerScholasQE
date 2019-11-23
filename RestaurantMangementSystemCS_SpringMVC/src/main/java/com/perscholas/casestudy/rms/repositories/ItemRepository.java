package com.perscholas.casestudy.rms.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.perscholas.casestudy.rms.models.Item;

public interface ItemRepository {
	List<Item> getAllByAddressId(Integer addressId) throws SQLException;
	
	Integer create(Item item) throws SQLException, ClassNotFoundException, IOException;
	
	Item getById(Integer itemId) throws ClassNotFoundException, IOException, SQLException;
	
	Boolean update(Item item) throws SQLException, ClassNotFoundException, IOException;
	
	Boolean remove(Integer itemId) throws IOException, SQLException;
}
