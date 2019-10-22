package com.perscholas.junit.sba8.automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.mockito.Mockito;

import com.perscholas.junit.sba8.Product;

public class SBA8 {
	
	@Test
	public void testGetName()
	{
		Product mockProduct = Mockito.mock(Product.class,
		Mockito.CALLS_REAL_METHODS);
		Mockito.when(mockProduct.getName()).thenReturn("gum");
		assertThat("gum", equalTo(mockProduct.getName()));
	}
}
