package com.perscholas.junit;

import java.util.*;

public class SimpleClass {
	public boolean returnTrue() {
		return true;
	}
	
	public boolean returnFalse() {
		return false;
	}
	
	public Object returnNull() {
		Object anyObject = null;
		return anyObject;
	}
	
	public Object returnNotNull() {
		Object anotherObject = new Object();
		return anotherObject;
	}
	
	public int returnOne() {
		return 1;
	}
	
	public List<String> returnList() {
		List<String> colors = new ArrayList<String>();
		colors.add("red");
		colors.add("green");
		colors.add("blue");
		return colors;
	}
	
	public Map<String, String> returnHashMap() {
		Map<String, String> officers = new HashMap<String, String>();
		officers.put("president", "Jane");
		officers.put("vice president", "James");
		officers.put("secretary", "Jennifer");
		officers.put("treasurer", "John");
		return officers;
	}
	
	@Override
	public String toString() {
		return "This is the custom toString ouput for SimpleClass.";
	}
}
