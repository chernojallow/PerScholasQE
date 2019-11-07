package com.perscholas.spring_core_ex2.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.perscholas.spring_core_ex2.greeting_interface.GreetingService;

public class Person {
	private String name;
	@Autowired
	@Qualifier("spanish")
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
