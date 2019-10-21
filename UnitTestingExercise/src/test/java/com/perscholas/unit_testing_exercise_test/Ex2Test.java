package com.perscholas.unit_testing_exercise_test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.perscholas.unit_testing_exercise.Ex2;

public class Ex2Test {
	Ex2 ex2 = new Ex2();
	Integer[] n = ex2.getN();
	
	@Test
	public void returnAddNbrTest() {
		Integer actual = ex2.returnAddNbr();
		Integer[] expected = {n[0]+n[1], n[0]+n[2], n[1]+n[2]};
		
		if(actual == expected[0])
			assertEquals(actual, expected[0]);
		else if(actual == expected[1])
			assertEquals(actual, expected[1]);
		else if(actual == expected[2])
			assertEquals(actual, expected[2]);
		else assertTrue(false);
	}
	
	@Test
	public void returnMultiplyNbr() {
		Integer actual = ex2.returnMultiplyNbr();
		Integer[] expected = {n[0]*n[1], n[0]*n[2], n[1]*n[2]};
		
		if(actual == expected[0])
			assertEquals(actual, expected[0]);
		else if(actual == expected[0])
			assertEquals(actual, expected[1]);
		else if(actual == expected[0])
			assertEquals(actual, expected[2]);
		else assertTrue(false);
	}
	
	@Test
	public void returnPowerNbr() {
		Integer actual = ex2.returnPowerNbr();
		Integer[] expected = {
				(int) Math.pow(n[0], n[1]), (int) Math.pow(n[0], n[2]),
				(int) Math.pow(n[1], n[0]), (int) Math.pow(n[1], n[2]),
				(int) Math.pow(n[2], n[0]), (int) Math.pow(n[2], n[1])};
		
		if(actual.equals(expected[0]))
			assertEquals(actual, expected[0]);
		else if(actual.equals(expected[1]))
			assertEquals(actual, expected[1]);
		else if(actual.equals(expected[2]))
			assertEquals(actual, expected[2]);
		else if(actual.equals(expected[3]))
			assertEquals(actual, expected[3]);
		else if(actual.equals(expected[4]))
			assertEquals(actual, expected[4]);
		else if(actual.equals(expected[5]))
			assertEquals(actual, expected[5]);
		else assertTrue(false);
	}
	
}
