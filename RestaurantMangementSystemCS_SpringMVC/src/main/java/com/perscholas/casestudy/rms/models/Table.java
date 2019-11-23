package com.perscholas.casestudy.rms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Table {
	@Id
	@GeneratedValue
	private Integer tableId;
	
	@NotNull(message = "Address Id is required.")
	private Integer addressId;
	
	private Integer orderId;

	public Table() {}

	public Table(Integer tableId, @NotNull(message = "Address Id is required.") Integer addressId) {
		this.tableId = tableId;
		this.addressId = addressId;
	}
	
	public Table(Integer tableId, @NotNull(message = "Address Id is required.") Integer addressId, Integer orderId) {
		this.tableId = tableId;
		this.addressId = addressId;
		this.orderId = orderId;
	}

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "Table [tableId=" + tableId + ", addressId=" + addressId + ", orderId=" + orderId + "]";
	}
}
