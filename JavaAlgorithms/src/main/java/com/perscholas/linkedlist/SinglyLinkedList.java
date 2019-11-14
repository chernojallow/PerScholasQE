package com.perscholas.linkedlist;

public class SinglyLinkedList {
	private Node head;

	public SinglyLinkedList() {
		this.head = null;
	}

	public SinglyLinkedList(Node head) {
		this.head = head;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	@Override
	public String toString() {
		return "SinglyLinkedList [head=" + head + "]";
	}
}
