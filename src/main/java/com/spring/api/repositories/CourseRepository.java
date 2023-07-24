package com.spring.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.api.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	
	@Query(nativeQuery = true, value = "SELECT * FROM TB_COURSE WHERE ID = ?")
	List<Course> findByCourse(Long id);

}