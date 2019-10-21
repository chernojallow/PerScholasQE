package com.perscholas.stringalg;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class StringExTest {
	private static StringEx strArr;
	
	@BeforeClass
	public static void setup() {
		strArr = new StringEx();
	}
	
	@Test
	public void returnWordsTest() {
		assertTrue(strArr.returnWords().length == 3);
		assertTrue(strArr.returnWords()[0].equals("Hello"));
	}
	
	@Test
	public void returnStringFromArray() {
		assertTrue(strArr.returnStringFromArray().equals("Hello-2019-QE02!"));
	}
	
	@Test
	public void arrayToListDemo() {
		assertTrue(strArr.arrayToListDemo().contains("Hello"));
	}
	
}
