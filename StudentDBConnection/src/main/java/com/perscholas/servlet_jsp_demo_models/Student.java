package com.perscholas.servlet_jsp_demo_models;

public class Student {
	// Attributes
	private Integer studentId;
	private String name;
	private String email;
	private String hometown;
	private String courseSelected;
	
	// Getters and Setters
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
	public String getHometown() {
		return hometown;
	}
	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	public String getCourseSelected() {
		return courseSelected;
	}
	public void setCourseSelected(String courseSelected) {
		this.courseSelected = courseSelected;
	}
}
