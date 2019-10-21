package com.perscholas.sba;

import java.util.Scanner;

import com.perscholas.sba_models.SBA3Course;

public class SBA3 {

	public static void main(String[] args) {
		int id = -1;
		String name = null, desc = null;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the course ID: ");
		id = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Enter the course name: ");
		name = sc.nextLine();
		
		System.out.print("Enter the course description: ");
		desc = sc.nextLine();
		
		SBA3Course c1 = new SBA3Course(id, name, desc);
		System.out.println(c1.toString());
		
		sc.close();

	}

}
