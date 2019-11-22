package com.perscholas.casestudy.rms.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Registration {
	@Size(min = 5, max = 25, message = "Username must be between 5 and 25 characters long.")
	@NotBlank(message = "Username is required.")
	private String username;

	@Size(min = 5, max = 25, message = "Password must be between 5 and 25 characters long.")
	@NotBlank(message = "Password is required.")
	private String password;

	@NotBlank(message = "Address1 is required.")
	private String address1;

	private String address2;

	@NotBlank(message = "City is required.")
	private String city;

	@NotBlank(message = "State is required.")
	private String state;

	@NotNull(message = "Zip code is required.")
	private Integer postalCode;

	public Registration() {
	}

	public Registration(String username, String password, String address1, String address2, String city, String state,
			Integer postalCode) {
		this.username = username;
		this.password = password;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
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

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	@Override
	public String toString() {
		return "Registration [username=" + username + ", password=" + password + ", address1=" + address1
				+ ", address2=" + address2 + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode + "]";
	}
}
