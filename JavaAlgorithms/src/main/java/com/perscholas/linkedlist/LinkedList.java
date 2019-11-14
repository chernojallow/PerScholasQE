package com.perscholas.linkedlist;

public class LinkedList {
	public static void main(String[] args) {
		Node n1 = new Node();
		Node n2 = new Node();
		Node n3 = new Node();
		n1.setObj(1);
		n1.setNextNode(n2);
		n2.setObj(2);
		n2.setNextNode(n3);
		n3.setObj(3);
		
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.setHead(n1);
		
		System.out.println("n1 from sll: " + sll.getHead().getObj());
		System.out.println("n2 from sll: " + sll.getHead().getNextNode().getObj());
		System.out.println("n3 from sll: " + sll.getHead().getNextNode().getNextNode().getObj());
	}
}
