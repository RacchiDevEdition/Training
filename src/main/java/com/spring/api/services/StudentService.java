package com.spring.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.dto.CourseDto;
import com.spring.api.dto.StudentDto;
import com.spring.api.models.Student;
import com.spring.api.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	
	public List<StudentDto> findAll(){
		List<Student> student = repository.findAll();
		List<StudentDto> dto = student.stream().map(x -> new StudentDto(x)).toList();
		return dto;
		
	}
	
	public StudentDto findById(Long id) {
		Student student = repository.findById(id).get();
		StudentDto dto = new StudentDto(student);
		return dto;
	}
	
	
	public List<StudentDto> findByCourse(Long id){
		
		List<Student> course = repository.findByCourse(id);
		List<StudentDto> dto = course.stream().map(x -> new StudentDto(x)).toList();
		for(StudentDto c : dto) {
			if(id.equals(c.getCourse().getId())) {
				return dto;
			}
		}
		return null;
	}

}
