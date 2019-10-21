package com.perscholas.java_basics;

public class JavaBasics {

	/* Write a program that declares 2 integer variables, assigns an integer to each and adds them together.
	 *  Assign the sum to a variable. Print out the result */
	public static void ex1() {
		int n1 = 5, n2 = 15;
		
		n2 = n2 + n1;
		System.out.println("ex1: " + n2);
	}
	
	/* Write a program that declares 2 double variables, assigns a number to each and adds them together.
	 *  Assign the sum to a variable. Print out the result. */
	public static void ex2() {
		double n1 = 5.489637, n2 = 15.398479251;
		
		n2 = n2 + n1;
		System.out.println("ex2: " + n2);
	}
	
	/* Write a program that declares an integer variable and a double variable, assigns numbers to each, 
	 * and adds them together. Assign the sum to a variable. Print out the result. What variable type must the sum be? */
	public static void ex3() {
		int n1 = 5;
		double n2 = 15.4213875;
		
		n2 = n2 + n1;
		System.out.println("ex3: " + n2);
	}
	
	/* Write a program that declares 2 integer variables, assigns an integer to each and divides the larger number by 
	 * the smaller number. Assign the result to a variable. Print out the result. Now change the larger number to 
	 * a decimal. What happens? What corrections are needed? */
	public static void ex4() {
		int n1 = 5, n2 = 15;
		System.out.println("ex4: " + n2/n1);
		
		double n3 = 15.2348975;
		System.out.println(n3/n1);
		
	}
	
	/* Write a program that declares 2 double variables, assigns a number to each and divides the larger by the smaller.
	 *  Assign the result to variable. Print out the result. Now cast the result to an integer. 
	 *  Print out the result again. */
	public static void ex5() {
		double n1 = 5.1239847, n2 = 15.982734;
		
		double n3 = n2/n1;
		System.out.println("ex5: " + n3);
		System.out.println((int)n3);
	}
	
	/* Write a program that declares 2 integer variables, x and y, and assign 5 to x and 6 to y. 
	 * Declare a variable q and assign y/x to it and print q. Now cast y to a double and assign to q. Print q again. */
	public static void ex6() {
		int x = 5, y = 6;
		double q = y/x;
		
		System.out.println("ex6: " + q);
		
		q = (double) y;
		System.out.println(q);
	}
	
	/* Write a program that declares a named constant and uses it in a calculation. Print the result. */
	public static void ex7() {
		final int n1 = 5;
		
		System.out.println("ex7: " + n1);
	}
	
	/* Write a program where you create 3 variables that represent products at a cafe. 
	 * The products could be beverages like coffee, cappuccino, espresso, green tea, etc. 
	 * Assign prices to each product. Create 2 more variables called subtotal and totalSale and complete an 
	 * “order” for 3 items of the first product, 4 items of the second product and 2 items of the third product. 
	 * Add them all together to calculate the subtotal. Create a constant called SALES_TAX and add sales tax to 
	 * the subtotal to obtain the totalSale amount. Be sure to format the results to 2 decimal places. */
	public static void ex8() {
		int coffee = 2 , cappuccino = 4, espresso = 6;
		double subtotal, totalSale;
		subtotal = 3 * coffee + 4 * cappuccino + 2 * espresso;
		final double SALES_TAX = 2.1;
		
		totalSale = subtotal + SALES_TAX;
		System.out.printf("ex8: %.2f\n", totalSale);
	}
	
	/* Using the previous problem, print out the results in a neat and explicit manner such as
	 * Coffee: 2 @ 3.99 = $6.98		Espresso: 1 @ 4.50 = $4.50		Subtotal: $11.48
	 * Sales Tax: $0.95				Total: $12.43
	 */
	public static void ex9() {
		int coffee = 2 , cappuccino = 4, espresso = 6;
		double subtotal, totalSale;
		subtotal = 3 * coffee + 4 * cappuccino + 2 * espresso;
		final double SALES_TAX = 2.1;
		
		totalSale = subtotal + SALES_TAX;
		System.out.printf("ex8:\nCoffee: 3 @ %d = $%d\tCappuccino: 4 @ %d = $%d\t\tEspresso: 2 @ %d = $%d\n"
				, coffee, coffee * 3, cappuccino, cappuccino * 4, espresso, espresso * 2);
		System.out.println("Subtotal: $" + subtotal + "\t\tSales Tx: $" + SALES_TAX + "\t\tTotal: $" + totalSale);
	}
	
	/* Write a program that declares 2 String variables to hold your first name and last name. 
	 * Concatenate them and print the result. Be sure to include a space between your first and last names. 
	 * Use 2 different ways to concatenate the 2 strings. */
	public static void ex10() {
		String firstName = "Lin", lastName = "Xiao";
		System.out.println("ex10: " + firstName + " " + lastName);
		System.out.println(String.join(" ", firstName, lastName));
		System.out.println(firstName.concat(" " + lastName));
	}
	
	public static void main(String[] args) {
		ex1();
		ex2();
		ex3();
		ex4();
		ex5();
		ex6();
		ex7();
		ex8();
		ex9();
		ex10();
		
		int x = 0;
		while (x <= 100) {
			System.out.println(x);
			x = x + 10;
		}
		
	}

}
