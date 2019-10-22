package com.perscholas.junit.sba2.automation;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class SBA2 {
	private String test="Per Scholas - 211 N Ervay St. #700 - Dallas, TX 75201";
	
	@Test
	public void testSplit() {
		String[] test1=test.split(" ");
		assertThat(test1[0],equalTo("Per"));
	}
	
	@Test
	public void testJoin() {
		String test2= "SBA 2";
		String result=String.join(",", test, test2);
		assertThat(result,endsWith("2"));
	}

}

