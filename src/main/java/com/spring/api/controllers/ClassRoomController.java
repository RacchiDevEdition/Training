package com.spring.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.api.dto.StudentDto;
import com.spring.api.models.ClassRoom;
import com.spring.api.services.ClassRoomService;

@RestController
@RequestMapping(value = "/classrooms")
public class ClassRoomController {

	@Autowired
	private ClassRoomService services;

	@GetMapping
	public List<ClassRoom> findAll() {
		return services.findAll();
	}

	@GetMapping(value = "/{id}")
	public ClassRoom findById(@PathVariable Long id) {
		return services.findById(id);
	}

	@GetMapping(value = "/teachers")
	public List<ClassRoom> findTeachersByClass(@RequestParam("id") Long id) {
		return services.findTeacherByClassId(id);
	}

/*	@GetMapping(value = "/course")
	public List<StudentDto> findByCourse(@RequestParam(value = "id") Long id) {
		if (!id.equals(null)) {
			return services.findByCourse(id);
		}
		return null;
	}*/
}
