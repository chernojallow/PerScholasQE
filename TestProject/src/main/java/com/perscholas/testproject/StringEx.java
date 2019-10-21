package com.perscholas.testproject;

public class StringEx {

	public static void main(String[] args) {
		String demo = new String("Hello 2019 QE"); 
		demo = demo.concat("02");
		
		String[] demoSplit = demo.split(" ");
//		demoSplit = demo.split(" ");
		for(String str:demoSplit)
			System.out.println(str);
		
		System.out.printf("String Length = %d\nString = %s", demo.length(), demo);
	}

}