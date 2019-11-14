package com.perscholas.arraygroups;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ArrayGroups {
	public static void main(String[] args) {
		Integer arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		Integer row = null, col = null, nbr = null;
		List<Integer> test = new ArrayList<Integer>();
		int size = arr.length;

		System.out.print("Size of subarray: ");
		col = sc.nextInt();

		row = size / col + 1;
		Integer result[][] = new Integer[row][col];

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (size == test.size())
					result[r][c] = null;
				else {
					do {
						nbr = rand.nextInt(size);
					} while (test.contains(size));
					test.add(nbr);
					result[r][c] = arr[nbr];
				}
				System.out.print(result[r][c] + " ");
			}
			System.out.println();
		}

		sc.close();
	}
}
