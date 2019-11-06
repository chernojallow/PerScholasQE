package com.perscholas.home_insurance.models;

import java.sql.Date;

public class Quote {
	private Integer quoteId;
	private Integer homeId;
	private Double yearlyPremium;
	private Date startDate;
	private Date expiration;
	private Boolean active;

	public Quote() {
		this.quoteId = null;
		this.homeId = null;
		this.yearlyPremium = null;
		this.startDate = null;
		this.expiration = null;
		this.active = null;
	}

	public Quote(Integer quoteId, Integer homeId, Double yearlyPremium, Date startDate, Date expiration,
			Boolean active) {
		this.quoteId = quoteId;
		this.homeId = homeId;
		this.yearlyPremium = yearlyPremium;
		this.startDate = startDate;
		this.expiration = expiration;
		this.active = active;
	}

	public Integer getQuoteId() {
		return quoteId;
	}

	public void setQuoteId(Integer quoteId) {
		this.quoteId = quoteId;
	}

	public Integer getHomeId() {
		return homeId;
	}

	public void setHomeId(Integer homeId) {
		this.homeId = homeId;
	}

	public Double getYearlyPremium() {
		return yearlyPremium;
	}

	public void setYearlyPremium(Double yearlyPremium) {
		this.yearlyPremium = yearlyPremium;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Quote [quoteId=" + quoteId + ", homeId=" + homeId + ", yearlyPremium=" + yearlyPremium + ", startDate="
				+ startDate + ", expiration=" + expiration + ", active=" + active + "]";
	}
}
