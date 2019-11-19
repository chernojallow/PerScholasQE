package com.perscholas.spring_mvc_sba.rest_constroller.models;

import java.util.Arrays;

public class Student {
	private Integer studentId;
	private String name, email;
	private String[] courses;

	public Student() {
	}

	public Student(Integer studentId, String name, String email, String[] courses) {
		this.studentId = studentId;
		this.name = name;
		this.email = email;
		this.courses = courses;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String[] getCourses() {
		return courses;
	}

	public void setCourses(String[] courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", email=" + email + ", courses="
				+ Arrays.toString(courses) + "]";
	}

}
