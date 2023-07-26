package com.spring.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.dto.StudentDto;
import com.spring.api.dto.TeacherDto;
import com.spring.api.models.Student;
import com.spring.api.models.Teacher;
import com.spring.api.repositories.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository repository;

	public List<TeacherDto> findAll() {
		List<Teacher> teachers = repository.findAll();
		List<TeacherDto> dto = teachers.stream().map(x -> new TeacherDto(x)).toList();
		return dto;
	}

	public TeacherDto findById(Long id) {
		Teacher teacher = repository.findById(id).get();
		TeacherDto dto = new TeacherDto(teacher);
		return dto;

	}

	//need to put verifier later
	public List<TeacherDto> findTeacherByCourse(Long id) {

		List<Teacher> teacher = repository.findByCourse(id);
		List<TeacherDto> dto = teacher.stream().map(x -> new TeacherDto(x)).toList();
		return dto;

	}

}
