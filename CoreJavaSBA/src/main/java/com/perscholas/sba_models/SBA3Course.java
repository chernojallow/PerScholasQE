package com.perscholas.sba_models;

public class SBA3Course {
	private int id = -1;
	private String courseName = null, courseDescription = null;
	
	
	// No-arg Constructor
	public SBA3Course() {
		
	}
	
	// Constructor
	public SBA3Course(int courseID, String courseName, String courseDescription) {
		this.id = courseID;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	
	@Override
	public String toString() {
		return "ID: " + id + "\nCourse name: " + courseName + "\nCourse description: " + courseDescription;
	}

}
