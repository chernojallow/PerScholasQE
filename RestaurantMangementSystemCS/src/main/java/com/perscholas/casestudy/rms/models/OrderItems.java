package com.perscholas.casestudy.rms.models;

import javax.validation.constraints.NotBlank;

public class OrderItems {
	
	@NotBlank(message = "Order Id is required.")
	private Integer orderId;
	
	@NotBlank(message = "Item Id is required.")
	private Integer itemId;
	
	@NotBlank(message = "Quantity is required.")
	private Integer quantity;
	
	@NotBlank(message = "Subtotal is required.")
	private Double subtotal;

	public OrderItems() {}

	public OrderItems(Integer orderId, Integer itemId, Integer quantity) {
		this.orderId = orderId;
		this.itemId = itemId;
		this.quantity = quantity;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	@Override
	public String toString() {
		return "OrderItems [orderId=" + orderId + ", itemId=" + itemId + ", quantity=" + quantity + ", subtotal="
				+ subtotal + "]";
	}
}
