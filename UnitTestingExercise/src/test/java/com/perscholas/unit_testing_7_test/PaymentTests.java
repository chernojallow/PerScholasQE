package com.perscholas.unit_testing_7_test;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category({TestEnv.class})
public class PaymentTests {
	@Test
	@Category({ProductionEnv.class})
	public void verifyPaymentTest() {
		System.out.println("verifyPaymentTest");
	}
	
	@Test
	public void submitPaymentTest() {
		System.out.println("submitPaymentTest");
	}
	
	@Test
	public void confirmPaymentTest() {
		System.out.println("confirmPaymentTest");
	}
}
