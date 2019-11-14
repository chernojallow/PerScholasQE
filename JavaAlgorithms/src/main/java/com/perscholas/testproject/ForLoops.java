package com.perscholas.testproject;
public class ForLoops {
	/* Here is the basic for-loop we discussed this morning. Your assignment is to 
	 * reverse the loop so that the output is "5 4 3 2 1". After that, see if you 
	 * can figure out how to change the increment for each loop to 2 using the 
	 * original forward loop so that the output is "1 3 5". */
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.printf("%d ", arr[i]);
		}
		
		System.out.println();
		for (int i = 0; i <= arr.length; i = i + 2) {
			System.out.printf("%d ", arr[i]);
		}
		
	}
}