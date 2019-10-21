package com.perscholas.categories;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class CoffeeTests {
	@Category( { MondayMorningTests.class, WednesdayMorningTests.class } )
	@Test
	public void coffeeTest1() {
		Boolean isHot = true;
		assertThat(isHot, equalTo(true));
	}
	
	@Category( { SaturdayMorningTests.class } )
	@Test
	public void coffeeTest2() {
		Boolean decaffeinated = true;
		assertThat(decaffeinated, equalTo(true));
	}
}
