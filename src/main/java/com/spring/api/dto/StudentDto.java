package com.spring.api.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.api.models.Student;

public class StudentDto {

	private Long id;
	private String name;
	private CourseDto course;
	@JsonIgnore
	private List<TestDto> tests = new ArrayList<>();
	@JsonIgnore
	private ClassRoomDto classRoom;

	public StudentDto(Long id, String name, CourseDto course, ClassRoomDto classRoom) {
		this.id = id;
		this.name = name;
		this.course = course;
		this.classRoom = classRoom;
	}

	public StudentDto(Student student) {
		this.id = student.getId();
		this.name = student.getName();
		this.course = new CourseDto(student.getCourse());
	}

	public StudentDto() {

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

	public ClassRoomDto getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoomDto classRoom) {
		this.classRoom = classRoom;
	}

	public CourseDto getCourse() {
		return course;
	}

	public void setCourse(CourseDto course) {
		this.course = course;
	}

	public List<TestDto> getTests() {
		return tests;
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
		StudentDto other = (StudentDto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "StudentDto [id=" + id + ", name=" + name + ", course=" + course + "]";
	}

}
