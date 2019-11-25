package com.perscholas.casestudy.rms.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.perscholas.casestudy.rms.models.Category;

public interface CategoryRepository {
	List<Category> getAllByAddressId(Integer addressId);
	
	Integer create(Category category) throws SQLException, ClassNotFoundException, IOException;
	
	Category getById(Integer categoryId) throws ClassNotFoundException, IOException, SQLException;
	
	Boolean update(Category category) throws SQLException, ClassNotFoundException, IOException;
	
	Boolean remove(Integer categoryId) throws IOException, SQLException;
}
