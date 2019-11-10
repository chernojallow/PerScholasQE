package com.perscholas.spring_core_ex2.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.perscholas.spring_core_ex2.config.GreetingConfig;
import com.perscholas.spring_core_ex2.models.Person;

public class GreetingApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(GreetingConfig.class);
		Person p1 = context.getBean("personSE", Person.class);
		p1.setName("Chen");

		Person p2 = context.getBean("personEE", Person.class);
		p2.setName("Ivell");
		
		System.out.println(p1.getName());
		System.out.println(p1.getGreetingService().sayHello());
		System.out.println(p1.getGreetingService().sayWelcome());

		System.out.println(p2.getName());
		System.out.println(p2.getGreetingService().sayHello());
		System.out.println(p2.getGreetingService().sayWelcome());
		
		context.close();
	}

}
