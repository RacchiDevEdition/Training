package com.spring.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.dto.StudentDto;
import com.spring.api.services.StudentService;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

	@Autowired
	private StudentService services;

	@GetMapping
	public List<StudentDto> findAll() {
		return services.findAll();
	}

	@GetMapping(value = "/{id}")
	public StudentDto findById(@PathVariable Long id) {
		return services.findById(id);
	}

	@GetMapping(value = "/course")
	public List<StudentDto> findByCourse(@RequestParam(value = "id") Long id) {
		if (!id.equals(null)) {
			return services.findByCourse(id);
		}
		return null;
	}
	
	@PostMapping
	@RequestMapping("/create")
	public StudentDto createStudent(@RequestBody StudentDto student) {
		return services.createStudent(student);
	}
}
