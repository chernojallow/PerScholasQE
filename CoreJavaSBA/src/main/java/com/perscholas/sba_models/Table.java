package com.perscholas.sba_models;

public class Table extends Furniture{

	private double length = -1;
	private String Shape = null;
	
	public Table() {
		super();
	}
	
	public Table(int id, String name, double price, String color, int quantity) {
		super();
	}
	
	@Override
	public void calculatePrice() {
		if (this.length == 60)
			this.setPrice(200);
		else this.setPrice(450);
		
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public String getShape() {
		return Shape;
	}

	public void setShape(String shape) {
		Shape = shape;
	}
	

}
