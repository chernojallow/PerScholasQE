package com.perscholas.servlet_jsp_ex.models;

public class Event {
	private Integer eventId;
	private String title;
	private String description;
	private String location;
	private String dateTime;
	private Integer memberId;

	public Event() {
		this.eventId = null;
		this.title = null;
		this.description = null;
		this.location = null;
		this.dateTime = null;
		this.memberId = null;
	}

	public Event(Integer eventId, String title, String description, String location, String dateTime,
			Integer memberId) {
		this.eventId = eventId;
		this.title = title;
		this.description = description;
		this.location = location;
		this.dateTime = dateTime;
		this.memberId = memberId;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}
}
