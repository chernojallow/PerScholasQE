package com.perscholas.spring_core_ex2.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.perscholas.spring_core_ex2.models.Person;

public class GreetingApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"/com/perscholas/spring_core_ex2/bean_def/BeanDef.xml");
		Person p1 = context.getBean("personE", Person.class);
		p1.setName("Chen");

		Person p2 = context.getBean("personS", Person.class);
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
