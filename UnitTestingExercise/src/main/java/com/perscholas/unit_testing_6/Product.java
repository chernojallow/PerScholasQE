package com.perscholas.unit_testing_6;

public class Product {
	private Integer productID;
	private String name;
	private Double price;
	
	public Product() {
		this.productID = null;
		this.name = null;
		this.price = null;
	}
	
	public Product(Integer productID, String name, Double price) {
		this.productID = productID;
		this.name = name;
		this.price = price;
	}
	
	public Integer getProductID() {
		return productID;
	}
	public void setProductID(Integer productID) {
		this.productID = productID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", name=" + name + ", price=" + price + ", getProductID()="
				+ getProductID() + ", getName()=" + getName() + ", getPrice()=" + getPrice() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
