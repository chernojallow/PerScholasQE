package org.perscholas.stringexs;

import java.util.ArrayList;

public class StringExs {
	
	// Print "llo 201"
	public static String ex1() {
		String data = "Hello 2019 QE02!";
		int begin = 0, end = 0;
		
		
		for (int i = 0; i < data.length(); i++) {
			// Set begin after finding "He"
			if (data.charAt(i) == 'H' && data.charAt(i+1) == 'e') {
				begin = i + 2;
				
				// Set end before finding "9 Q"
				for (int n = begin + 1; n < data.length(); n++) {
					if (data.charAt(n) == '9' && data.charAt(n+1) == ' ' && data.charAt(n+2) == 'Q')
						end = n;
				}
			}
		}
		
		return data.substring(begin, end);
	}
	
	// Split string into ArrayList for each line 
	public static ArrayList<String> ex2() {
		int begin = 0, end = 0;
		String data = "red,green,blue;square,triangle,circle;dog,cat,bird";
		String line = "\0";
		ArrayList<String> dataSet = new ArrayList<String>();
		
		for (int i = 0; i < data.length(); i++) {
			
			// Use substring to get part of data for line
			if (data.charAt(i) == ',') {
				end = i;
				
				if (!line.equals("\0")) 
					line = line + ' ' + data.substring(begin, end);
				else line = data.substring(begin, end);
				
				//System.out.println("With , = " + line);
				
				begin = i + 1; 
			}
			else if (data.charAt(i) == ';' || i == data.length() - 1) {
				if (data.charAt(i) == ';')
					end = i;
				else end = i + 1;
				
				line = line + ' ' + data.substring(begin, end);
				begin = i + 1;
				
				//System.out.println("With ; = " + line);
				
				dataSet.add(line);
				line = "\0";
			}
			
		}
		
		return dataSet;
	}
	
	// Split string into 2d-array
	public static String[][] ex3() {
		int begin = 0, end = 0;
		String[][] dataSet = new String[3][3];
		String data = "red,green,blue;square,triangle,circle;dog,cat,bird";
		String line = "\0";
		
		for (int i = 0; i < data.length(); i++) {
			
			if (data.charAt(i) == ';' || data.charAt(i) == ',' || i == data.length() - 1) {
				if (data.charAt(i) == ';' || data.charAt(i) == ',')
					end = i;
				else end = i + 1;
				
				line = data.substring(begin, end);
				begin = i + 1;
				
				//System.out.println("With , = " + line);
				
				// Loop to find the correct place to put line
				for (int row = 0; row < 3; row++) {
					for (int col = 0; col < 3; col++) {
						if (dataSet[row][col] == null) {
							dataSet[row][col] = line;
							row = col = 3;
						}
					}
				}
				
			}
		}
		
		return dataSet;
	}

	public static void main(String[] args) {
		ArrayList<String> ex2Data = ex2();
		String[][] ex3Data = ex3();
		
		System.out.println("Ex1");
		System.out.println(ex1());
		
		System.out.println();
		System.out.println("Ex2");
		for (int i = 0; i < ex2Data.size(); i++)
			System.out.println(ex2Data.get(i));
		
		System.out.println();
		System.out.println("Ex3");
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++)
				System.out.print(ex3Data[row][col] + ' ');
			
			System.out.println();
		}
		
	}
	
}