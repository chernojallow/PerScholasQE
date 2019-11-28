package com.perscholas.casestudy.rms.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Category {
	@Id
	@GeneratedValue
	private Integer categoryId;

	@Size(min = 1, max = 50, message = "Category name must be between 1 and 50 characters long.")
	@NotBlank(message = "Category name is required.")
	private String categoryName;
	
	@NotNull(message = "Address ID is required.")
	private Integer addressId;

	public Category() {
	}

	public Category(Integer categoryId,
			@Size(min = 1, max = 50, message = "Category name must be between 1 and 50 characters long.") @NotBlank(message = "Category name is required.") String categoryName,
			@NotNull(message = "Address ID is required.") Integer addressId) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.addressId = addressId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName=" + categoryName + ", addressId=" + addressId
				+ "]";
	}
}
