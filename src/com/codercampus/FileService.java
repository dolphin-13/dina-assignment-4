package com.codercampus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class FileService {
	static String line;
	static Student[] students;

	public static String[] readFile(String filename) throws IOException {
		String[] lines = new String[101];
		BufferedReader fileReader = null;

		try {
			fileReader = new BufferedReader(new FileReader(filename));
			int i = 0;
			while ((line = fileReader.readLine()) != null) {
				lines[i++] = line;
			}
		} finally {
			if (fileReader != null)
				fileReader.close();
		}
		return lines;
	}

	public static void getFileOfStudentsByCourse(String masterfile, String file, String course) throws IOException {
		StudentService studentService = new StudentService();
		students = studentService.populateStudentsFromFile(masterfile);
		BufferedWriter writer = null;

		try {

			writer = new BufferedWriter(new FileWriter(file));
			writer.write("Student ID,Student Name,Course,Grade\n");
			for (Student student : students) {
				if (student.getCourse().contains(course)) {
					
					Arrays.sort(students, new Comparator<Student>() {

						@Override
						public int compare(Student student1, Student student2) {
							if (student1.getGrade() == null && student2.getGrade() == null) {
								return 0;
							} else if (student1.getGrade() == null) {
								return 1;
							} else if (student2.getGrade() == null) {
								return -1;
							}
							return student2.getGrade().compareTo(student1.getGrade());
						}
					});
					writer.write(student.getStudentID() + "," + student.getStudentName() + "," + student.getCourse()
							+ "," + student.getGrade() + "\n");
				}

			}

		} finally {
			if (writer != null)
				writer.close();
		}

	}

}
