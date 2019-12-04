package com.perscholas.test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.now();
		//System.out.println(ldt.toString());
		String str = ldt.toString();
		
		Timestamp ts = Timestamp.valueOf(LocalDateTime.parse(str));
		System.out.println(ts.toString());
		
	}
}
