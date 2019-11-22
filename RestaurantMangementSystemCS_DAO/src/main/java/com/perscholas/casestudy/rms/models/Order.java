package com.perscholas.casestudy.rms.models;

import java.sql.Timestamp;

public class Order {
	private Integer orderId;
	private Integer userId;
	private Timestamp time;

	public Order() {
		this.orderId = null;
		this.userId = null;
		this.time = null;
	}

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
