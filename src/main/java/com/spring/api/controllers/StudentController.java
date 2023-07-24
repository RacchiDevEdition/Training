package com.spring.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.dto.StudentDto;
import com.spring.api.services.StudentService;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

	@Autowired
	private StudentService services;
	
	@GetMapping
	public List<StudentDto> findAll(){
		return services.findAll();
	}
	@GetMapping(value = "/{id}")
	public StudentDto findById(@PathVariable Long id) {
		return services.findById(id);
	}
}
