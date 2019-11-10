package com.perscholas.spring_core_ex2.greeting_interface.impl;

import com.perscholas.spring_core_ex2.greeting_interface.GreetingService;

public class SpanishGreeting implements GreetingService {

	@Override
	public String sayHello() {
		return "Hola";
	}

	@Override
	public String sayWelcome() {
		return "Bienvenido";
	}

}
