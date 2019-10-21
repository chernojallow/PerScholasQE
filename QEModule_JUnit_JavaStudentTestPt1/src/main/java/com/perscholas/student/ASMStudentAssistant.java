package com.perscholas.student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ASMStudentAssistant extends ASMStudent implements StudentAssistant {

	public ASMStudentAssistant(String name, String email) {
		super(name, email);
	}

	// Implemented methods from StudentAssistant interface
	@Override
	public void lectureClass() {
		LocalDate ld = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		String formattedString = ld.format(formatter);
		System.out.format("%s lectured an ASM class on %s\n", this.getName(), formattedString);
	}
	
	@Override
	public void gradeAssignment() {
		System.out.println(this.getName() + " graded another ASM assignment.");
	}

}
