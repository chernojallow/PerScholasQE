package com.perscholas.jspbeans;

import java.io.Serializable;

public class Student implements Serializable {

	// Attributes
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	private String course;

	/*
	 * No-Arg Constructor - provided by default when no other constructors are
	 * present, but included here for illustration.
	 */
	public Student() {
	}

	// Getters & Setters
	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
}
