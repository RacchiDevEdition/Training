package com.spring.api.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.spring.api.models.ClassRoom;

public class ClassRoomDto {

	private Long id;
	private char name;
	private List<StudentDto> students = new ArrayList<>();
	private List<TeacherDto> teachers = new ArrayList<>();

	public ClassRoomDto(ClassRoom classRoom) {
		super();
		this.id = classRoom.getId();
		this.name = classRoom.getName();
		this.students = classRoom.getStudents().stream().map(x -> new StudentDto(x)).toList();
		this.teachers = classRoom.getTeachers().stream().map(x -> new TeacherDto(x)).toList();

	}
	
	public ClassRoomDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public char getName() {
		return name;
	}

	public void setName(char name) {
		this.name = name;
	}

	public List<StudentDto> getStudents() {
		return students;
	}

	public List<TeacherDto> getTeachers() {
		return teachers;
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
		ClassRoomDto other = (ClassRoomDto) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ClassRoomDto [id=" + id + ", name=" + name + ", students=" + students + ", teachers=" + teachers + "]";
	}
	
	
	
	
}
