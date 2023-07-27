package com.spring.api.pk;

import java.util.Objects;

import org.springframework.data.annotation.Id;

import com.spring.api.models.Student;
import com.spring.api.models.Teacher;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Embeddable
public class TestPk {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teacher_id")
	private Teacher teacher;
	@ManyToOne(fetch = FetchType.LAZY)

	@JoinColumn(name = "student_id")
	private Student student;
	
	
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

	@Override
	public int hashCode() {
		return Objects.hash(student, teacher);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestPk other = (TestPk) obj;
		return Objects.equals(student, other.student) && Objects.equals(teacher, other.teacher);
	}
	
	

}
