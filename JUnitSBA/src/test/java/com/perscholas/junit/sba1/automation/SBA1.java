package com.perscholas.junit.sba1.automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SBA1 {
	private String test = "Per Scholas - 211 N Ervay St. #700 - Dallas, TX 75201";

	@Test
	public void testLength() {
		 int expected = "Per Scholas - 211 N Ervay St. #700 - Dallas, TX 75201".length();
		 int actual = test.length();
		 assertEquals("not equal length",expected,actual);
	}

	@Test
	public void testequalsIgnoreCase() {
	 String acutal = "welcome to class";
	 assertFalse(acutal.equalsIgnoreCase(test));
	}
	
	@Test
	public void testContentEquals() {
	String acutal = "Per Scholas - 211 N Ervay St. #700 - Dallas, TX 75201";
	assertTrue(test.contentEquals(acutal));
		
	}
	
	@Test
	public void testCharAt() {
		assertNotNull(test.charAt(0));
	}
	
	@Test
	public void testContains() {
		assertTrue(test.contains("Dallas"));
	}
	
	@Test
	public void testStartsWith() {
		assertTrue(test.startsWith("Per Scholas"));
	}
	
	@Test
	public void testStartsWithIndex() {
		assertTrue(test.startsWith("211", 14));
	}
	
	@Test
	public void testEndsWith() {
		assertFalse(test.endsWith("happy"));
	}
	
	@Test
	public void testSubString() {
		String acutal = test.substring(0,5);
		assertFalse(acutal.contentEquals("cs"));
	}
	
	@Test
	public void testLowerCase() {
		String acutal = test.toLowerCase();
		assertThat(acutal.charAt(0), equalTo('p'));
	}
	
	
}
