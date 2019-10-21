package com.perscholas.unit_testing_7_test;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({TestEnv.class})
public class ProductTests {
	@Test
	public void createProductTest() {
		System.out.println("createProductTest");
	}
	
	@Test
	@Category({ProductionEnv.class})
	public void restockInventoryTest() {
		System.out.println("restockInventoryTest");
	}
	
}
