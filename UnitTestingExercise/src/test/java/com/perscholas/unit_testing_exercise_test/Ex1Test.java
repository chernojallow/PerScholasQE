package com.perscholas.unit_testing_exercise_test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.perscholas.unit_testing_exercise.Ex1;

public class Ex1Test {
	Ex1 ex1 = new Ex1();
	
	@Test
	public void returnDoubletoIntTest() {
		int n = ex1.returnDoubletoInt();
		assertEquals(n, (int)n);
	}
	
	@Test
	public void returnNbrTest() {
		int n = ex1.returnNbr();
		System.out.println("returnNbrTest n = " + n);
		assertThat(n, equalTo((int)n));
	}
	
	@Test
	public void returnStringTest() {
		Character[] str = ex1.returnString();
		StringBuilder str1 = new StringBuilder();
		
		for(int i = 0; i < str.length; i++)
			str1.append(str[i]);
		
		String str2 = str1.toString();
		System.out.println("returnStringTest arr1 = " + str1.toString());
		assertThat(str1.toString(), equalTo(str2));
	}
	
	@Test
	public void returnBoolTest() {
		Boolean bool = ex1.returnBool();
		System.out.println("returnBoolTest bool = " + bool);
		
		if(bool == true)
			assertTrue(bool.equals(true));
		else
			assertFalse(bool.equals(true));
	}
	
}
