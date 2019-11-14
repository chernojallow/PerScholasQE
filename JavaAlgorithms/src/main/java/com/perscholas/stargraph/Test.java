package com.perscholas.stargraph;

public class Test {
	public static void main(String[] args) {
		int[] arr = {1, 5, 2, 4, 3};
		int size = arr.length;
		
		for (int r = 0; r < size; r++) {
			for (int c = 0; c < size; c++) {
				if (r >= size - arr[c])
					System.out.print('*');
				else System.out.print(' ');
				System.out.print(' ');
			}
			System.out.println();
		}

	}
}
