package com.perscholas.testproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class BubbleSort2 {

	public static void main(String[] args) throws FileNotFoundException {
		float Scores[] = new float [24];
		
		// Input & output
		File infile = new File ("C://Users/Student/eclipse-workspace/TestProject/src/main/java/com/perscholas/"
				+ "testproject/BS2Input.txt");
		Scanner input = new Scanner (infile);
		PrintWriter output = new PrintWriter ("C://Users/Student/eclipse-workspace/TestProject/src/main/java/com/"
				+ "perscholas/testproject/BS2Output.txt");
		
		// Import data from ArrayInput.txt
		importData(Scores, input);
		
		// Sort
		sortData(Scores);
		
		// Print
		System.out.println();
		System.out.println();
		System.out.println("Sorted Data: ");
		for (int i = 0; i < Scores.length; i++) {
			// Console
			System.out.printf("%6.2f ", Scores[i]);
			if ((i+1) % 4 == 0 && i != 0) 
				System.out.println();
			
			// File
			output.printf("%.2f\n", Scores[i]);
		}
		
		System.out.println("\nMin: " + Scores[0]);
		System.out.println("Max: " + Scores[23]);
		
		input.close();
		output.close();
	}

	
	public static void importData (float[] data, Scanner input) {
		System.out.println("Data Read:");
		for (int i = 0; input.hasNext(); i++) {
			data[i] = input.nextFloat();
			System.out.printf("%6.2f ", data[i]);
			if ((i+1) % 4 == 0 && i != 0)
				System.out.println();
		}
	}
	
	public static void sortData (float[] data) {
		float temp = 0;
		for (int i = 1; i < data.length; i++) {
			for (int j = data.length - 1; j >= i; j--) {
				if (data[j] < data[j-1]) {
					temp = data[j];
					data[j] = data[j-1];
					data[j-1] = temp;
				}
			}
		}
	}
	
}
