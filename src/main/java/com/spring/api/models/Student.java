package com.spring.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.api.dto.StudentDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Long id;
	private String name;


	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "course_id")
	private Course course;
	
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name = "classRoom_id")
	private ClassRoom classRoom;
	
	@JsonIgnore
	@OneToMany(mappedBy = "student")
	private List<Test> test = new ArrayList<>();	

	public Student(Long id, String name, Course course, ClassRoom classRoom) {
		this.id = id;
		this.name = name;
		this.course = course;
		this.classRoom = classRoom;
	}

	public Student(StudentDto dto) {
		this.id = dto.getId();
		this.name = dto.getName();
		this.course = new Course(dto.getCourse());
	}
	
	public Student() {

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

	public Course getCourse() {
		return course;
	}

	
	public List<Test> getTest() {
		return test;
	}

	
	public ClassRoom getClassRoom() {
		return classRoom;
	}


	public void setClassRoom(ClassRoom classRoom) {
		this.classRoom = classRoom;
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
		Student other = (Student) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", course=" + course + "]";
	}

}
