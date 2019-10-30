package com.perscholas.jsplogin;

public class Testing {
	public static void main(String[] args) {
		String fn = null;
		String ln = "hi";
		String email =  "hi";
		String dob =  "hi";
		String un =  "hi";
		String pass =  "hi";
		String cpass =  "";
		
		if (fn == null || ln == null || email == null || dob == null || un == null || pass == null || cpass == null) {
			System.out.println("if1 pass");
		} else if (pass != cpass) {
			System.out.println("if2 pass");
		}
		else System.out.println("all pass");
		
	}
}
