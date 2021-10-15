package com.codercampus;

public class Student {
	private String studentID;
	private String studentName;
	private String course;
	private String grade;

	Student(String[] info) {
		this.studentID = info[0];
		this.studentName = info[1];
		this.course = info[2];
		this.grade = info[3];
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
