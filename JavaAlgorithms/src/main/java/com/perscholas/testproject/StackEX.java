package com.perscholas.testproject;

import java.util.Scanner;
import java.util.Stack;

public class StackEX {

	public static void main(String[] args) {
		Stack <Integer> stack = new Stack <Integer> ();
		
		Scanner input = new Scanner(System.in);
		
		stack.push(input.nextInt());
		int data = stack.pop();
		
		System.out.println(data);
		
		input.close();
	}

}
