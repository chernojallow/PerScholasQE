package com.perscholas.spring_mvc_sba.classified_adds.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class User {
	@Size(min = 2, max = 50, message = "Username must be between 2 and 50 characters long.")
	@NotBlank(message = "Username is required.")
	private String username;

	@Size(min = 2, max = 50, message = "Password name must be between 2 and 50 characters long.")
	@NotBlank(message = "Password is required.")
	private String password;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
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

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}

}
