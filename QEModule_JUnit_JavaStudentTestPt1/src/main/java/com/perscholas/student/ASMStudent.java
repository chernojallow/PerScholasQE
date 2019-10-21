package com.perscholas.student;

public class ASMStudent extends Student {
	private double itilScore;
	// Constructors
	public ASMStudent() {
		super();
	}
	public ASMStudent(String name, String email) {
		super(name,email);
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
		if (this.itilScore >= 70) {
			creditCount++;
		}
		return creditCount;
	}
	@Override
	public double calculateStudentAverage() {
		double avg = (this.getCoreJavaScore() + this.getSqlScore()
		+ this.itilScore)/3;
		return avg;
	}
	// Getters and setters
	public double getItilScore() {
		return itilScore;
	}
	public void setItilScore(double itilScore) {
		this.itilScore = itilScore;
	}
}
