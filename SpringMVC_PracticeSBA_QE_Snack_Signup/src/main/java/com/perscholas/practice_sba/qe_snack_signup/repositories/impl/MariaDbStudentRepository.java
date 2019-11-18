package com.perscholas.practice_sba.qe_snack_signup.repositories.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.perscholas.practice_sba.qe_snack_signup.model.Student;
import com.perscholas.practice_sba.qe_snack_signup.repositories.StudentRepository;

public class MariaDbStudentRepository implements StudentRepository {
	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;

	@Override
	public Integer create(Student student) {
		Integer id = -1;
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("firstname", student.getFirstName());
		params.addValue("lastName", student.getLastName());
		params.addValue("username", student.getUsername());
		params.addValue("password", student.getPassword());
		String createSql = "INSERT INTO `student` (`firstName`, `lastName`, `username`, `password`) VALUES (:firstName, :lastName, :username, :password);";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer result = mariaDbJdbcTemplate.update(createSql, params, keyHolder);

		if (result > 0)
			id = keyHolder.getKey().intValue();
		return id;
	}

	@Override
	public Student getById(Integer studentId) {
		String selectById = "SELECT * FROM `student` WHERE `studentId` = :studentId;";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("studentId", studentId);
		Student student = null;

		try {
			student = (Student) mariaDbJdbcTemplate.queryForObject(selectById, params, new StudentMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}

		return student;
	}

	@Override
	public Student getByName(String username) {
		String selectById = "SELECT * FROM `student` WHERE `username` = :username;";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", username);
		Student student = null;

		try {
			student = (Student) mariaDbJdbcTemplate.queryForObject(selectById, params, new StudentMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}

		return student;
	}

	@Override
	public List<Student> getAll() {
		String selectGetAll = "SELECT * FROM `student`;";
		List<Student> result = mariaDbJdbcTemplate.query(selectGetAll, new StudentMapper());
		return result;
	}

	@Override
	public Boolean update(Student student) {
		Integer result = null;
		Map<String, Object> params = new HashMap<>();
		params.put("firstName", student.getFirstName());
		params.put("lastName", student.getLastName());
		params.put("username", student.getUsername());
		params.put("password", student.getPassword());
		params.put("studentId", student.getStudentId());

		String updateSql = "UPDATE `student` SET `firstName` = :firstName, `lastName` = :lastName, `username` = :username, `password` = :password WHERE `studentId` = :studentId;";
		result = mariaDbJdbcTemplate.update(updateSql, params);

		if (result > 0)
			return true;
		return false;
	}

	@Override
	public Boolean delete(Integer studentId) {
		Integer result = null;
		String removeSql = "DELETE FROM `student` WHERE `studentId` = :studentId;";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("studentId", studentId);
		result = mariaDbJdbcTemplate.update(removeSql, params);

		if (result > 0)
			return true;
		return false;
	}

	private final class StudentMapper implements RowMapper<Student> {
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student = new Student();
			student.setStudentId(rs.getInt(1));
			student.setFirstName(rs.getString(2));
			student.setLastName(rs.getString(3));
			student.setUsername(rs.getString(4));
			student.setPassword(rs.getString(5));
			return student;
		}
	}
}
