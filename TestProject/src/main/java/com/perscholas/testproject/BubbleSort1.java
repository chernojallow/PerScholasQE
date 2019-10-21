package com.perscholas.testproject;

public class BubbleSort1 {

	public static void main(String[] args) {
		int Bill[] = new int [] {9, 7, 3, 6, 2};
		int temp = 0;
		
		for (int i = 1; i < Bill.length; i++) {
			for (int j = Bill.length - 1; j >= i; j--) {
				if (Bill[j] < Bill[j-1]) {
					temp = Bill[j];
					Bill[j] = Bill[j-1];
					Bill[j-1] = temp;
				}
			}
		}
		
		for (int i = 0; i < Bill.length; i++) {
			// Console
			System.out.printf("%d ", Bill[i]);
			if (i % 12 == 0 && i != 0) 
				System.out.println();
		}

	}

}
