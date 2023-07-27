package com.spring.api.dto;

import java.util.Objects;

import com.spring.api.models.Student;
import com.spring.api.models.Teacher;
import com.spring.api.models.Test;

public class TestDto {

	private Double grade;
	private String subject;
	private Student student;
	private Teacher teacher;

	public TestDto() {

	}

	public TestDto(Test test) {
		super();
		this.grade = test.getGrade();
		this.subject = test.getSubject();
		this.teacher = test.getTeacher();
		this.student = test.getStudent();
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public int hashCode() {
		return Objects.hash(grade, student, subject, teacher);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestDto other = (TestDto) obj;
		return Objects.equals(grade, other.grade) && Objects.equals(student, other.student)
				&& Objects.equals(subject, other.subject) && Objects.equals(teacher, other.teacher);
	}

	@Override
	public String toString() {
		return "TestDto [grade=" + grade + ", subject=" + subject + ", student=" + student + ", teacher=" + teacher
				+ "]";
	}

}
