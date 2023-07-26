package com.spring.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.spring.api.dto.CourseDto;
import com.spring.api.services.CourseService;

@RestController
@RequestMapping(value = "/course")
public class CourseController {

	@Autowired
	private CourseService service;
				
	@GetMapping
	public List<CourseDto> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public CourseDto findById(@PathVariable Long id) {
		return service.findById(id);
	}
}
