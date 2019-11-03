package com.perscholas.casestudy.rms_models;

public class Category {
	private Integer categoryID;
	private String categoryName;
	
	// Constructors
	public Category() {
		this.categoryID = null;
		this.categoryName = null;
	}
	
	public Category(Integer categoryID, String categoryName) {
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}
	
	// Getters and Setters
	public Integer getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
