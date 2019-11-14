package com.perscholas.linkedlist;

public class Node {
	private Object obj;
	private Node nextNode;

	public Node() {
		this.obj = null;
		this.nextNode = null;
	}

	public Node(Object obj, Node nextNode) {
		this.obj = obj;
		this.nextNode = nextNode;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public String toString() {
		return "Node [obj=" + obj + ", nextNode=" + nextNode + "]";
	}
}
