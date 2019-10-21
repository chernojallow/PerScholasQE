package com.perscholas.testproject;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTime {

	public static void main(String[] args) {
		// Retrieve & print the current time using a specified format
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
		String s = dtf.format(currentDateTime);
		System.out.println("Today's date is: " + s);
		
		// Create a LocalDate object and print it
		LocalDate platformLaunchDate = LocalDate.of(2018, 3, 5);
		System.out.println("Platform launch date: " + platformLaunchDate);
		
		// Compare 2 LocalDate objects
		LocalDate today = LocalDate.now();
		int c = today.compareTo(platformLaunchDate);
		if (c > 0)
			System.out.println("Today is later than Platform Dallas launch date");
		
		// Calculate difference between 2 LocalDateTime objects
		LocalDateTime platformLaunchTime = LocalDateTime.of(2018, 03, 5, 9, 0);
		long t = ChronoUnit.MINUTES.between(platformLaunchTime, currentDateTime);
		System.out.println("Minutes since Platform launch: " + t);

	}

}
