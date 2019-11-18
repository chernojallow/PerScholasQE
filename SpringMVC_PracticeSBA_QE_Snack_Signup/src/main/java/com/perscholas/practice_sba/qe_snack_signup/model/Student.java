package com.perscholas.practice_sba.qe_snack_signup.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Student {
	@Id
	@GeneratedValue
	private Integer studentId;

	@Size(min = 2, max = 25, message = "Fist name must be between 2 and 25 characters long.")
	@NotBlank(message = "First name is required.")
	private String firstName;

	@Size(min = 2, max = 25, message = "Last name must be between 2 and 25 characters long.")
	@NotBlank(message = "Last name is required.")
	private String lastName;

	@Size(min = 5, max = 25, message = "Username must be between 5 and 25 characters long.")
	@NotBlank(message = "Username is required.")
	private String username;

	@Size(min = 5, max = 25, message = "Password must be between 5 and 25 characters long.")
	@NotBlank(message = "Password is required.")
	private String password;

	public Student() {
	};

	public Student(Integer studentId,
			@Size(min = 2, max = 25, message = "Fist name must be between 2 and 25 characters long.") @NotBlank(message = "First name is required.") String firstName,
			@Size(min = 2, max = 25, message = "Last name must be between 2 and 25 characters long.") @NotBlank(message = "Last name is required.") String lastName,
			@Size(min = 5, max = 25, message = "Username must be between 5 and 25 characters long.") @NotBlank(message = "Username is required.") String username,
			@Size(min = 5, max = 25, message = "Password must be between 5 and 25 characters long.") @NotBlank(message = "Password is required.") String password) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + "]";
	}
}
