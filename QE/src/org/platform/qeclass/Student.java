package org.platform.qeclass;

public class Student {
	static String firstName = new String();
	static String lastName = new String();
	static String ID = new String();
	static String SSN = new String();
	static String transcript = new String();
	static String degree = new String();

	static void printStudentInfo (Student name) {
		System.out.println("Name: " + firstName + " " + lastName);
		
		if (Student.ID.isEmpty() == true)
			System.out.println("No ID provided");
		else System.out.println("ID: " + ID);
		
		if (Student.SSN.isEmpty() == true)
			System.out.println("No SSN provided");
		else System.out.println("SSN: " + SSN);
		
		if (Student.transcript.isEmpty() == true)
			System.out.println("No transcript provided");
		else System.out.println("Transcript: " + transcript);
		
		if (Student.degree.isEmpty() == true)
			System.out.println("No degree provided");
		else System.out.println("Degree: " + degree);
	}
	
	static void setStudentName (String fName, String lName) {
		Student.firstName = fName;
		Student.lastName = lName;
	}
}
