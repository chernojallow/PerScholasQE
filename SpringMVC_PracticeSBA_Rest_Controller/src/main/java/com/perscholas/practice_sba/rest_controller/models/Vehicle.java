package com.perscholas.practice_sba.rest_controller.models;

import java.util.List;

public class Vehicle {
	private Integer vehicleId;
	private String make;
	private String model;
	private List<String> colors;
	
	public Vehicle() {};
	
	public Vehicle(Integer vehicleId, String make, String model, List<String> colors) {
		this.vehicleId = vehicleId;
		this.make = make;
		this.model = model;
		this.colors = colors;
	}
	
	public Integer getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public List<String> getColors() {
		return colors;
	}
	public void setColors(List<String> colors) {
		this.colors = colors;
	}
}
