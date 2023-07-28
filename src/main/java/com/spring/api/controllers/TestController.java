package com.spring.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.dto.TestDto;
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
	public TestDto findById(@PathVariable("id")Long id) {
		return service.findById(id);
	}
	
	@GetMapping(value = "/teacher")
	public List<TestDto> findByTeacherId(@RequestParam(value = "id")Long id) {
		return service.findByTeacherId(id);
	}
	
}
