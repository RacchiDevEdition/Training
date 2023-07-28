package com.spring.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.dto.StudentDto;
import com.spring.api.dto.TestDto;
import com.spring.api.models.Course;
import com.spring.api.models.Student;
import com.spring.api.models.Teacher;
import com.spring.api.models.Test;
import com.spring.api.repositories.TestRepository;

@Service
public class TestService {

	@Autowired
	private TestRepository repository;

	public List<TestDto> findAll() {
		List<Test> tests = repository.findAll();
		List<TestDto> dto = tests.stream().map(x -> new TestDto(x)).toList();
		return dto;
	}
	
	public TestDto findById(Long id) {
		Test test = repository.findById(id).get();
		TestDto dto = new TestDto(test);
		return dto;

	}

	public List<TestDto> findByTeacherId(Long id) {
		List<Test> tests = repository.findByTeacherId(id);
		List<TestDto> dto = tests.stream().map(x -> new TestDto(x)).toList();
		return dto;

	}

/*	//need to put verifier later
	public List<TestDto> findTeacherByCourse(Long id) {

	List<Test> Test = repository.findByCourse(id);
		List<TestDto> dto = Test.stream().map(x -> new TestDto(x)).toList();
		return dto;

	}
*/
}
