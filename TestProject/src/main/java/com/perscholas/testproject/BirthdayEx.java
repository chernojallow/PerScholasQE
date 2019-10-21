package com.perscholas.testproject;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class BirthdayEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.print("Enter your date of birth (MM-DD-YYYY): ");
		String bdstr = sc.nextLine();
		
		try {
			int month = Integer.parseInt(bdstr.substring(0, 2));
			int day = Integer.parseInt(bdstr.substring(3, 5));
			int year = Integer.parseInt(bdstr.substring(6, 10));
			
			LocalDate bd = LocalDate.of(year, month, day);
			LocalDate today = LocalDate.now();
			
			long t = ChronoUnit.YEARS.between(bd, today);
			System.out.println(t);
		} catch (Exception e) {
			System.out.println("Input error");
		}
		
		sc.close();
	}

}
