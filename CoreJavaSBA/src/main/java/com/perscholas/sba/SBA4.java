package com.perscholas.sba;

import java.util.Scanner;

public class SBA4 {

	public static void main(String[] args) {
		int input = -1;
		
		Scanner sc = new Scanner(System.in);
		
		while (input != 4) {
			System.out.println("Select number from 1 - 4: ");
			
			input = sc.nextInt();
			
			if (input == 1)
				System.out.println("Good morning\n");
			else if (input == 2)
				System.out.println("Good afternoon\n");
			else if (input == 3)
				System.out.println("Good evening\n");
			else if (input == 4)
				System.out.println("Good night\n");
			else System.out.println("Please provide a number from 1 - 4\n");
		}
		
		sc.close();

	}

}
