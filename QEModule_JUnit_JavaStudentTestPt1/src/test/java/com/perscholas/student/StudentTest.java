package com.perscholas.student;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mockito;

import com.perscholas.student.exceptions.InvalidScoreException;

public class StudentTest {
	private static Student mockStudent;
	
	/* The Student class is an abstract class so we will instantiate the class
	 * using a mocking framework named Mockito. This will require the downloading
	 * of the Mockito and Powermock dependencies (mockito-core v2.8.9 and 
	 * powermock-module-junit4 v1.7.4 - you may try different versions of these 
	 * dependencies, but they may not run correctly.). Use the jar files and add
	 * them to the build path or place the dependencies in the pom.xml file if 
	 * using Maven. We will discuss Mockito and mocking more in depth in another 
	 * lesson.*/
	
	@BeforeClass
	public static void setUp() {
	    mockStudent = Mockito.mock(
		  	      Student.class, 
		  	      Mockito.CALLS_REAL_METHODS);
	}
	
	// Test for score within range
	@Test
	public void setSqlScoreValid( ) throws InvalidScoreException {
		mockStudent.setSqlScore(75);
	}
	
	// Test for exception using optional @Test parameter
	@Test(expected = InvalidScoreException.class)
	public void setSqlScoreHighTest() throws InvalidScoreException {
		mockStudent.setSqlScore(150);
	}
	
	// Test for exception using @Rule
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void setSqlScoreLowTest() throws InvalidScoreException {
        thrown.expect(InvalidScoreException.class);
		mockStudent.setSqlScore(-1);
	}
}
