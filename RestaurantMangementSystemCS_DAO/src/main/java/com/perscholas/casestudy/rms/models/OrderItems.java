package com.perscholas.casestudy.rms.models;

public class OrderItems {
	private Integer orderId;
	private Integer itemId;
	private Integer quantity;
	private Double subtotal;

	public OrderItems() {
		this.orderId = null;
		this.itemId = null;
		this.quantity = null;
		this.subtotal = null;
	}

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
