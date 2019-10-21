package com.perscholas.student;

public class QEAStudent extends Student{
	private double jUnitScore;
	private double seleniumScore;
	
	public QEAStudent() {
		super(); /* This line calls the
		constructor of the super class and is also a form
		of constructor chaining.*/
	}
	public QEAStudent(String name, String email) {
		super(name, email); 
	}
	// Implemented methods from the abstract class Student
	@Override
	public int getStudentCredits() {
		int creditCount = 0;
		if (this.getSqlScore() >= 70) {
			creditCount++;
		}
		if (this.getCoreJavaScore() >= 70) {
			creditCount++;
		}
		if (this.jUnitScore >= 70) {
			creditCount++;
		}
		if (this.seleniumScore >= 70) {
			creditCount++;
		}
		return creditCount;
	}
	@Override
	public double calculateStudentAverage() {
		double avg = (this.getCoreJavaScore() + this.getSqlScore()
		+ this.jUnitScore + this.seleniumScore)/4;
		return avg;
	}
	// Getters and setters
	public double getjUnitScore() {
		return jUnitScore;
	}
	public void setjUnitScore(double jUnitScore) {
		this.jUnitScore = jUnitScore;
	}
	public double getSeleniumScore() {
		return seleniumScore;
	}
	public void setSeleniumScore(double seleniumScore) {
		this.seleniumScore = seleniumScore;
	}
}
