package com.perscholas.home_insurance.models;

public class Home {
	private Integer homeId;
	private Integer userId;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private Integer zip;
	private Integer yearBuilt;
	private Double homeValue;

	public Home() {
		this.homeId = null;
		this.userId = null;
		this.address1 = null;
		this.address2 = null;
		this.city = null;
		this.state = null;
		this.zip = null;
		this.yearBuilt = null;
		this.homeValue = null;
	}

	public Home(Integer homeId, Integer userId, String address1, String address2, String city, String state,
			Integer zip, Integer yearBuilt, Double homeValue) {
		this.homeId = homeId;
		this.userId = userId;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.yearBuilt = yearBuilt;
		this.homeValue = homeValue;
	}

	public Integer getHomeId() {
		return homeId;
	}

	public void setHomeId(Integer homeId) {
		this.homeId = homeId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public Integer getYearBuilt() {
		return yearBuilt;
	}

	public void setYearBuilt(Integer yearBuilt) {
		this.yearBuilt = yearBuilt;
	}

	public Double getHomeValue() {
		return homeValue;
	}

	public void setHomeValue(Double homeValue) {
		this.homeValue = homeValue;
	}

	@Override
	public String toString() {
		return "Home [homeId=" + homeId + ", userId=" + userId + ", address1=" + address1 + ", address2=" + address2
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", yearBuilt=" + yearBuilt + ", homeValue="
				+ homeValue + "]";
	}
}
