package com.perscholas.unit_testing_5;

import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Product {
	// Attributes/Fields
	private Integer productId;
	private String name;
	private String description;
	private Double price;
	private Integer availableQuantity;
	private Boolean productInventoryLow;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	// Constructors
	public Product() {
		this.availableQuantity = 25;
		productInventoryLow = true;
		LocalDateTime ldt = LocalDateTime.now();
		this.createdAt = ldt;
		this.updatedAt = ldt;
	}

	public Product(Integer productId, String name, String description, Double price)
			throws IllegalArgumentException, MaximumQuantityExceededException {
		this();
		this.productId = productId;
		this.setName(name);
		this.setDescription(description);
		this.price = price;
	}

	// Getter and Setters
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws IllegalArgumentException {
		Pattern p = Pattern.compile("^[a-zA-Z]+$");
		Matcher m = p.matcher(name);
		if (m.matches()) {
			this.name = name;
			System.out.println("Product name set.");
		} else {
			throw new IllegalArgumentException("Please enter a valid name (must include only alpha characters).");
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) throws IllegalArgumentException {
		if (description.length() > 200) {
			throw new IllegalArgumentException("Product description must not exceed 100 characters.");
		}
		this.description = description;
		System.out.println("Product description set.");
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity)
			throws IllegalArgumentException, MaximumQuantityExceededException {
		if (availableQuantity < 1) {
			throw new IllegalArgumentException("Invalid quantity entered.");
		}
		if (availableQuantity > 500) {
			throw new MaximumQuantityExceededException("Maximum number of stocked items exceeded.");
		}
		this.availableQuantity = availableQuantity;
		System.out.println("Available product quantity set.");
	}

	public Boolean getProductInventoryLow() {
		return productInventoryLow;
	}

	public void setProductInventoryLow(Boolean productLow) {
		this.productInventoryLow = productLow;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	// No setter for createdAt. Should not be modifiable.

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	// Other methods
	public void reduceAvailableQuantity(Integer numberSold) throws InsufficientQuantityException {
		if (numberSold > this.availableQuantity) {
			throw new InsufficientQuantityException();
		}
		this.availableQuantity -= numberSold;

		if (this.availableQuantity < 10) {
			this.productInventoryLow = true;
		}
	}

	public void restockInventory(Integer numberOfItems)
			throws IllegalArgumentException, MaximumQuantityExceededException {
		if (numberOfItems < 1) {
			throw new IllegalArgumentException("Invalid quantity entered.");
		}
		if ((numberOfItems + this.availableQuantity) > 500) {
			throw new MaximumQuantityExceededException("Maximum number of stocked items exceeded.");
		}
		this.availableQuantity += numberOfItems;
		System.out.println("Product restocked. Current product count: " + this.availableQuantity);
	}

	@Override
	public String toString() {
		return String.format(
				"Product ID: %d\nProduct Name: %s\n" + "Product Description: %s\nPrice: %.2f\nQuantity Available: "
						+ "%d\nHashcode: %s",
				this.productId, this.name, this.description, this.price, this.availableQuantity, this.hashCode());
	}

}
