package com.spring.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.spring.api.dto.CourseDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String type;
	
	@OneToMany(mappedBy = "course")
	private List<Student> students = new ArrayList<>();

	public Course(Long id, String type) {
		this.id = id;
		this.type = type;
	}

	public Course() {

	}

	public Course(CourseDto course) {
		this.id = course.getId();
		this.type = course.getType();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

	public List<Student> getStudents() {
		return students;
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
		Course other = (Course) obj;
		return Objects.equals(id, other.id);
	}


	@Override
	public String toString() {
		return "Course [id=" + id + ", type=" + type + ", students=" + students + "]";
	}


}
