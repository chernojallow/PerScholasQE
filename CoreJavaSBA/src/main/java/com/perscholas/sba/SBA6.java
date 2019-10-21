package com.perscholas.sba;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.perscholas.sba_dao.SBA6CourseDAO;
import com.perscholas.sba_models.SBA6Course;

public class SBA6 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		SBA6CourseDAO c_dao = new SBA6CourseDAO();
		List<SBA6Course> courseList = null;
		
		// Test database connection
		c_dao.testConnection();
		
		// Insert 3 courses into the database
		System.out.println("Insert 3 courses into the database");
		c_dao.addCourse(new SBA6Course(1, "math1", "Algebra 1"));
		c_dao.addCourse(new SBA6Course(2, "eng2", "English 2"));
		c_dao.addCourse(new SBA6Course(3, "hist3", "History 3"));
		
		// Print data from database
		try {
			courseList = c_dao.getAllCourses();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("Current course(s) in the database: ");
		for (SBA6Course c: courseList)
			System.out.printf("\nCourse ID = %d\nCourse Name = %s\nCourse Details = %s\n", 
					c.getId(), c.getName(), c.getDetails());
		
		// Find 1 course by name then print details
		System.out.println("\nFind 1 course by name and print the details of the course");
		String name = "eng2", details = null;
		for (SBA6Course c: courseList) {
			if (c.getName().equals(name))
				details = c.getDetails();
		}
		
		System.out.printf("Course Detail = %s\n", details);
		
		// Update first course
		System.out.println("\nUpdate the first course in the database");
		SBA6Course course = courseList.get(0);
		course.setName("sost");
		course.setDetails("Social Studies");
		c_dao.updateCourse(course);
		
		System.out.printf("\nUpdated Course: \nCourse ID = %d\nCourse Name = %s\nCourse Details = %s\n", 
				course.getId(), course.getName(), course.getDetails());
		
		// Delete course by ID
		System.out.println("Delete a course by ID");
		course = courseList.get(2);
		c_dao.deleteCourse(course);
		System.out.printf("\nDeleted Course: \nCourse ID = %d\nCourse Name = %s\nCourse Details = %s\n", 
				course.getId(), course.getName(), course.getDetails());
		
	}

}
