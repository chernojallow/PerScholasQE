package com.perscholas.casestudy.rms.models;

public class Item {
	private Integer itemId;
	private String itemName;
	private Integer categoryId;
	private Double price;

	public Item() {
		this.itemId = null;
		this.itemName = null;
		this.categoryId = null;
		this.price = null;
	}

	public Item(Integer itemId, String itemName, Integer categoryId, Double price) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.categoryId = categoryId;
		this.price = price;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", categoryId=" + categoryId + ", price=" + price
				+ "]";
	}
}
