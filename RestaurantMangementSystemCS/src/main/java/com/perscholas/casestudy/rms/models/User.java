package com.perscholas.casestudy.rms.models;

public class User {
	private Integer userId;
	private String username;
	private String password;
	private Integer addressId;
	private Integer role;

	public User() {
		this.userId = null;
		this.username = null;
		this.password = null;
		this.addressId = null;
		this.role = null;
	}

	public User(Integer userId, String username, String password, Integer addressId, Integer role) {
		this.userId = userId;
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
