package com.spring.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.api.dto.ClassRoomDto;
import com.spring.api.models.ClassRoom;
import com.spring.api.repositories.ClassRoomRepository;

@Service
public class ClassRoomService {

	@Autowired
	private ClassRoomRepository repository;

	public List<ClassRoomDto> findAll() {
		List<ClassRoom> tests = repository.findAll();
		List<ClassRoomDto> dto = tests.stream().map(x -> new ClassRoomDto(x)).toList();
		return dto;
	}

	public ClassRoomDto findById(Long id) {
		ClassRoom test = repository.findById(id).get();
		ClassRoomDto dto = new ClassRoomDto(test);
		return dto;

	}

	public List<ClassRoomDto> findTeacherByClassId(Long id) {
		List<ClassRoom> classes = repository.findTeacherByClass(id);
		List<ClassRoomDto> dto = classes.stream().map(x -> new ClassRoomDto(x)).toList();
		return dto;
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
