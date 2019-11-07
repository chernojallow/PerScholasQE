package com.perscholas.spring_core_ex1.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.perscholas.spring_core_ex1.models.SpringGreeting;

public class SpringGreetingApp {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"/com/perscholas/spring_core_ex1/bean_def/BeanDef.xml");
		SpringGreeting sg = context.getBean("springGreeting", SpringGreeting.class);

		String str = sg.helloSpring();
		System.out.println(str);

		context.close();
	}
}
