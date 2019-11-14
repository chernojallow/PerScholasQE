package com.perscholas.testproject;

public class SQLDateToJavaData {

	public static void main(String[] args) {
		// java.util.Date to java.sql.Date
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		System.out.println("SQL Date from util: " + sqlDate);
		// java.sql.Date to java.util.Date
		@SuppressWarnings("deprecation")
		java.sql.Date platformLaunchSql = new java.sql.Date((2018-1900),2,5);
		java.util.Date platformLaunchUtil = new java.util.Date(platformLaunchSql.getTime());
		System.out.println("Util Date from sql: " + platformLaunchUtil);

	}

}
