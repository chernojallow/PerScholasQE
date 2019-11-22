package com.perscholas.casestudy.rms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Item {
	@Id
	@GeneratedValue
	private Integer itemId;
	
	@Size(min = 1, max=50, message="Item name must be between 1 and 50 characters long.")
	@NotBlank(message="Item name is required.")
	private String itemName;
	
	@Size(min = 1, max=50, message="Item name must be between 1 and 50 characters long.")
	@NotNull(message="Item name is required.")
	private Integer categoryId;
	
	@NotNull(message="Item name is required.")
	private Double price;

	public Item() {}

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
