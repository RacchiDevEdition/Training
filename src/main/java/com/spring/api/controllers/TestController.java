package com.spring.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.dto.TestDto;
import com.spring.api.models.Teacher;
import com.spring.api.services.TestService;

@RestController
@RequestMapping(value = "/tests")
public class TestController {

	@Autowired
	private TestService service;
				
	@GetMapping
	public List<TestDto> findAll(){
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public List<TestDto> findById(@PathVariable("id")Long id) {
		return service.findByTeacherId(id);
	}
}
