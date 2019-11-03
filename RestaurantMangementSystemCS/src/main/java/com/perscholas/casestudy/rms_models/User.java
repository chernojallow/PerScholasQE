package com.perscholas.casestudy.rms_models;

public class User {
	private Integer userID;
	private String username;
	private String password;
	private Integer role;
	
	// Constructors
	public User() {
		this.userID = null;
		this.username = null;
		this.password = null;
		this.role = null;
	}
	
	// Getters and Setters
	public User(Integer userID, String username, String password, Integer role) {
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
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

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
}
