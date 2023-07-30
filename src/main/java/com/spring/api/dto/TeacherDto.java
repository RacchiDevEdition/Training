package com.spring.api.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.api.models.Teacher;

public class TeacherDto {

	private Long id;
	private String name;
	private String subject;
	private List<CourseDto> courses = new ArrayList<>();
	@JsonIgnore
	private List<TestDto> tests = new ArrayList<>();
	@JsonIgnore
	private List<ClassRoomDto> classRooms = new ArrayList<>();



	public TeacherDto(Teacher teacher) {
		this.id = teacher.getId();
		this.name = teacher.getName();
		this.subject = teacher.getSubject();
		this.courses = teacher.getCourses().stream().map(x -> new CourseDto(x)).toList();
	}

	public TeacherDto() {

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

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public List<CourseDto> getCourses() {
		return courses;
	}

	public List<TestDto> getTests() {
		return tests;
	}

	public List<ClassRoomDto> getClassRooms() {
		return classRooms;
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
		TeacherDto other = (TeacherDto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "TeacherDto [id=" + id + ", name=" + name + ", subject=" + subject + ", courses=" + courses + "]";
	}

}
