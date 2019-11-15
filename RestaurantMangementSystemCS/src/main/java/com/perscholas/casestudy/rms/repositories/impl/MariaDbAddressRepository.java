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

import com.perscholas.casestudy.rms.models.Address;
import com.perscholas.casestudy.rms.repositories.AddressRepository;

@Repository("mariaDbAddressRepository")
public class MariaDbAddressRepository implements AddressRepository {
	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;

	@Override
	public Integer create(Address address) throws SQLException, ClassNotFoundException, IOException {
		Integer id = -1;
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("address1", address.getAddress1());
		params.addValue("address2", address.getAddress2());
		params.addValue("city", address.getCity());
		params.addValue("state", address.getState());
		params.addValue("postalcode", address.getPostalCode());
		String insertSql = "INSERT INTO `address` (`address1`, `address2`, `city`, `state`, `postalCode`) VALUES (:address1, :address2, :city, :state, :postalCode);";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer createResult = mariaDbJdbcTemplate.update(insertSql, params, keyHolder);

		if (createResult > 0)
			id = keyHolder.getKey().intValue();
		return id;
	}

	@Override
	public Address getById(Integer addressId) throws ClassNotFoundException, IOException, SQLException {
		String selectById = "SELECT * FROM `address` WHERE `addressId` = :addressId;";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("addressId", addressId);
		Address address = null;

		try {
			address = (Address) mariaDbJdbcTemplate.queryForObject(selectById, params, new AddressMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}

		return address;
	}

	@Override
	public Boolean update(Address address) throws SQLException, ClassNotFoundException, IOException {
		Integer updateResult;
		Map<String, Object> params = new HashMap<>();
		params.put("address1", address.getAddress1());
		params.put("address2", address.getAddress2());
		params.put("city", address.getCity());
		params.put("state", address.getState());
		params.put("postalCode", address.getPostalCode());
		params.put("addressId", address.getAddressId());
		String updateSql = "UPDATE `address` SET `address1` = :address1, `address2` = :address2, `city` = :city, `state` = :state, `postalCode` = :postalCode WHERE `addressId` = :addressId;";

		updateResult = mariaDbJdbcTemplate.update(updateSql, params);

		if (updateResult > 0)
			return true;
		return false;
	}

	@Override
	public Boolean remove(Integer addressId) throws IOException, SQLException {
		Integer removeResult = null;
		String deleteSql = "DELETE FROM `address` WHERE `addressId` = :addressId;";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("addressId", removeResult);
		removeResult = mariaDbJdbcTemplate.update(deleteSql, params);

		if (removeResult > 0)
			return true;
		return false;
	}

	private final class AddressMapper implements RowMapper<Address> {
		@Override
		public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
			Address address = new Address();
			address.setAddressId(rs.getInt(1));
			address.setAddress1(rs.getString(2));
			address.setAddress2(rs.getString(3));
			address.setCity(rs.getString(4));
			address.setState(rs.getString(5));
			address.setPostalCode(rs.getInt(6));

			return address;
		}
	}
}
