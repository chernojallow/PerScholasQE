package com.perscholas.home_insurance.models;

import java.sql.Date;

public class User {
	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private Date dob;

	public User() {
		this.userId = null;
		this.firstName = null;
		this.lastName = null;
		this.email = null;
		this.username = null;
		this.password = null;
		this.dob = null;
	}

	public User(Integer userId, String firstName, String lastName, String email, String username, String password,
			Date dob) {
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.dob = dob;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", dob=" + dob + "]";
	}
}
