package com.perscholas.student;

import com.perscholas.student.exceptions.InvalidScoreException;

public abstract class Student {
	//Attributes/Fields
	private String name;
	private String email;
	private double sqlScore = 0.0;
	private double coreJavaScore = 0.0;
	private static int studentCount = 0;
	//Constructors
	public Student() {
		studentCount++;
		System.out.println("Student count = " + studentCount);
	}
	public Student(String n, String e) {
		this(); /*This line calls the no-arg constructor above
		which increments studentCount and prints out the count
		to the console. This is referred to as constructor
		chaining.*/
		this.name = n;
		this.email = e;
	}
	// Abstract class methods
	public abstract int getStudentCredits();
	public abstract double calculateStudentAverage();
	// Getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static int getStudentCount() {
		return studentCount;
	}
	public static void setStudentCount(int studentCount) {
		Student.studentCount = studentCount;
	}
	public double getSqlScore() {
		return sqlScore;
	}
	public void setSqlScore(double sqlScore) throws InvalidScoreException {
		if (sqlScore >= 0 && sqlScore <= 100) {
		this.sqlScore = sqlScore;
		} else {
			throw new InvalidScoreException("Invalid score."
					+ " Range of SQL Score is 0 to 100.");
		}
	}
	public double getCoreJavaScore() {
		return coreJavaScore;
	}
	public void setCoreJavaScore(double coreJavaScore) {
		this.coreJavaScore = coreJavaScore;
	}
}
