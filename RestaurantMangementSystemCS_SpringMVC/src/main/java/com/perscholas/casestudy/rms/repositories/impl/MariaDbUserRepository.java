package com.perscholas.casestudy.rms.repositories.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.perscholas.casestudy.rms.models.User;
import com.perscholas.casestudy.rms.repositories.UserRepository;

@Repository("mariaDbUserRepository")
public class MariaDbUserRepository implements UserRepository {
	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;

	@Override
	public Integer create(User user) throws SQLException, ClassNotFoundException, IOException {
		Integer id = -1;
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("username", user.getUsername());
		params.addValue("password", user.getPassword());
		params.addValue("addressId", user.getAddressId());
		params.addValue("role", user.getRole());
		String createSql = "INSERT INTO `user` (`username`, `password`, `addressId`, `role`) VALUES (:username, :password, :addressId, :role);";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer result = mariaDbJdbcTemplate.update(createSql, params, keyHolder);

		if (result > 0)
			id = keyHolder.getKey().intValue();
		return id;
	}

	@Override
	public User getById(Integer userId) throws ClassNotFoundException, IOException, SQLException {
		String selectById = "SELECT * FROM `user` WHERE `userId` = :userId;";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		User user = null;

		try {
			user = (User) mariaDbJdbcTemplate.queryForObject(selectById, params, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}

		return user;
	}

	@Override
	public User getByName(String username) throws ClassNotFoundException, IOException, SQLException {
		String selectByName = "SELECT * FROM `user` WHERE `username` = :username;";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", username);
		User user = null;

		try {
			user = (User) mariaDbJdbcTemplate.queryForObject(selectByName, params, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}

		return user;
	}

	@Override
	public Boolean update(User user) throws SQLException, ClassNotFoundException, IOException {
		Integer result = null;
		Map<String, Object> params = new HashMap<>();
		params.put("username", user.getUsername());
		params.put("password", user.getPassword());
		params.put("addressId", user.getAddressId());
		params.put("role", user.getRole());
		params.put("userId", user.getUserId());

		String updateSql = "UPDATE `user` SET `username` = :username, `password` = :password, `addressId` = :addressId, `role` = :role WHERE `userId` = :userId;";
		result = mariaDbJdbcTemplate.update(updateSql, params);

		if (result > 0)
			return true;
		return false;
	}

	@Override
	public Boolean remove(Integer userId) throws IOException, SQLException {
		Integer result;
		String removeSql = "DELETE FROM `user` WHERE `userId` = :userId;";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		result = mariaDbJdbcTemplate.update(removeSql, params);

		if (result > 0)
			return true;
		return false;
	}

	private final class UserMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setUserId(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setAddressId(rs.getInt(4));
			user.setRole(rs.getInt(5));
			return user;
		}
	}
}
