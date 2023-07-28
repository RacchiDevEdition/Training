package com.spring.api.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.api.dto.CourseDto;
import com.spring.api.enums.CourseEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@OneToMany(mappedBy = "course")
	private List<Student> students = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "tb_course_teacher", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "teacher_id"))
	private List<Teacher> teachers = new ArrayList<>();

	private Integer courseEnum;

	public Course(Long id, String name, CourseEnum courseType) {
		this.id = id;
		this.name = name;
		this.courseEnum = courseType.getCode();

	}

	public Course() {

	}

	public Course(CourseDto course) {
		this.id = course.getId();
		this.name = course.getName();
		this.courseEnum = course.getCourseTypeDto().getCode();
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

	public CourseEnum getCourseType() {
		return CourseEnum.valueOf(courseEnum);
	}

	public void setCourseType(CourseEnum courseEnum) {
		if (courseEnum != null) {
			this.courseEnum = courseEnum.getCode();
		}
	}

	@JsonIgnore
	public List<Student> getStudents() {
		return students;
	}

	@JsonIgnore
	public List<Teacher> getTeachers() {
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
		Course other = (Course) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", students=" + students + "]";
	}

}
