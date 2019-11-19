package com.perscholas.spring_mvc_sba.classified_adds.repositories.impl;

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

import com.perscholas.spring_mvc_sba.classified_adds.models.Ad;
import com.perscholas.spring_mvc_sba.classified_adds.repositories.AdRepository;

@Repository("mariaDbAdRepository")
public class MariaDbAdRepository implements AdRepository {

	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;

	@Override
	public List<Ad> showAds() {
		String selectAds = "SELECT * FROM `ads`";
		List<Ad> result = mariaDbJdbcTemplate.query(selectAds, new AdMapper());
		return result;
	}

	@Override
	public Integer addAd(Ad ad) {
		Integer id = -1;
		MapSqlParameterSource params = new MapSqlParameterSource();

		params.addValue("name", ad.getName());
		params.addValue("price", ad.getPrice());
		String createBookSql = "INSERT INTO `ads` (`name`, `price`) VALUES " + "(:name, :price)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer createResult = mariaDbJdbcTemplate.update(createBookSql, params, keyHolder);

		if (createResult > 0)
			id = keyHolder.getKey().intValue();
		return id;
	}

	@Override
	public Boolean removeAd(Integer adId) {
		Integer result;
		String deleteSql = "DELETE FROM `ads` WHERE `adsId` = :id";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", adId);

		result = mariaDbJdbcTemplate.update(deleteSql, params);
		if (result > 0)
			return true;
		return false;
	}

	@Override
	public Boolean orderAd(Integer id) {
		Integer result;
		String updateSql = "UPDATE `ads` SET status = 'Sold' WHERE `adsId` = :id;";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		result = mariaDbJdbcTemplate.update(updateSql, params);

		if (result > 0)
			return true;
		return false;
	}

	@Override
	public Boolean cancelAd(Integer id) {
		Integer result;
		String updateSql = "UPDATE `ads` SET status = '' WHERE `adsId` = :id;";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		result = mariaDbJdbcTemplate.update(updateSql, params);

		if (result > 0)
			return true;
		return false;
	}

	private final class AdMapper implements RowMapper<Ad> {
		@Override
		public Ad mapRow(ResultSet rs, int rowNum) throws SQLException {
			Ad ad = new Ad();
			ad.setAdId(rs.getInt(1));
			ad.setName(rs.getString(2));
			ad.setPrice(rs.getDouble(3));
			ad.setStatus(rs.getString(4));
			return ad;
		}
	}
}
