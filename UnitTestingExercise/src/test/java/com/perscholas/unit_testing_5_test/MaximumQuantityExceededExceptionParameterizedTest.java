package com.perscholas.unit_testing_5_test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mockito;

import com.perscholas.unit_testing_5.MaximumQuantityExceededException;
import com.perscholas.unit_testing_5.Product;

@RunWith(Parameterized.class)
public class MaximumQuantityExceededExceptionParameterizedTest {
	private static Product mockProduct;
	private Integer availableQuantity;
	private Class<? extends Exception> expectedException;
	
	public MaximumQuantityExceededExceptionParameterizedTest(Integer availableQuantity, Class<? extends Exception> e) {
		this.availableQuantity = availableQuantity;
		this.expectedException = e;
	}

	@BeforeClass
	public static void setUp() {
		// Mockito is used to instantiate the class
	        mockProduct = Mockito.mock(Product.class, Mockito.CALLS_REAL_METHODS);
	}
	
	@Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(
            new Object[][]{ { 501, MaximumQuantityExceededException.class },
            		{ 60, null },
            		{ 600, MaximumQuantityExceededException.class },
            		{ 500, null} });
    }
    
	@Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void sqlScoreTest() throws MaximumQuantityExceededException {
        // Setup expected exception
        if (expectedException != null) {
            thrown.expect(expectedException);
        }
        
        mockProduct.setAvailableQuantity(availableQuantity);
    }
}
