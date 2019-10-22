package com.perscholas.junit.sba3.automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;

public class SBA3 {
	int n = 10;

	@Test
	public void toBinaryStringTest() {
		System.out.println(Integer.toBinaryString(n));
		assertThat(Integer.toBinaryString(n), equalTo("1010"));
	}
}
