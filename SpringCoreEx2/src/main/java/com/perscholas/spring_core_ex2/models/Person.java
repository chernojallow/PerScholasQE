package com.perscholas.spring_core_ex2.models;

import com.perscholas.spring_core_ex2.greeting_interface.GreetingService;

public class Person {
	private String name;
	private GreetingService greetingService;

	public Person() {
		this.name = null;
		this.greetingService = null;
	}

	public Person(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GreetingService getGreetingService() {
		return greetingService;
	}

	public void setGreetingService(GreetingService greetingService) {
		this.greetingService = greetingService;
	}
}
