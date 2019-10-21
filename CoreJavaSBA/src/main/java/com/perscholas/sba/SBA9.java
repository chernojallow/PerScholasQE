package com.perscholas.sba;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.perscholas.sba_models.SBA9Student;

public class SBA9 {

	public static List<SBA9Student> loadStudent() {
		List<SBA9Student> sList = new ArrayList<SBA9Student> ();
		String name = null;
		
		SBA9Student student = null;
		
		try {
			Scanner fr = new Scanner(new File("./students.txt"));
			Scanner sc = new Scanner(System.in);
			
			while (fr.hasNext()) {
				student = new SBA9Student();
				name = fr.nextLine();
				student.setName(name);
				System.out.printf("Score for %s: ", student.getName());
				student.setScore(sc.nextDouble());
				sList.add(student);
			}
			
			sc.close();
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sList;
	}
	
	public static void printResult(List<SBA9Student> studentList) {
		
		try {
			PrintWriter fw = new PrintWriter(new FileWriter("./output.txt"));
			
			for (int j = 0; j < studentList.size(); j++) {
				System.out.printf("%s\t\tScore = %.2f\n", studentList.get(j).getName(), studentList.get(j).getScore());
			}
			
			System.out.printf("Lowest = %.2f\nHighest = %.2f\nAverage = %.2f", 
					lowest(studentList), highest(studentList), average(studentList));
			
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static double lowest(List<SBA9Student> studentList) {
		double lowest = 100;
		for(SBA9Student s: studentList) {
			if (s.getScore() < lowest)
				lowest = s.getScore();
		}
		return lowest;
	}
	
	public static double highest(List<SBA9Student> studentList) {
		double highest = 0;
		for(SBA9Student s: studentList) {
			if (s.getScore() > highest)
				highest = s.getScore();
		}
		return highest;
	}
	
	public static double average(List<SBA9Student> studentList) {
		double total = 0;
		int i = 0;
		
		for(i = 0; i < studentList.size(); i++) {
			total = studentList.get(0).getScore();
		}
		
		return total/i;
	}
	
	public static void main(String[] args) {
		List <SBA9Student> sList = loadStudent();		
		
		printResult(sList);
	}

}
