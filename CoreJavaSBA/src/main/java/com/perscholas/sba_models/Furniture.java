package com.perscholas.sba_models;

public abstract class Furniture {
	private int id = -1, quantity = -1;
	private double price = -1;
	private String name = null, color = null;
	
	public Furniture() {
		
	}
	
	public Furniture(int id, String name, double price, String color, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.color = color;
		this.quantity = quantity;
	}
	
	public abstract void calculatePrice();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
}
