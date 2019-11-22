package com.perscholas.spring_mvc_sba.classified_adds.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Ad {
	@Id
	@GeneratedValue
	private Integer adId;

	@Size(min = 2, max = 50, message = "Item name must be between 2 and 50 characters long.")
	@NotBlank(message = "Name is required.")
	private String name;

	@DecimalMax("100000000.0")
	@DecimalMin("0.0")
	private Double price;

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getAdId() {
		return adId;
	}

	public void setAdId(Integer adId) {
		this.adId = adId;
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
}
