package com.perscholas.sba;

import java.util.Random;
import java.util.Scanner;

public class SBA2 {

	public static void main(String[] args) {
		Random rand = new Random();
		int min = -1, max = -1, n = -1, guess = -1;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the minimum value of number generator: ");
		min = sc.nextInt();
		System.out.print("Enter the maximum value of number generator: ");
		max = sc.nextInt();
		
		n = rand.nextInt(max - min) + min;
		if (guess == n)
			guess = rand.nextInt();
		
		while (guess != n) {
			System.out.print("Guess the number between " + min + " and " + max + ": ");
			guess = sc.nextInt();
			
			if (guess == n)
				System.out.println("You got it!");
			if (guess > n)
				System.out.println("Too high, try again");
			else if (guess < n)
				System.out.println("Too low, try again");
		}
		
		sc.close();

	}

}
