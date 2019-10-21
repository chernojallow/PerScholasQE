package com.perscholas.stringalg;

import java.util.Arrays;
import java.util.List;

public class StringEx {

	public String[] returnWords() {
		String demo = "Hello 2019 QE02!";
		String[] strArr = demo.split(" ");
		return strArr;
	}
	
	public String returnStringFromArray() {
		String[] wordArr = returnWords();
		String joinedArray = String.join("-", wordArr);
		return joinedArray;
	}
	
	public List<String> arrayToListDemo() {
		String demo = "Hello 2019 QE02!";
		String[] strArr = demo.split(" ");
		
		List<String> stringList = Arrays.asList(strArr);
		
		System.out.println("Contents of stringList: " + stringList);
		System.out.println("Loop Through stringList: ");
		
		for (String s : stringList)
			System.out.println("\t" + s);
			
		return stringList;
	}
	
	public static void main(String[] args) {
		StringEx strArr = new StringEx();
		
		System.out.println("Array from String: " + Arrays.toString(strArr.returnWords()));
		System.out.println("Joined Array: " + strArr.returnStringFromArray());
		
		strArr.arrayToListDemo();
	}

}