package com.perscholas.junit.sba8;

public abstract class Product {
	private Integer productId;
	private String name;
	private Double price;
	private Boolean upgrade;
		
	public Product() {
		this.upgrade = false;
	}
	public Product(Integer productId, String name, Double price) {
		this();
	}
	
	public abstract void calculateUpgradedPrice();
	
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
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
	public void setUpgrade(Boolean upgrade) {
		this.upgrade = upgrade;
	}
	public Boolean getUpgrade() {
		return this.upgrade;
	}
}

