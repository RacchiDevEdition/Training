package com.spring.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.spring.api.dto.TestDto;
import com.spring.api.models.Course;
import com.spring.api.models.Student;
import com.spring.api.models.Teacher;
import com.spring.api.models.Test;
import com.spring.api.repositories.CourseRepository;
import com.spring.api.repositories.StudentRepository;
import com.spring.api.repositories.TeacherRepository;
import com.spring.api.repositories.TestRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private TestRepository testRepository;
	
	@Override
	public void run(String... args) throws Exception {
		

		Course c1 = new Course(null, "Math"	);
		Course c2 = new Course(null, "Software Enginnering");
		
		Student s1 = new Student(null, "Raphael", c1);
		Student s2 = new Student(null, "João", c1);
		Student s3 = new Student(null, "Pablo", c2);
		Student s4 = new Student(null, "Guilherme", c2);
		
		Teacher t1 = new Teacher(null, "Jared", "Database");
		Teacher t2 = new Teacher(null, "Akita", "Algorithms");
		Teacher t3 = new Teacher(null, "John", "Statistics");
		Teacher t4 = new Teacher(null, "Andrew", "Geometry");
		
		Test test1 = new Test(10.0, null, t4, s4);
		TestDto tt1 = new TestDto(test1);
		System.out.println(tt1);
		
		c1.getTeachers().add(t4);
		c1.getTeachers().add(t3);
		c2.getTeachers().add(t2);
		c2.getTeachers().add(t1);
		c2.getTeachers().add(t3);
		
		t4.getTest().add(test1);
		s4.getTest().add(test1);
		
	
		teacherRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
		courseRepository.saveAll(Arrays.asList(c1, c2));
		studentRepository.saveAll(Arrays.asList(s1, s2, s3, s4));
		testRepository.save(test1);

	}
}