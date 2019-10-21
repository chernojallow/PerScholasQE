package com.perscholas.sba_models;

public class SBA6Course {
	private int id = 0;
	private String name = null, details = null;
	
	public SBA6Course() {
		
	}
	
	public SBA6Course(int id, String name, String details) {
		this.id = id;
		this.name = name;
		this.details = details;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
