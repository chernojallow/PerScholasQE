package com.perscholas.anagram;

import java.util.HashMap;

public class Anagram {
	public static void main(String args[]) {
		System.out.println((anagram(args[0].trim().toLowerCase(), args[1].trim().toLowerCase())));
	}

	public static boolean anagram(String input1, String input2) {
		HashMap<Character, Integer> hm = new HashMap<>();
		if (input1.length() != input2.length())
			return false;

		for (int i = 0; i < input1.length(); i++) {
			if (hm.get(input1.charAt(i)) == null)
				hm.put(input1.charAt(i), 1);
			else
				hm.put(input1.charAt(i), hm.get(input1.charAt(i)) + 1);
		}

		for (int i = 0; i < input2.length(); i++) {
			if (hm.get(input2.charAt(i)) == null)
				return false;
			else
				hm.put(input2.charAt(i), hm.get(input2.charAt(i)) - 1);
		}

		for (Integer val : hm.values()) {
			if (val != 0)
				return false;
		}

		return true;
	}
}
