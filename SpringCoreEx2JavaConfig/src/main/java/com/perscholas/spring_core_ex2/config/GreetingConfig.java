package com.perscholas.spring_core_ex2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.perscholas.spring_core_ex2.greeting_interface.impl.EnglishGreeting;
import com.perscholas.spring_core_ex2.greeting_interface.impl.SpanishGreeting;
import com.perscholas.spring_core_ex2.models.Person;

@Configuration
public class GreetingConfig {
	@Bean("personSE")
	public Person personSE() {
		return new Person();
	}
	
	@Bean("personEE")
	public Person personEE() {
		return new Person();
	}
	
	@Bean("english")
	public EnglishGreeting englishGreeting() {
		return new EnglishGreeting();
	}
	
	@Bean("spanish")
	public SpanishGreeting spanishGreeting() {
		return new SpanishGreeting();
	}
}
