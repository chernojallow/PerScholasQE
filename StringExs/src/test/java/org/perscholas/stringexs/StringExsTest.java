package org.perscholas.stringexs;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringExsTest {
	@Test
	public void returnStringEx1() {
		assertTrue(StringExs.ex1().equals("llo 201"));
	}
	
	
	@Test
	public void returnStringEx2Line1() {
		assertTrue(StringExs.ex2().get(0).equals("red green blue"));
	}
	
	@Test
	public void returnStringEx2Line2() {
		assertTrue(StringExs.ex2().get(1).equals("square triangle circle"));
	}
	
	@Test
	public void returnStringEx2Line3() {
		assertTrue(StringExs.ex2().get(2).equals("dog cat bird"));
	}
	
	
	@Test
	public void returnStringEx3R1C1() {
		assertTrue(StringExs.ex3()[0][0].equals("red"));
	}
	
	@Test
	public void returnStringEx3R1C2() {
		assertTrue(StringExs.ex3()[0][1].equals("green"));
	}
	
	@Test
	public void returnStringEx3R1C3() {
		assertTrue(StringExs.ex3()[0][2].equals("blue"));
	}
	
	@Test
	public void returnStringEx3R2C1() {
		assertTrue(StringExs.ex3()[1][0].equals("square"));
	}
	
	@Test
	public void returnStringEx3R2C2() {
		assertTrue(StringExs.ex3()[1][1].equals("triangle"));
	}
	
	@Test
	public void returnStringEx3R2C3() {
		assertTrue(StringExs.ex3()[1][2].equals("circle"));
	}
	
	@Test
	public void returnStringEx3R3C1() {
		assertTrue(StringExs.ex3()[2][0].equals("dog"));
	}
	
	@Test
	public void returnStringEx3R3C2() {
		assertTrue(StringExs.ex3()[2][1].equals("cat"));
	}
	
	@Test
	public void returnStringEx3R3C3() {
		assertTrue(StringExs.ex3()[2][2].equals("bird"));
	}
}
