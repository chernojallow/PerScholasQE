package com.perscholas.software_developer_club;

public class ClubMember {
	// Variable
	private String name = null, flang = null;
	private Location location = null;
	
	// Constructor
	public ClubMember (String name, Location location, String favoriteLanguage) {
		this.name = name;
		this.location = location;
		this.flang = favoriteLanguage;
	}
	
	// Getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFlang() {
		return flang;
	}
	public void setFlang(String flang) {
		this.flang = flang;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
}
