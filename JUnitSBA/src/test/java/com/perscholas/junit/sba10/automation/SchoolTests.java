package com.perscholas.junit.sba10.automation;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class SchoolTests {
	@Category({ SemesterTest.class })
	@Test
	public void addCourseTest() {
		System.out.println("SchoolTests addCourseTest");
	}

	@Category({ SemesterTest.class })
	@Test
	public void registerStudentTest() {
		System.out.println("School Tests registerStudentTest");
	}

	@Category({ WeeklyTest.class })
	@Test
	public void createWeeklyReportTest() {
		System.out.println("School Tests createWeeklyReportTest");
	}

	@Category({ DailyTest.class })
	@Test
	public void takeAttendanceTest() {
		System.out.println("School Tests takeAttendanceTest.");
	}

	@Category({ SemesterTest.class })
	@Test
	public void publishGradesTest() {
		System.out.println("School Tests publishGradesTest.");

	}
}
