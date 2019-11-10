package com.perscholas.spring_core_ex2.greeting_interface.impl;

import com.perscholas.spring_core_ex2.greeting_interface.GreetingService;

public class EnglishGreeting implements GreetingService {

	@Override
	public String sayHello() {
		return "Hello";
	}

	@Override
	public String sayWelcome() {
		return "Welcome";
	}
	
}
