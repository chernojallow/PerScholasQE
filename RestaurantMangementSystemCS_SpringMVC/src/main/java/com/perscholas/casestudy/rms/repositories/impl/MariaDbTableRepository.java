package com.perscholas.casestudy.rms.repositories.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.perscholas.casestudy.rms.models.Table;
import com.perscholas.casestudy.rms.repositories.TableRepository;

@Repository("mariaDbTableRepository")
public class MariaDbTableRepository implements TableRepository {
	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;

	@Override
	public List<Table> getAllByAddressId(Integer addressId) throws ClassNotFoundException, IOException, SQLException {
		String selectById = "SELECT * FROM `table` WHERE `addressId` = " + addressId;
		List<Table> result = mariaDbJdbcTemplate.query(selectById, new TableMapper());
		return result;
	}

	public Integer getNbrOfTablesByAddressId(Integer addressId) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("addressId", addressId);
		String selectById = "SELECT COUNT(`table`.tableId) FROM `table` WHERE `addressId` = :addressId;";
		Integer result = mariaDbJdbcTemplate.queryForObject(selectById, params, Integer.class);
		return result;
	}

	@Override
	public Boolean create(Integer tableId, Integer addressId) throws SQLException, ClassNotFoundException, IOException {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("addressId", addressId);
		params.addValue("tableId", tableId);
		String createSql = "INSERT INTO `table` (`tableId`, `addressId`) VALUES (:tableId, :addressId);";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer result = mariaDbJdbcTemplate.update(createSql, params, keyHolder);

		if (result > 0)
			return true;
		return false;
	}

	@Override
	public Boolean update(Table table, Integer newOrderId) throws SQLException, ClassNotFoundException, IOException {
		Integer result = null;
		Map<String, Object> params = new HashMap<>();
		params.put("addressId", table.getAddressId());
		params.put("tableId", table.getTableId());
		params.put("orderId", newOrderId);

		String updateSql = "UPDATE `table` SET `orderId` = :orderId WHERE `addressId` = :addressId AND `tableId` = :tableId;";
		result = mariaDbJdbcTemplate.update(updateSql, params);

		if (result > 0)
			return true;
		return false;
	}

	@Override
	public Boolean remove(Integer tableId, Integer addressId) throws IOException, SQLException {
		Integer result;
		String removeSql = "DELETE FROM `table` WHERE `addressId` = :addressId AND `tableId` = :tableId;";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("addressId", addressId);
		params.put("tableId", tableId);
		result = mariaDbJdbcTemplate.update(removeSql, params);

		if (result > 0)
			return true;
		return false;
	}

	private final class TableMapper implements RowMapper<Table> {
		@Override
		public Table mapRow(ResultSet rs, int rowNum) throws SQLException {
			Table table = new Table();
			table.setTableId(rs.getInt(1));
			table.setAddressId(rs.getInt(2));
			table.setOrderId(rs.getInt(3));
			return table;
		}
	}

}
