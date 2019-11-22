package com.perscholas.casestudy.rms.models;

public class Table {
	private Integer tableId;
	private Integer userId;
	private Integer orderId;

	public Table() {
		this.tableId = null;
		this.userId = null;
		this.orderId = null;
	}

	public Table(Integer tableId, Integer userId) {
		this.tableId = tableId;
		this.userId = userId;
	}

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Table [tableId=" + tableId + ", userId=" + userId + ", orderId=" + orderId + "]";
	}
}
