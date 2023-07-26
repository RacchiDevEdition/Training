package com.spring.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.dto.CourseDto;
import com.spring.api.dto.StudentDto;
import com.spring.api.models.Course;
import com.spring.api.repositories.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository repository;

	public List<CourseDto> findAll() {
		List<Course> courses = repository.findAll();
		List<CourseDto> dto = courses.stream().map(x -> new CourseDto(x)).toList();
		return dto;
	}

	public CourseDto findById(Long id) {
		Course course = repository.findById(id).get();
		CourseDto dto = new CourseDto(course);
		return dto;
	}


}
