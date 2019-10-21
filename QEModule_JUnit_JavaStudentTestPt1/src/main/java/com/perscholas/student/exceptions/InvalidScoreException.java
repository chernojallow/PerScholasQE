package com.perscholas.student.exceptions;

public class InvalidScoreException extends Exception {
	private static final long serialVersionUID = 1L;
	/*There are two constructors, one no-arg constructor
	and a constructor which accepts a string as
	a parameter*/
	public InvalidScoreException() {
		super();
	}
	public InvalidScoreException(String eMessage) {
		super(eMessage);
	}
}
