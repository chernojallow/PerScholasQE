package com.perscholas.anagram;

import java.util.HashMap;

// iiit & ittt pass
public class Test {
	public static void main(String[] args) {
		Boolean result = true;
		String input1 = args[0].trim().toLowerCase();
		String input2 = args[1].trim().toLowerCase();
		HashMap<Character, Integer> hm = new HashMap<>();
		
		
		if (input1.length() != input2.length())
			result = false;

		for (int i = 0; i < input1.length(); i++) {
			if (hm.containsKey(input1.charAt(i)))
				hm.replace(input1.charAt(i), hm.get(input1.charAt(i)) + 1);
			else
				hm.put(input1.charAt(i), 1);
		}

		for (int i = 0; i < input2.length(); i++) {
			if (hm.containsKey(input2.charAt(i)))
				hm.replace(input2.charAt(i), hm.get(input2.charAt(i)) + 1);
			else
				result = false;
		}

		for (Integer i : hm.values()) {
			if (i % 2 != 0)
				result = false;
		}

		if (result)
			System.out.println("true");
		else
			System.out.println("false");
	}
}
