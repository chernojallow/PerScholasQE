package com.perscholas.springcore_configuringxml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CourseAssignmentApp {

	public static void main(String[] args) {
		/*
		 * There are several classes to choose from when creating a Spring context, but
		 * here we will use the abstract class AbstractApplicationContext as a reference
		 * class and instantiate a member of the class ClassPathXmlApplicationContext
		 * since we are using XML-based configuration.
		 */
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("/com/perscholas/springcore_configuringxml/BeanDef.xml");

		/*
		 * Next, we retrieve a bean (i.e., instance) of type CourseDescriber. The Spring
		 * context/container provides the instance for us using dependency injection (as
		 * compared to the CourseAssignmentApp class instantiating the bean itself using
		 * the "new" operator). The benefits of this are difficult to appreciate in an
		 * application this small, but we are able to see how the process works and some
		 * of the classes involved. The advantage of dependency injection becomes more
		 * evident as applications are scaled and become more complex.
		 */

		CourseDescriber cd = context.getBean("courseDescriber", CourseDescriber.class);

		Student student1 = new Student("John", "john1234", "ASM");
		Student student2 = new Student("Jane", "jane1234", "QEA");

		System.out.printf("Name: %s\nCourse: %s\nCourse Description: %s\n", student1.getName(), student1.getCourse(),
				cd.getDescription(student1.getCourse()));
		System.out.printf("Name: %s\nCourse: %s\nCourse Description: %s\n", student2.getName(), student2.getCourse(),
				cd.getDescription(student2.getCourse()));
		context.close();
	}

}