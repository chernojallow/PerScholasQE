package org.platform.qeclass;

public class StudentMain {

	public static void main(String[] args) {
		Student linXiao = new Student();
		
		Student.setStudentName("Lin", "Xiao");
		Student.printStudentInfo(linXiao);
	}

}
