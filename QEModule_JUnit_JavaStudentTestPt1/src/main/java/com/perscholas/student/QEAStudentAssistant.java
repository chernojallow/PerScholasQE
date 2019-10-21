package com.perscholas.student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class QEAStudentAssistant extends QEAStudent implements StudentAssistant {
	public QEAStudentAssistant(String name, String email) {
		super(name, email);
	}
	
	// Implemented methods from StudentAssistant interface
	@Override
	public void lectureClass() {
		LocalDate ld = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		String formattedString = ld.format(formatter);
		System.out.format("%s lectured a QEA class on %s\n", this.getName(), formattedString);
	}
	@Override
	public void gradeAssignment() {
		System.out.println(this.getName() + " graded another QEA assignment.");
	}
}
