package com.perscholas.junit.sba5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListMapClass {
	public List<String> cities() {
		List<String> cityList = new ArrayList<>();
		cityList.add("Dallas");
		cityList.add("Irving");
		cityList.add("Boston");
		cityList.add("New York");
		cityList.add("Philadelphia");
		cityList.add("Detriot");
		return cityList;
	}
	
	public List<User> getUserList() throws InvalidPasswordException {
		List<User> userList = new ArrayList<>();
		User user = new User(1, "John", "john1234", 80.0, 90.0);
		userList.add(user);
		user = new User(2, "Jane", "jane1234", 88.0, 90.0);
		userList.add(user);
		user = new User(3, "Joan", "joan1234", 83.0, 95.0);
		userList.add(user);
		return userList;
	}
	
	public Map<String, String> getCoursesMap() {
		Map<String, String> courses = new HashMap<>();
		courses.put("ASM", "Application Support Management");
		courses.put("DE", "Data Engineering");
		courses.put("JD", "Java Developer");
		courses.put("QEA", "Quality Engineering and Assurance");
		return courses;
	}
	
	public Map<Integer, User> getUserMap() throws InvalidPasswordException {
		Map<Integer, User> userMap = new HashMap<>();
		User user = new User(10, "Jose", "jose1234", 88.0, 89.0);
		userMap.put(user.getUserId(), user);
		user = new User(11, "Jovita", "jovita1234", 86.0, 91.0);
		userMap.put(user.getUserId(), user);
		user = new User(12, "Jaclyn", "jackie1234", 91.0, 82.0);
		userMap.put(user.getUserId(), user);
		return userMap;
	}
}
