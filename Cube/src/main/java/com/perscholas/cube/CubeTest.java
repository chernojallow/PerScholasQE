package com.perscholas.cube;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class CubeTest {	
		// Declare atttibutes
		private static Cube cubeClass;
		private Integer l = null;
		private Integer w = null;
		private Integer h = null;
		private Integer vol = null;
		private Boolean confirmation = null;

		/* Create the constructor. The order of arguments in the parentheses
		 * determines the parameter position in the two-dimensional Object arrays.
		 * Parameter1 = argument num1, Parameter2 = argument num2,
		 * Parameter3 = argument testSum, Parameter4 = argument confirmation*/
		public CubeTest(Integer l, Integer w,
				Integer h, Integer vol, Boolean confirmation) {
			this.l = l;
			this.w = w;
			this.h = h;
			this.vol = vol;
			this.confirmation = confirmation;
		}

		/* Set up the parameters. The confirmation parameter is null and will
		 * be assigned in the actual test method depending on accuracy of
		 * the addition result. */
		@Parameters()
	    public static Collection<Object[]> data() {
	        return Arrays.asList(
	                new Object[][] {
	                		{ 2, 3, 4, 24, true },
	                		{ 1, 2, 4, 8, true },
	                		{ 3, 3, 2, 20, false },
	                		{ 2, 5, 3, 45, false }
	                		});
	    }

	    // Create the static class variable additionClass to run the test methods
//	    @BeforeClass
//	    public static void setUp() {
//	    	additionClass = new Cube();
//	    }

	    // Run the test
	    @Test
	    public void cubeTest() {
	    	cubeClass = new Cube(l, w, h);
	    	
	    	Integer expected = cubeClass.calculateVolume();
	    	
	    	if (vol == expected) {
	        	assertThat(expected, equalTo(vol));
	    	} else {
	        	assertThat(expected, not(equalTo(vol)));
	    	}

	    	System.out.printf("%d * %d * %d = %d is %s\n",
	    			l, w, h, vol, Boolean.toString(confirmation));
	    }
}
