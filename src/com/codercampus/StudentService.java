package com.codercampus;

import java.io.IOException;

public class StudentService {
	Student[] students = new Student[101];
	String line;

	public Student[] populateStudentsFromFile(String filename) throws IOException {
		String[] studentDetails = FileService.readFile(filename);
		for (int i = 0; i < studentDetails.length; i++) {
			line = studentDetails[i];
			Student student = new Student(line.split(","));
			students[i] = student;
		}
		return students;
	}
}
