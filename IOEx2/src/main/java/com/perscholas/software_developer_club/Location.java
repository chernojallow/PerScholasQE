package com.perscholas.software_developer_club;

public class Location {
	private String city = null;
	private String state = null;
	
	// Constructor
	public Location (String city, String state) {
		this.city = city;
		this.state = state;
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
	
	// Getters and setters
	
	
}
