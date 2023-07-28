package com.spring.api.models;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_classRoom")
public class ClassRoom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "classroom_id")
	private Long id;
	
	private char name;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "tb_classroom_teacher", joinColumns = @JoinColumn(name = "classroom_id"), inverseJoinColumns = @JoinColumn(name = "teacher_id"))	
	private List<Teacher> teachers;
	@OneToMany(mappedBy = "classRoom", fetch = FetchType.LAZY)
	private List<Student> students;
	

	public ClassRoom(Long id, char name, List<Teacher> teachers, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.teachers = teachers;
		this.students = students;
	}

	public ClassRoom() {

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

	
	public List<Teacher> getTeachers() {
		return teachers;
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
		ClassRoom other = (ClassRoom) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + ", teachers=" + teachers + ", students=" + students +  "]";
	}

}
