package com.perscholas.file_ex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileEx {
	public static void main(String[] args) throws IOException {
		// Check current directory
		// System.out.println("Working Directory = " + System.getProperty("user.dir"));
		
		// Input & output files
		Scanner fr = new Scanner(new File("./input.txt")); 
		PrintWriter fw = new PrintWriter(new FileWriter("./output.txt"));
		
		// Prompt user for number of questions
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter how many question(s) you would like to answer (Max 6): ");
		int qnbr = sc.nextInt();
		int cqn = 0;
		sc.nextLine();
		System.out.println();
		
		@SuppressWarnings("unchecked")
		ArrayList <String> [] question = new ArrayList [qnbr];
		ArrayList <String> answers = new ArrayList<String> ();
		StringBuilder input = new StringBuilder ();
		
		// Input and answers
		for(int i = 0; i < qnbr; i++) {
			int j = 0;
			question[i] = new ArrayList <String> ();
			while(fr.hasNextLine() && j < 5) {
				input.append(fr.nextLine());
				// Look for '*' for correct answer
				if (j > 0 && input.charAt(0) == '*') {
					question[i].add(input.toString().substring(1, input.length()));
					answers.add(question[i].get(j));
				}
				else question[i].add(input.toString());
				
				input.delete(0, input.length());
				j++;
			}
		}
		
		// User input, print statements, grade calculation
		char user = 0;
		for (int i = 0; i < qnbr; i++) {
			for (int j = 0; j < 5; j++)
				System.out.println(question[i].get(j));
			System.out.println("Enter your answer: ");
			user = sc.next().toUpperCase().charAt(0);
			
			fw.println(question[i].get(0));
			fw.println("User answer: " + user);
			fw.println("Correct answer: " + answers.get(i).charAt(0));
			fw.println();
			
			if (user == answers.get(i).charAt(0))
				cqn++;
		}
		
		System.out.printf("\nGrade = %.2f", (float) 100 * cqn / qnbr);
		fw.printf("Grade = %.2f", (float) 100 * cqn / qnbr);
		
		sc.close();
		fr.close();
		fw.close();
		
	}

}
