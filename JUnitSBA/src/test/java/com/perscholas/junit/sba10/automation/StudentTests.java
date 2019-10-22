package com.perscholas.junit.sba10.automation;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class StudentTests {
	@Category({ DailyTest.class })
	@Test
	public void submitAssignmentTest() {
		System.out.println("StudentTests submitAssignmentTest");
	}
	
	@Category({ WeeklyTest.class })
	@Test
	public void submitExamTest() {
		System.out.println("StudentTests submitExamTest");
	}

	@Category({ SemesterTest.class })
	@Test
	public void joinClubTest() {
		System.out.println("StudentTests joinClubTest");
	}
}

