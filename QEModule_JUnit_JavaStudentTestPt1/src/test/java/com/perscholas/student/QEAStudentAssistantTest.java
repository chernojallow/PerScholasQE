package com.perscholas.student;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.number.IsCloseTo.closeTo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.perscholas.student.exceptions.InvalidScoreException;

public class QEAStudentAssistantTest {
	private static QEAStudentAssistant student;
	private static ByteArrayOutputStream testOutputStream;
	
	@BeforeClass
	public static void setUp() throws InvalidScoreException {
		student = new QEAStudentAssistant("John", "john@doe.com");
		testOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOutputStream));
		
		student.setSqlScore(85.1); // Plus 1 credit
		student.setCoreJavaScore(77.4); // Plus 1 credit
		student.setjUnitScore(62.7); // No credit
		student.setSeleniumScore(93.5); // Plus 1 credit
	}

	@AfterClass
	public static void restoreStreams() {
	    System.setOut(System.out); // Restore output stream back to original/default
	}
	
	@Test
	public void getStudentCreditsTest() throws InvalidScoreException {
		assertThat(student.getStudentCredits(), equalTo(3));
	}
	
	@Test
	public void calculateStudentAverageTest() throws InvalidScoreException  {
		double[] scores = {
				student.getSqlScore(),
				student.getCoreJavaScore(),
				student.getjUnitScore(),
				student.getSeleniumScore()
		};
		double sumScores = 0;
		double avg = 0;
		for (double d : scores) {
			sumScores += d;
		}
		avg = sumScores/scores.length;
		
		System.out.println(avg);
		assertThat(student.calculateStudentAverage(), closeTo(avg, .01));
	}
	
	@Test
	public void lectureClassTest() {
		LocalDate ld = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		String formattedString = ld.format(formatter);
		String expectedString = String.format("%s lectured a QEA class on %s\n", "John", formattedString);
	    
		testOutputStream.reset();
		student.lectureClass();
		assertEquals(expectedString, testOutputStream.toString());
	}
	
	@Test
	public void gradeAssignmentTest() {
		testOutputStream.reset();
		student.gradeAssignment();
		assertEquals("John graded another QEA assignment.\n", testOutputStream.toString());
	}

}
