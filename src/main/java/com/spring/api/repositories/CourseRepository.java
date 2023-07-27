package com.spring.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.api.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	

}