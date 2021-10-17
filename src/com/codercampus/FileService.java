package com.codercampus;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

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
			for (int i = 1; i < students.length; i++) {
				if (students[i].getCourse().contains(course)) {
					Arrays.sort(students, new StudentGradeComparator());
					writer.append(students[i].getStudentID() + "," + students[i].getStudentName() + ","
							+ students[i].getCourse() + "," + students[i].getGrade() + "\n");
				}
			}

		} finally {
			if (writer != null)
				writer.close();
		}
	}
}
