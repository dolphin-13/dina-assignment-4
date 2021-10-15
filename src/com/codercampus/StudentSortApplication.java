package com.codercampus;

import java.io.IOException;

public class StudentSortApplication {

	public static void main(String[] args) throws IOException {

		FileService.getFileOfStudentsByCourse("student-master-list.csv", "course1.csv", "COMPSCI");
		FileService.getFileOfStudentsByCourse("student-master-list.csv", "course2.csv", "STAT");
		FileService.getFileOfStudentsByCourse("student-master-list.csv", "course3.csv", "APMTH");

	}
}
