package com.spring.api.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.spring.api.dto.TestDto;
import com.spring.api.enums.CourseEnum;
import com.spring.api.models.ClassRoom;
import com.spring.api.models.Course;
import com.spring.api.models.Student;
import com.spring.api.models.Teacher;
import com.spring.api.models.Test;
import com.spring.api.repositories.ClassRoomRepository;
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
	
	@Autowired
	private ClassRoomRepository classRepository;
	
	@Override
	public void run(String... args) throws Exception {
		

		Course c1 = new Course(null, "Aplicated Math", CourseEnum.MATH);
		Course c2 = new Course(null, "Software Enginnering", CourseEnum.INFORMATICS);
		
		Student s1 = new Student(null, "Raphael", c1, null);
		Student s2 = new Student(null, "João", c1, null);
		Student s3 = new Student(null, "Pablo", c2, null);
		Student s4 = new Student(null, "Guilherme", c2, null);
		
		Teacher t1 = new Teacher(null, "Jared", "Database");
		Teacher t2 = new Teacher(null, "Akita", "Algorithms");
		Teacher t3 = new Teacher(null, "John", "Statistics");
		Teacher t4 = new Teacher(null, "Andrew", "Geometry");
		
		List<Teacher> listT = Arrays.asList(t1, t2, t3);
		List<Student> listS = Arrays.asList(s3,s4);
		List<Teacher> listT2 = Arrays.asList(t3, t4);
		List<Student> listS2 = Arrays.asList(s1, s2);


		
		Test test1 = new Test(10.0, null, t4, s4);
		Test test2 = new Test(6.0, null, t3, s3);
		Test test3 = new Test(7.0, null, t4, s2);
		Test test4 = new Test(6.5, null, t2, s1);
		Test test5 = new Test(8.0, null, t4, s3);
		
	
		ClassRoom cr1 = new ClassRoom(null, 'A', listT, listS);
		ClassRoom cr2 = new ClassRoom(null, 'B', listT2, listS2);
		s3.setClassRoom(cr1);
		s4.setClassRoom(cr1);
		s1.setClassRoom(cr2);
		s2.setClassRoom(cr2);
		
	

		TestDto tt1 = new TestDto(test1);
		System.out.println(tt1);
		
		c1.getTeachers().add(t4);
		c1.getTeachers().add(t3);
		c2.getTeachers().add(t2);
		c2.getTeachers().add(t1);
		c2.getTeachers().add(t3);
		
	
		t4.getTest().add(test1);
		s4.getTest().add(test1);
		t4.getTest().add(test2);
		
		t1.getClasses().add(cr1);
		t2.getClasses().add(cr1);
		t3.getClasses().add(cr2);
		t3.getClasses().add(cr2);
		
	
		teacherRepository.saveAll(Arrays.asList(t1, t2, t3, t4));
		courseRepository.saveAll(Arrays.asList(c1, c2));
		studentRepository.saveAll(Arrays.asList(s1, s2, s3, s4));
		testRepository.saveAll(Arrays.asList(test1,test2,test3,test4,test5));
		classRepository.saveAll(Arrays.asList(cr1, cr2));

	}
}