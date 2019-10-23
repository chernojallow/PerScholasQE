package com.perscholas.casestudy.rms_models;

public class Item {
	private Integer itemID;
	private String itemName;
	private Integer categoryID;
	private Double price;
	
	// Constructors
	public Item() {
		this.itemID = null;
		this.itemName = null;
		this.categoryID = null;
		this.price = null;
	}

	public Item(Integer itemID, String itemName, Integer categoryID, Double price) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.categoryID = categoryID;
		this.price = price;
	}

	// Getters and Setters
	public Integer getItemID() {
		return itemID;
	}

	public void setItemID(Integer itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
