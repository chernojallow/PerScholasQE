package com.perscholas.arraysort;

public class FindCreditScore {
	public void find800(Integer[] arr) {
		int count = 0;

		System.out.println("find 800: ");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 800) {
				System.out.println(arr[0] + " ");
				count++;
			}
		}

		if (count == 0)
			System.out.println("No 800 Credit Score");
		else
			System.out.println(count + "800 Credit Score");
	}

	public void findgreater700(Integer[] arr) {
		int count = 0;

		System.out.println("greater than 700: ");

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 700) {
				System.out.print(arr[i] + " ");
				count++;
			}
		}

		if (count == 0)
			System.out.println("None greater than 700");
		else
			System.out.println();
	}

	public void findless600(Integer[] arr) {
		int count = 0;

		System.out.println("less than 600: ");

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 600) {
				System.out.print(arr[i] + " ");
				count++;
			}
		}

		if (count == 0)
			System.out.println("None less than 600");
		else
			System.out.println();
	}
}
