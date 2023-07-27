package com.spring.api.models;

import java.util.Objects;

import com.spring.api.pk.TestPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_test")
public class Test {


	@EmbeddedId
	private TestPk id = new TestPk();
	private Double grade;
	private String subject;

	public Test() {

	}

	public Test(Double grade, String subject, Teacher teacher, Student student) {
		super();
		this.grade = grade;
		this.subject = subject;
		id.setTeacher(teacher);
		id.setStudent(student);
	}

	public Teacher getTeacher() {
		return id.getTeacher();
	}

	public void setTeacher(Teacher teacher) {
		id.setTeacher(teacher);
	}

	public Student getStudent() {
		return id.getStudent();
	}

	public void setStudent(Student student) {
		id.setStudent(student);
	}

	public Double getGrade() {
		return grade;
	}

	public void setGrade(Double grade) {
		this.grade = grade;
	}

	public String getSubject() {
		return id.getTeacher().getSubject();
	}

	public void setSubject(String subject) {
		this.subject = id.getTeacher().getSubject();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", grade=" + grade + ", subject=" + subject + "]";
	}

}
