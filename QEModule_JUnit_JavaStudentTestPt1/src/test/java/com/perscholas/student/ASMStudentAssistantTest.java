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

public class ASMStudentAssistantTest {
	private static ASMStudentAssistant asmStudent;
	private static ByteArrayOutputStream testOutputStream;

	@BeforeClass
	public static void setUp() throws InvalidScoreException {
		asmStudent = new ASMStudentAssistant("Jane", "jane@doe.com");
		testOutputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(testOutputStream));
		
		asmStudent.setSqlScore(85.1); // Plus 1 credit
		asmStudent.setCoreJavaScore(77.4); // Plus 1 credit
		asmStudent.setItilScore(62.7); // No credit
	}

	@AfterClass
	public static void restoreStreams() {
	    System.setOut(System.out); // Restore output stream back to original/default
	}
	
	@Test
	public void getStudentCreditsTest() throws InvalidScoreException {
		assertThat(asmStudent.getStudentCredits(), equalTo(2));
	}
	
	@Test
	public void calculateStudentAverageTest() throws InvalidScoreException  {
		double[] scores = {
				asmStudent.getSqlScore(),
				asmStudent.getCoreJavaScore(),
				asmStudent.getItilScore(),
		};
		double sumScores = 0;
		double avg = 0;
		for (double d : scores) {
			sumScores += d;
		}
		avg = sumScores/scores.length;
		
		System.out.println(avg);
		assertThat(asmStudent.calculateStudentAverage(), closeTo(avg, .01));
	}
	
	@Test
	public void lectureClassTest() {
		LocalDate ld = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
		String formattedString = ld.format(formatter);
		String expectedString = String.format("%s lectured an ASM class on %s\n", "Jane", formattedString);
	    
		testOutputStream.reset();
		asmStudent.lectureClass();
		assertEquals(expectedString, testOutputStream.toString());
	}
	
	@Test
	public void gradeAssignmentTest() {
		testOutputStream.reset();
		asmStudent.gradeAssignment();
		assertEquals(testOutputStream.toString(), "Jane graded another ASM assignment.\r\n");
	}

}
