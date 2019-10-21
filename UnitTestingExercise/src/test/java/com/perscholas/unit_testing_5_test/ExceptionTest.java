package com.perscholas.unit_testing_5_test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import com.perscholas.unit_testing_5.InsufficientQuantityException;
import com.perscholas.unit_testing_5.MaximumQuantityExceededException;

public class ExceptionTest {
	
	@Test(expected = InsufficientQuantityException.class)
	public void throwInsufficientQuantity() throws InsufficientQuantityException {
		/* The following line would be replaced with code that would be */
		throw new InsufficientQuantityException();
	}
	
	// This example uses a rule
	@Rule
	public ExpectedException ee = ExpectedException.none();
	
	@Test
	public void throwMaximumQuantityExceeded() throws MaximumQuantityExceededException {
		ee.expect(MaximumQuantityExceededException.class);
		/* The following line would be replaced with code that would be */
		throw new MaximumQuantityExceededException();
	}
	
}
