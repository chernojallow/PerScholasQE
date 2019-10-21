package com.perscholas.sba_models;

public class Chair extends Furniture{

	private String type = null;
	boolean customColor = false;
	
	public Chair() {
		super();
	}
	
	public Chair(int id, String name, double price, String color, int quantity) {
		super();
	}
	
	@Override
	public void calculatePrice() {
		if(customColor)
			this.setPrice(200);
		else this.setPrice(150);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isCustomColor() {
		return customColor;
	}

	public void setCustomColor(boolean customColor) {
		this.customColor = customColor;
	}

}
