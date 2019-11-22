package com.perscholas.spring_mvc_sba.classified_adds.repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.perscholas.spring_mvc_sba.classified_adds.models.User;
import com.perscholas.spring_mvc_sba.classified_adds.repositories.UserRepository;

@Repository("mariaDbUserRepository")
public class MariaDbUserRepository implements UserRepository {

	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;

	@Override
	public void addUser(User u) {
		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("username", u.getUsername());
		params.addValue("password", u.getPassword());
		String addQuery = "INSERT INTO `users` (`username`, `password`) VALUES " + "(:username, :password)";

		Integer createResult = mariaDbJdbcTemplate.update(addQuery, params);

		if (createResult > 0) {
			System.out.println("Error creating user in DB");
		}

		return;
	}

	public User getUser(String username) {
		User u = null;
		String query = "SELECT * FROM `users` WHERE `username` = :username";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", username);

		try {
			u = (User) mariaDbJdbcTemplate.queryForObject(query, params, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}

		return u;
	}

	private final class UserMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUsername(rs.getString(1));
			user.setPassword(rs.getString(2));
			return user;
		}
	}

}
