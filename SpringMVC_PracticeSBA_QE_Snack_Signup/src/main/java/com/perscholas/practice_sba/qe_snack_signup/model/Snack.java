package com.perscholas.practice_sba.qe_snack_signup.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Snack {
	@Id
	@GeneratedValue
	private Integer snackId;

	@Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters long.")
	@NotBlank(message = "Name is required.")
	private String name;
	@NotBlank(message = "Student ID is required.")
	private Integer studentId;

	public Snack() {
	}

	public Snack(Integer snackId,
			@Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters long.") @NotBlank(message = "Name is required.") String name,
			@NotBlank(message = "Student ID is required.") Integer studentId) {
		this.snackId = snackId;
		this.name = name;
		this.studentId = studentId;
	}

	public Integer getSnackId() {
		return snackId;
	}

	public void setSnackId(Integer snackId) {
		this.snackId = snackId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	@Override
	public String toString() {
		return "Snack [snackId=" + snackId + ", name=" + name + ", studentId=" + studentId + "]";
	};
}
