package com.perscholas.queue;

import java.util.Random;
import java.util.Scanner;

public class QueueEx {

	public static void main(String[] args) {
		int size = 0;
		Queue data = new Queue();
		Random rand = new Random(); 
		
		// Get the size of Queue
		Scanner kb = new Scanner(System.in);
		System.out.println("How many numbers (integer value from 0 - 100) would you like to generate: ");
		size = kb.nextInt();
		data.setSize(size);
		
		// Enqueue
		for (int i = 0; i < size; i++) {
			if (!data.isFull())
				data.enqueue(rand.nextInt(101));
			else {
				System.out.println("Enqueue Error");
				System.exit(-1);
			}
		}
		
		System.out.println();
		
		// Dequeue
		for (int i = data.size() - 1; i >= 0; i--) {
			if (!data.isEmpty()) {
				System.out.println("Pop " + data.peek());
				data.dequeue();
			}
			else {
				System.out.println("Dequee Error");
				System.exit(-1);
			}
			
		}
		
		kb.close();

	}

}
