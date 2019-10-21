package com.perscholas.software_developer_club;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ClubMemberApp {

	public static void main(String[] args) throws IOException {
		// Input & output files, variables
		Scanner fr = new Scanner(new File("./src/main/java/com/perscholas/software_developer_club_files/members.txt")); 
		PrintWriter fw = new PrintWriter(new FileWriter("./src/main/java/com/perscholas/software_developer_club_files/output.txt"));
		ArrayList <ClubMember> cms = new ArrayList <ClubMember>();
		ArrayList <StringBuilder> str = new ArrayList <StringBuilder> ();
		//StringBuilder str = new StringBuilder (), name = new StringBuilder (), flan = new StringBuilder ();
		ClubMember input = null;
		Location loc = null;
		int spoint = 0;
		
		// Read first line from file
		new StringBuilder(fr.nextLine());
		// Input from members.txt
		
		while (fr.hasNext()) {
			str.add(new StringBuilder());
			
			
		}
		
		fr.close();
		fw.close();

	}

}
