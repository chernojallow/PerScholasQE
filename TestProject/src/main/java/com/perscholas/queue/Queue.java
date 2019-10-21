package com.perscholas.queue;

import java.util.ArrayList;

public class Queue {

	private ArrayList<Integer> data = new ArrayList<Integer>();
	private int size = 0;
	
	public void enqueue(int nbr) {
		this.data.add(nbr);
		System.out.println("Push " + nbr);
	}
	
	public void dequeue() {
		this.data.remove(0);
		//int nbr = this.data.remove(0);
		//System.out.println("Pop " + nbr);
	}
	
	public int peek() {
		return this.data.get(0);
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isFull() {
		if (this.data.size() == this.size)
			return true;
		else return false;
	}
	
	public boolean isEmpty() {
		if(this.data.size() == 0)
			return true;
		else return false;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
}
