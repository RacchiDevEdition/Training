package com.spring.api.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.api.enums.CourseEnum;
import com.spring.api.models.Course;

public class CourseDto {

	private Long id;
	private String name;
	@JsonIgnore
	private List<StudentDto> students = new ArrayList<>();
	@JsonIgnore
	private List<TeacherDto> teachers = new ArrayList<>();

	private Integer courseType;

	public CourseDto(Long id, String name, CourseEnum courseType) {
		this.id = id;
		this.name = name;
		setCourseType(courseType);

	}

	public CourseDto(Course course) {
		this.id = course.getId();
		this.name = course.getName();
		this.courseType = course.getCourseType().getCode();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setType(String name) {
		this.name = name;
	}

	public List<StudentDto> getStudents() {
		return students;
	}

	public List<TeacherDto> getTeachers() {
		return teachers;
	}

	public CourseEnum getCourseTypeDto() {
		return CourseEnum.valueOf(courseType);
	}

	public void setCourseType(CourseEnum courseType) {
		if (courseType != null) {
			this.courseType = courseType.getCode();
		}
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
		return "CourseDto [id=" + id + ", name=" + name + ", students=" + students + "]";
	}

}
