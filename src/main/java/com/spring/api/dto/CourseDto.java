package com.spring.api.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.api.models.Course;

public class CourseDto {

	private Long id;
	private String type;
	@JsonIgnore
	private List<StudentDto> students = new ArrayList<>();

	public CourseDto(Long id, String name) {
		this.id = id;
		this.type = name;
	}

	public CourseDto(Course course) {
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

	public List<StudentDto> getStudents() {
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
		CourseDto other = (CourseDto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "CourseDto [id=" + id + ", type=" + type + ", students=" + students + "]";
	}
	
	

}
