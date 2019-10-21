package com.perscholas.unit_testing_exercise;

import java.util.Random;

public class Ex1 {
	Random rand = new Random();
	
	public int returnDoubletoInt() {
		double n = rand.nextDouble();
		
		return (int) n;
	}
	
	public int returnNbr() {
		return rand.nextInt();
	}
	
	public Character[] returnString() {
		int n = rand.nextInt(10) + 1;
		Character[] arr = new Character[n];
		
		for(int i = 0; i < n; i++)
			arr[i] = (char) (rand.nextInt(26) + 'a');
		
		return arr;
	}
	
	public Boolean returnBool() {
		return rand.nextBoolean();
	}
}
