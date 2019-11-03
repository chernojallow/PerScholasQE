package com.perscholas.casestudy.rms_models;

import java.sql.Timestamp;

public class Order {
	private Integer orderID;
	private Integer userID;
	private Integer tableID;
	private Timestamp time;

	// Constructors
	public Order() {
		this.orderID = null;
		this.userID = null;
		this.tableID = null;
		this.time = null;
	}
	
	public Order(Integer orderID, Integer userID, Integer tableID, Timestamp time) {
		this.orderID = orderID;
		this.userID = userID;
		this.tableID = tableID;
		this.time = time;
	}

	// Getters and Setters
	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Integer getTableID() {
		return tableID;
	}

	public void setTableID(Integer tableID) {
		this.tableID = tableID;
	}
	
	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}
}
