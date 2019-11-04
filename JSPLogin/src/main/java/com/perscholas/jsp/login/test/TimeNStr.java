package com.perscholas.jsp.login.test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TimeNStr {

	public static void main(String[] args) {
		LocalDateTime ldt = LocalDateTime.now();
		String con = ldt.toString().replace('T', ' ');
		Timestamp ts = Timestamp.valueOf(ldt);
		Timestamp ts1 = Timestamp.valueOf(con);
		LocalDateTime ldt1 = ts.toLocalDateTime();
		System.out.println(ldt + "\n" + ldt1 + "\n" + ts + "\n" + ts1);
		
		System.out.printf("%s%c\n", 'h', 'i');
		System.out.printf("%s%c\n", 'i', "h");
		System.out.printf("%c%c\n", 'h', 'i');
		System.out.printf("%d%c\n", 'h', 'i');
	}
}
