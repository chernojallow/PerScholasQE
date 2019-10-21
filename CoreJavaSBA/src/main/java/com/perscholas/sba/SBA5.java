package com.perscholas.sba;

import java.util.ArrayList;
import java.util.Scanner;

public class SBA5 {

	public static void main(String[] args) {
		int input = -1;
		ArrayList <String> menu = new ArrayList <String>();
		String str = null;
		Scanner sc = new Scanner(System.in);
		
		while (input != 4) {
			System.out.println("Selections: ");
			System.out.println("1) Add to menu");
			System.out.println("2) Remove from menu");
			System.out.println("3) Display menu items");
			System.out.println("4) Quit");
			
			System.out.println("Select a number from 1 - 4: ");
			input = sc.nextInt();
			sc.nextLine();
			
			if (input == 1) {
				System.out.println("Enter the name of item you want to add to the menu: ");
				str = sc.nextLine();
				menu.add(str);
				System.out.println(str + " added to the menu\n");
			}
			else if (input == 2) {
				System.out.println("Enter the name of item you delete to add to the menu: ");
				str = sc.nextLine();
				
				if (menu.contains(str)) {
					menu.remove(str);
					System.out.println(str + "removed from the menu\n");
				}
				else System.out.println(str + " is not in the menu\n");
			}
			else if (input == 3) {
				for (String a: menu)
					System.out.println(a);
				System.out.println();
			}
			else if (input == 4)
				System.out.println("Thanks for using!");
			else System.out.println("Please provded a number from 1 - 4\n");
			
		}

		sc.close();
	}

}
