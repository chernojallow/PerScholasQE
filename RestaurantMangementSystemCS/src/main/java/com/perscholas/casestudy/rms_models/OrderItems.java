package com.perscholas.casestudy.rms_models;

public class OrderItems {
	private Integer orderID;
	private Integer categoryID;
	private Integer quantity;
	
	// Constructors
	public OrderItems() {
		this.orderID = null;
		this.categoryID = null;
		this.quantity = null;
	}
	
	public OrderItems(Integer orderID, Integer categoryID, Integer quantity) {
		this.orderID = orderID;
		this.categoryID = categoryID;
		this.quantity = quantity;
	}

	// Getters and Setters
	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Integer getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
