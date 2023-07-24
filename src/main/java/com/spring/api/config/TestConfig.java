package com.spring.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.spring.api.models.Course;
import com.spring.api.models.Student;
import com.spring.api.repositories.CourseRepository;
import com.spring.api.repositories.StudentRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		

		Course c1 = new Course(null, "Math");
		Course c2 = new Course(null, "History");
		
		Student s1 = new Student(null, "Raphael", c1);
		Student s2 = new Student(null, "João", c1);
		Student s3 = new Student(null, "Pablo", c2);
		Student s4 = new Student(null, "Guilherme", c2);
		
	
		courseRepository.saveAll(Arrays.asList(c1, c2));

		studentRepository.saveAll(Arrays.asList(s1, s2, s3, s4));

	}
}