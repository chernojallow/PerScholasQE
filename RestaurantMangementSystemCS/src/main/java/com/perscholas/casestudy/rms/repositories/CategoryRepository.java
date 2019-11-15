package com.perscholas.casestudy.rms.repositories;

import java.io.IOException;
import java.sql.SQLException;

import com.perscholas.casestudy.rms.models.Category;

public interface CategoryRepository {
	Integer create(Category category) throws SQLException, ClassNotFoundException, IOException;
	
	Category getById(Integer categoryId) throws ClassNotFoundException, IOException, SQLException;
	
	Boolean update(Category category) throws SQLException, ClassNotFoundException, IOException;
	
	Boolean remove(Integer categoryId) throws IOException, SQLException;
}
