package com.perscholas.springmvc_controllers.models;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private Integer studentId;
	private String name;
	private String password;
	private List<String> courses;

	public Student() {
	}

	public Student(Integer studentId, String name, String password) {
		this.studentId = studentId;
		this.name = name;
		this.password = password;
		this.courses = new ArrayList<String>();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", password=" + password + ", courses=" + courses
				+ "]";
	}
}