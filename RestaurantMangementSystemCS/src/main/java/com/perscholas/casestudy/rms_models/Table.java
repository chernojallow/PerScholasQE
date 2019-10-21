package com.perscholas.casestudy.rms_models;

public class Table {
	private Integer tableID;
	private Integer userID;
	
	// Constructors
	public Table() {
		this.tableID = null;
		this.userID = null;
	}
	
	public Table(Integer tableID, Integer userID) {
		this.tableID = tableID;
		this.userID = userID;
	}

	// Getters and Setters
	public Integer getTableID() {
		return tableID;
	}

	public void setTableID(Integer tableID) {
		this.tableID = tableID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
}
