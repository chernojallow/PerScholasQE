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
	private Integer userId;
	
	@NotNull(message = "Time is required.")
	private Timestamp time;

	public Order() {}

	public Order(Integer orderId, Integer userId, Timestamp time) {
		this.orderId = orderId;
		this.userId = userId;
		this.time = time;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", userId=" + userId + ", time=" + time + "]";
	}
}
