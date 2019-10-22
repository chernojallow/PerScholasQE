package com.perscholas.junit.sba10.automation;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class InstructorTests {
	@Category({ DailyTest.class })
	@Test
	public void gradeAssignmentTest() {
		System.out.println("InstructorTests gradeAssignmentTest");
	}

	@Category({ WeeklyTest.class })
	@Test
	public void gradeExamTest() {
		System.out.println("InstructorTests gradeExamTest");
	}

	@Category({ SemesterTest.class })
	@Test
	public void submitFinalGradesTest() {
		System.out.println("InstructorTests submitFinalGradesTest");
	}

	@Category({ SemesterTest.class })
	@Test
	public void adviseStudentTest() {
		System.out.println("InstructorTests adviseStudentTest.");
	}
}

