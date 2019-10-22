package com.perscholas.junit.sba7.automation;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.perscholas.junit.sba7.AddVaryingTypeCalculator;

@RunWith(Parameterized.class)
public class ParameterizedAVTC {
	private static AddVaryingTypeCalculator avtc;
	private List<Object> num;
	private Double sum;
	private Class<? extends Exception> expected;


	public ParameterizedAVTC(List <Object> num, Double sum, Class<? extends Exception> e) {
		this.num = num;
		this.sum = sum;
		this.expected = e;
		
	}

	
	@Parameters()
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][] {
                		{Arrays.asList("2.0", '8'), 9.0, null},
                		{Arrays.asList("3.0", 7), 12.0, null},
                		{Arrays.asList("web", '4'), 8.0, NumberFormatException.class},
                		{Arrays.asList("5.0", 'x'), 26.0, IllegalArgumentException.class},
                		{Arrays.asList("9.0", '2', 5, 4.0), 23.0, null} });
    }

    @BeforeClass
    public static void setUp() {
    	avtc = new AddVaryingTypeCalculator();
    }
    
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
	@Test
	public void test() throws IllegalArgumentException, NumberFormatException {
		if (expected != null)
            thrown.expect(expected);
		
		double actual = avtc.addTwoNumbersVaryingType(num);
		
		if(actual == sum)
			assertThat(actual, equalTo(sum));
		else assertThat(actual, not(equalTo(sum)));
	}
}

