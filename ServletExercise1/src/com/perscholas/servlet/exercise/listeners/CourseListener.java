package com.perscholas.servlet.exercise.listeners;

import java.time.LocalDateTime;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CourseListener implements ServletRequestAttributeListener {
	@Override
	public void attributeAdded(ServletRequestAttributeEvent event) {
		System.out.println("Request attribute added at: " + LocalDateTime.now());
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent event) {
		System.out.println("Request attribute removed at: " + LocalDateTime.now());
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent event) {
		System.out.println("Attribute replaced at: " + LocalDateTime.now());
	}
}
