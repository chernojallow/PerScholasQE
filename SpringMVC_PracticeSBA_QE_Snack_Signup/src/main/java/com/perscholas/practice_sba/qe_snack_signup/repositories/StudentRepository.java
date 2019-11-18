package com.perscholas.practice_sba.qe_snack_signup.repositories;

import java.util.List;

import com.perscholas.practice_sba.qe_snack_signup.model.Student;

public interface StudentRepository {
	Integer create(Student student);

	Student getById(Integer studentId);
	
	Student getByName(String username);

	List<Student> getAll();

	Boolean update(Student student);

	Boolean delete(Integer studentId);
}