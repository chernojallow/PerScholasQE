package com.perscholas.stargraph;

public class StarGraph {
	public static void main(String[] args) {
		int[] arr = { 1, 5, 2, 4, 3 };

		int size = arr.length - 1;
		Character[][] result = new Character[size+1][size+1];

		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				if (arr[r] >= c + 1)
					result[r][size-c] = '*';
				else result[r][size-c] = ' ';
			}
		}
		
		for (int r = 0; r < 5; r++) {
			for (int c = 0; c < 5; c++) {
				System.out.print(result[c][r]);
				System.out.print(' ');
			}
			System.out.println();
		}
		
	}
}
