package com.perscholas.capitalizedwords;

public class CapitalizeWords {
	public static void main(String[] args) {
		String str = "red green blue cyan magenta yellow";
		
		str = str.substring(0, 1).toUpperCase() + str.substring(1);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ')
				str = str.substring(0, i + 1) + str.substring(i + 1, i + 2).toUpperCase() + str.substring(i + 2);
		}

		System.out.println(str);
	}
}
