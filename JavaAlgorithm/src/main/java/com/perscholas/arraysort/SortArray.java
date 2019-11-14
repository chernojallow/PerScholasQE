package com.perscholas.arraysort;

import java.util.Random;
import java.util.Scanner;

public class SortArray {
	public static void main(String[] args) {
		FindCreditScore fcs = new FindCreditScore();
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		System.out.print("Enter the size of array: ");
		Integer arr[] = new Integer[sc.nextInt()];

		for (int i = 0; i < arr.length; i++)
			arr[i] = rand.nextInt(851);

		QuickSort qs = new QuickSort();
		qs.sort(arr, 0, arr.length - 1);

		System.out.println();
		System.out.println("Sorted Array: ");
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");

		Integer diff = arr[arr.length - 1] - arr[0];
		System.out.println("\n");
		System.out.println("Max - Min : " + diff);
		System.out.println();

		fcs.find800(arr);
		System.out.println();
		fcs.findgreater700(arr);
		System.out.println();
		fcs.findless600(arr);

		sc.close();
	}

}
