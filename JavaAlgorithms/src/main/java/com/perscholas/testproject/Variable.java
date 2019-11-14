package com.perscholas.testproject;

public class Variable {

	public static void main(String[] args) {		
		int arr[] = new int[] {1,2,3,4,5};
		
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("%d ", arr[i]);
		}
		System.out.println();
		System.out.println();
		
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("%d ", i);
		}

	}

}
