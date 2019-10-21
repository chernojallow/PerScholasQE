package com.perscholas.unit_testing_7_test;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({TestEnv.class})
public class ShoppingCartTests {
	@Test
	public void addProductTest() {
		System.out.println("addProductTest");
	}
	
	@Test
	public void removeProductTest() {
		System.out.println("removeProductTest");
	}
	
	@Test
	@Category({ProductionEnv.class})
	public void checkTimeOutTest() {
		System.out.println("checkTimeOutTest");
	}
}
