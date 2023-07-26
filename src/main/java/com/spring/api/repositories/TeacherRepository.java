package com.spring.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.spring.api.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM TB_TEACHER INNER JOIN TB_COURSE_TEACHER ON TEACHER_ID = ID WHERE COURSE_ID = ?")	
	List<Teacher> findByCourse(Long id);


}
