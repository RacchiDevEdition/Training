package com.spring.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.dto.TeacherDto;
import com.spring.api.services.TeacherService;

@RestController
@RequestMapping(value = "/teachers")
public class TeacherController {

	@Autowired
	private TeacherService service;

	@GetMapping
	public List<TeacherDto> findAll() {
		return service.findAll();
	}

	@GetMapping(value = "/{id}")
	public TeacherDto findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@GetMapping(value = "/course")
	public List<TeacherDto> findByCourse(@RequestParam(value = "id") Long id) {
		if (!id.equals(null)) {
			return service.findTeacherByCourse(id);
		}
		return null;
	}
}
