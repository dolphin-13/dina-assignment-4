package com.codercampus;

import java.io.IOException;
import java.util.Arrays;

public class StudentService {
	Student[] students = null;
	String line;

	public Student[] populateStudentsFromFile(String filename) throws IOException {
		students = new Student[101];
		String[] studentDetails = FileService.readFile(filename);
		for (int i = 0; i < studentDetails.length; i++) {
			line = studentDetails[i];
			Student student = new Student(line.split(","));
			students[i] = student;
		}
		return students;
	}
	
	public void generateCourseFiles() throws IOException {
		if(students == null) {
			students = populateStudentsFromFile("student-master-list.csv");
			// sort once
			Arrays.sort(students, new StudentGradeComparator()); 
		}
		
		Student[] compsciStudents = new Student[100];
		Student[] statStudents = new Student[100];
		Student[] apStudents = new Student[100];
		int csCtr = 0, statCtr = 0, apCtr = 0; //initialize counters
		for(int i = 0; i < students.length; i++) {
			if(students[i].getCourse().contains("COMPSCI")) { //add to compsci students
				compsciStudents[csCtr] = students[i];
				csCtr++;
			} else if (students[i].getCourse().contains("STAT")) { //add to stat students
				statStudents[statCtr] = students[i];
				statCtr++;
			} else if (students[i].getCourse().contains("APMTH")) {
				apStudents[apCtr] = students[i];
				apCtr++;
			}
		}
		
		FileService.writeStudentsToFile(compsciStudents, "course1-new.csv");
		FileService.writeStudentsToFile(statStudents, "course2-new.csv");
		FileService.writeStudentsToFile(apStudents, "course3-new.csv");
	}
	
	
}
