package org.platform.fizzbuzz;

public class FizzBuzz {

	public static void main(String[] args) {
		// declaration and initialize for outputs
		String Fizz = "Fizz", Buzz = "Buzz", FizzBuzz = "Fizz Buzz", nbr = "Number";
		// main for loop increment from 1 to 100
		for (int i = 1; i <= 100; i = i + 1) {
			
			// check if i is multiple of 3 and/or 5
			if (i % 5 == 0 && i % 3 == 0)
				System.out.printf("%03d = %s\t", i , FizzBuzz);
			else if (i % 5 == 0)
				System.out.printf("%03d = %s\t", i, Buzz);
			else if (i % 3 == 0)
				System.out.printf("%03d = %s\t", i, Fizz);
			else System.out.printf("%03d = %s\t", i, nbr);
			
			// newline for better display
			if (i % 8 == 0)
				System.out.println();
		}
		
	}
	
}
