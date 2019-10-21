package com.perscholas.categories;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class EspressoTests {
	@Test
	public void espressoTest1() {
		Boolean stayAwake = true;
		assertThat(stayAwake, equalTo(true));
	}
}
