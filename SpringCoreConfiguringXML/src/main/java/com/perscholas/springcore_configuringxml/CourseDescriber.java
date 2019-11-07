package com.perscholas.springcore_configuringxml;

public class CourseDescriber {
	private String description;

	public CourseDescriber() {
	}

	public String getDescription(String courseName) {
		if (courseName.equals("ASM")) {
			this.description = "Application Support Management: Course to train "
					+ "individuals to fulfill the role of application support "
					+ "specialist providing support to end users of " + "enterprise software.";
		} else if (courseName.equals("DE")) {
			this.description = "Data Engineering: Course to train individuals to"
					+ "fulfill the role of big data analyzer.";
		} else if (courseName.equals("QEA")) {
			this.description = "Quality Engineering and Assurance: "
					+ "Course to train individuals to fulfill the role of "
					+ "quality engineer with an emphasis in automation testing.";
		}
		return description;
	}
}
