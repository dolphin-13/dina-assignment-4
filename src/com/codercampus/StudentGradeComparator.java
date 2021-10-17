package com.codercampus;

import java.util.Comparator;

public class StudentGradeComparator implements Comparator<Student> {

	@Override
	public int compare(Student student1, Student student2) {
		if (student1.getGrade() == null && student2.getGrade() == null) {
			return 0;
		}
		if (student1.getGrade() == null) {
			return 1;
		}
		if (student2.getGrade() == null) {
			return -1;
		}
		return student2.getGrade().compareTo(student1.getGrade());
	}

}
