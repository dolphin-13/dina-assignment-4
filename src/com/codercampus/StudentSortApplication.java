package com.codercampus;

import java.io.IOException;

public class StudentSortApplication {

	public static void main(String[] args) throws IOException {

		FileService.saveFileOfStudentsByCourse("student-master-list.csv", "course1.csv", "COMPSCI");
		FileService.saveFileOfStudentsByCourse("student-master-list.csv", "course2.csv", "STAT");
		FileService.saveFileOfStudentsByCourse("student-master-list.csv", "course3.csv", "APMTH");
		
		//alternative approach
		StudentService service = new StudentService();
		service.generateCourseFiles();

	}
}
