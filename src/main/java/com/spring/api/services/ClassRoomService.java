package com.spring.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.dto.TeacherDto;
import com.spring.api.models.ClassRoom;
import com.spring.api.models.Teacher;
import com.spring.api.repositories.ClassRoomRepository;

@Service
public class ClassRoomService {

	@Autowired
	private ClassRoomRepository repository;

	public List<ClassRoom> findAll() {
		List<ClassRoom> tests = repository.findAll();
		// List<TestDto> dto = tests.stream().map(x -> new TestDto(x)).toList();
		return tests;
	}

	public ClassRoom findById(Long id) {
		ClassRoom test = repository.findById(id).get();
		// TestDto dto = new TestDto(test);
		return test;

	}

	public List<ClassRoom> findTeacherByClassId(Long id) {
		List<ClassRoom> classes = repository.findTeacherByClass(id);
		return classes;
	}

	/*
	 * public List<TestDto> findByTeacherId(Long id) { List<Test> tests =
	 * repository.findByTeacherId(id); List<TestDto> dto = tests.stream().map(x ->
	 * new TestDto(x)).toList(); return dto;
	 * 
	 * }
	 */

	/*
	 * //need to put verifier later public List<TestDto> findTeacherByCourse(Long
	 * id) {
	 * 
	 * List<Test> Test = repository.findByCourse(id); List<TestDto> dto =
	 * Test.stream().map(x -> new TestDto(x)).toList(); return dto;
	 * 
	 * }
	 */
}
