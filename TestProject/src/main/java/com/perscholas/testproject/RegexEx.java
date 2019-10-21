package com.perscholas.testproject;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEx {
	public static void main(String[] args) {
		String un = null, pw = null;
		Scanner sc = new Scanner(System.in);
		Matcher matcher = null;
		
		System.out.print("Enter the username: ");
		un = sc.nextLine();
		
		Pattern unp = Pattern.compile("[a-z0-9_-]{8}");
		matcher = unp.matcher(un);
		
		if (matcher.find())
			System.out.println("Valid username");
		else System.out.println("Invalid username");
		
		System.out.print("Enter the password: ");
		pw = sc.nextLine();
		
		Pattern pwp = Pattern.compile("[A-Za-z0-9]{6}");
		matcher = pwp.matcher(pw);
		
		if (matcher.find())
			System.out.println("Valid password");
		else System.out.println("Invalid password");
		
		sc.close();
	}
}
