package com.perscholas.casestudy.rms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class Table {
	@Id
	@GeneratedValue
	private Integer tableId;
	
	@NotBlank(message = "User Id is required.")
	private Integer userId;
	
	@NotBlank(message = "Order Id is required.")
	private Integer orderId;

	public Table() {}

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
