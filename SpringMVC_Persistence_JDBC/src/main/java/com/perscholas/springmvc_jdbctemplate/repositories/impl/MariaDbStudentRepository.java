package com.perscholas.springmvc_jdbctemplate.repositories.impl;

import java.io.IOException;
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
import org.springframework.stereotype.Repository;

import com.perscholas.springmvc_jdbctemplate.model.Student;
import com.perscholas.springmvc_jdbctemplate.repositories.StudentRepository;

@Repository("mariaDbStudentRepository")
public class MariaDbStudentRepository implements StudentRepository {
	@Autowired
	private NamedParameterJdbcTemplate mariaDbJdbcTemplate;

	@Override
	public Integer createStudent(Student student) {
		Integer id = -1;
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", student.getName());
		params.addValue("email", student.getEmail());
		String createSql = "insert into students (name, email) values " + "(:name,:email)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		Integer result = mariaDbJdbcTemplate.update(createSql, params, keyHolder);

		if (result > 0)
			id = keyHolder.getKey().intValue();
		return id;
	}

	@Override
	public Student getStudentById(Integer id) {
		String selectById = "select * from students where studentId = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		Student student = null;
		try {
			student = (Student) mariaDbJdbcTemplate.queryForObject(selectById, params, new StudentMapper());
		} catch (EmptyResultDataAccessException e) {
			System.out.println(e.getMessage());
		}
		return student;
	}

	@Override
	public Boolean updateStudent(Student student) {
		Integer result = null;
		Map<String, Object> params = new HashMap<>();
		params.put("name", student.getName());
		params.put("email", student.getEmail());
		params.put("id", student.getStudentId());
		String updateSql = "update students set name = :name, email = :email where studentId = :id";
		result = mariaDbJdbcTemplate.update(updateSql, params);

		if (result > 0)
			return true;
		return false;
	}

	@Override
	public Boolean deleteStudent(Integer studentId) {
		Integer result = null;
		String removeSql = "delete from students where studentId = :id";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", studentId);
		result = mariaDbJdbcTemplate.update(removeSql, params);

		if (result > 0)
			return true;
		return false;
	}

	@Override
	public List<Student> getAllStudents() throws ClassNotFoundException, IOException, SQLException {
		String selectGetAll = "SELECT * FROM students";
		List<Student> result = mariaDbJdbcTemplate.query(selectGetAll, new StudentMapper());
		return result;
	}

	private final class StudentMapper implements RowMapper<Student> {
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			Student student = new Student();
			student.setStudentId(rs.getInt(1));
			student.setName(rs.getString(2));
			student.setEmail(rs.getString(3));
			return student;
		}
	}
}