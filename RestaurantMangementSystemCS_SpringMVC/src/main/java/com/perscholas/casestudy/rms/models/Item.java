package com.perscholas.casestudy.rms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Item {
	@Id
	@GeneratedValue
	private Integer itemId;

	@NotBlank(message = "Item name is required.")
	private String itemName;

	@NotNull(message = "Category ID is required.")
	private Integer categoryId;

	@NotNull(message = "Address ID is required.")
	private Integer addressId;

	@NotNull(message = "Price is required.")
	private Double price;

	public Item() {
	}

	public Item(Integer itemId, @NotBlank(message = "Item name is required.") String itemName,
			@NotNull(message = "Category ID is required.") Integer categoryId,
			@NotNull(message = "Address ID is required.") Integer addressId,
			@NotNull(message = "Price is required.") Double price) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.categoryId = categoryId;
		this.addressId = addressId;
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

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", categoryId=" + categoryId + ", addressId="
				+ addressId + ", price=" + price + "]";
	}
}
