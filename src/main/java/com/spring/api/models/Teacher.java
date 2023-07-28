package com.spring.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.api.dto.TeacherDto;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String subject;
	
	@ManyToMany(mappedBy = "teachers", fetch = FetchType.LAZY)
	private List<Course> courses = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy = "teachers", fetch = FetchType.LAZY)
	private List<ClassRoom> classes = new ArrayList<>();
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "teacher")
	private List<Test> test = new ArrayList<>();		

	public Teacher(Long id, String name, String subject) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
	}

	public Teacher() {
	}
	
	public Teacher(TeacherDto teacher) {
		this.id = teacher.getId();
		this.name = teacher.getName();
		this.subject = teacher.getSubject();
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

	public List<Course> getCourses() {
		return courses;
	}

	
	public List<Test> getTest() {
		return test;
	}

	@JsonIgnore
	public List<ClassRoom> getClasses() {
		return classes;
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
		Teacher other = (Teacher) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", subject=" + subject + ", courses=" + courses + "]";
	}

}
