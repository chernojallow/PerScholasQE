package com.perscholas.casestudy.rms.models;

import java.sql.Timestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Order {
	@Id
	@GeneratedValue
	private Integer orderId;

	@NotNull(message = "User Id is required.")
	private Integer addressId;

	@NotNull(message = "Start is required.")
	private Timestamp start;

	@NotNull(message = "End is required.")
	private Timestamp end;

	public Order() {
	}

	public Order(Integer orderId, @NotNull(message = "User Id is required.") Integer addressId,
			@NotNull(message = "Start is required.") Timestamp start,
			@NotNull(message = "End is required.") Timestamp end) {
		this.orderId = orderId;
		this.addressId = addressId;
		this.start = start;
		this.end = end;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Timestamp getStart() {
		return start;
	}

	public void setStart(Timestamp start) {
		this.start = start;
	}

	public Timestamp getEnd() {
		return end;
	}

	public void setEnd(Timestamp end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", addressId=" + addressId + ", start=" + start + ", end=" + end + "]";
	}
}
