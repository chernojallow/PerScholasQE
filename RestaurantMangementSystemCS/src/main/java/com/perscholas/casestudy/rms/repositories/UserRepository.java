package com.perscholas.casestudy.rms.repositories;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.perscholas.casestudy.rms.models.User;

public interface UserRepository {
	Boolean testConnection();

	List<User> getAll() throws SQLException;

	Integer create(User user) throws SQLException, ClassNotFoundException, IOException;

	User getById(Integer userId) throws ClassNotFoundException, IOException, SQLException;

	User getByName(String username) throws ClassNotFoundException, IOException, SQLException;

	Boolean update(User u) throws SQLException, ClassNotFoundException, IOException;

	Boolean remove(Integer userId) throws IOException, SQLException;

	void DAOTesting() throws ClassNotFoundException, IOException, SQLException;
}
