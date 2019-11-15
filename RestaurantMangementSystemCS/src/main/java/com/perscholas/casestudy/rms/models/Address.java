package com.perscholas.casestudy.rms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Address {
	@Id
	@GeneratedValue
	private Integer addressId;
	
	@Size(min = 1, max=255, message = "Address1 must be between 1 and 255 characters long.")
	@NotBlank(message = "Address1 is required.")
	private String address1;
	
	@Size(min = 1, max=255, message = "Address2 must be between 1 and 255 characters long.")
	private String address2;
	
	@Size(min = 1, max=50, message = "City must be between 1 and 50 characters long.")
	@NotBlank(message = "City is required.")
	private String city;
	
	@Size(min = 1, max=50, message = "State must be between 1 and 50 characters long.")
	@NotBlank(message = "State is required.")
	private String state;
	
	@Size(min=5, max=5, message = "Zip code must be 5 characters long.")
	@NotBlank(message = "Zip code is required.")
	private Integer postalCode;

	public Address() {}

	public Address(Integer addressId, String address1, String address2, String city, String state, Integer postalCode) {
		this.addressId = addressId;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
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
		return "Address [addressId=" + addressId + ", address1=" + address1 + ", address2=" + address2 + ", city="
				+ city + ", state=" + state + ", postalCode=" + postalCode + "]";
	}
}
