package com.perscholas.casestudy.rms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	@Id
	@GeneratedValue
	private Integer userId;

	@Size(min = 5, max = 25, message = "Username must be between 5 and 25 characters long.")
	@NotBlank(message = "Username is required.")
	private String username;

	@Size(min = 5, max = 25, message = "Password must be between 5 and 25 characters long.")
	@NotBlank(message = "Password is required.")
	private String password;

	private Integer addressId;
	
	@NotNull
	private Integer role;

	public User() {
		this.userId = null;
		this.username = null;
		this.password = null;
		this.addressId = null;
		this.role = null;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public User(String username, String password, Integer addressId, Integer role) {
		this.username = username;
		this.password = password;
		this.addressId = addressId;
		this.role = role;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", addressId="
				+ addressId + ", role=" + role + "]";
	}
}
